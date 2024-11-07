package HVLO.TEXTRPG.user.service;

import HVLO.TEXTRPG.equipment.service.EquipmentService;
import HVLO.TEXTRPG.global.constants.*;
import HVLO.TEXTRPG.global.security.EncryptionUtil;
import HVLO.TEXTRPG.global.security.JwtUtil;
import HVLO.TEXTRPG.global.exception.GlobalException;
import HVLO.TEXTRPG.job.entity.ActiveSkill;
import HVLO.TEXTRPG.job.entity.Job;
import HVLO.TEXTRPG.job.entity.PassiveSkill;
import HVLO.TEXTRPG.job.repository.ActiveSkillRepository;
import HVLO.TEXTRPG.job.repository.JobRepository;
import HVLO.TEXTRPG.job.repository.PassiveSkillRepository;
import HVLO.TEXTRPG.job.service.JobService;
import HVLO.TEXTRPG.user.dto.*;
import HVLO.TEXTRPG.user.entity.*;
import HVLO.TEXTRPG.user.mapper.*;
import HVLO.TEXTRPG.user.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserStatsRepository userStatsRepository;
    private final UserEquipmentRepository userEquipmentRepository;
    private final UserLogRepository userLogRepository;
    private final EquipmentService equipmentService;
    private final JobService jobService;
    private final UserAchievementsRepository userAchievementsRepository;
    private final UserMasteryRepository userMasteryRepository;
    private final JwtUtil jwtUtil;
    private final UserCombatStatusService userCombatStatusService;

    public final String TIME = "time";
    private final UserFieldRepository userFieldRepository;
    private final JobRepository jobRepository;
    private final PassiveSkillRepository passiveSkillRepository;
    private final ActiveSkillRepository activeSkillRepository;

    // 회원가입
    @Transactional
    public void createUser(SignUpRequestDTO dto) {
        validateSignUp(dto);
        User target = SignUpMapper.toEntity(dto);
        // 암호화
        String salt = EncryptionUtil.generateSalt();
        target.setSalt(salt);
        target.setPassword(EncryptionUtil.hashPassword(dto.getPassword(), salt));
        User savedUser = userRepository.save(target);
        saveRelativeEntity(savedUser);
    }

    // 로그인
    @Transactional
    public AccessTokenDTO login(LogInRequestDTO loginRequestDTO) {
        User target = userRepository.findByLoginId(loginRequestDTO.getLoginId())
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND));

        boolean verified = verifyPassword(target, loginRequestDTO.getPassword());
        if (verified) {
            // 로그인 성공 로직
            logUpdate(loginRequestDTO, target);
            return new AccessTokenDTO(jwtUtil.generateToken(target), jwtUtil.generateRefreshToken(target), target.getId());
        } else {
            throw new GlobalException(ErrorCode.PASSWORDS_DO_NOT_MATCH);
        }
    }

    // 리프레시 토큰 검증
    public AccessTokenDTO refreshAccessToken(AccessTokenDTO accessTokenDTO) {
        String refreshToken = accessTokenDTO.getRefresh_token();
        String loginId = jwtUtil.extractLoginId(refreshToken);
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND));
        // 검증 로직
        if (jwtUtil.validateToken(refreshToken, user)) {
            // 검증 성공
            String newAccessToken = jwtUtil.generateToken(user);
            accessTokenDTO.setAccess_token(newAccessToken);
            return accessTokenDTO;
        } else {
            throw new GlobalException(ErrorCode.INVALID_REFRESH_TOKEN);
        }
    }

    // 관계있는 엔티티 같이 생성
    private void saveRelativeEntity(User savedUser) {
        UserStats userStats = new UserStats();
        userStats.setUserId(savedUser.getId());
        userStatsRepository.save(userStats);
        UserAchievements userAchievements = new UserAchievements();
        userAchievements.setUserId(savedUser.getId());
        userAchievementsRepository.save(userAchievements);
        UserMastery userMastery = new UserMastery(savedUser.getId(), 1L, JobStatus.RUNNING, 1L, 1L, SkillStatus.RUNNING, SkillStatus.RUNNING);
        userMasteryRepository.save(userMastery);
        UserEquipment userEquipment = new UserEquipment(savedUser.getId(), 1L, true, EquipmentGrade.COMMON);
        userEquipmentRepository.save(userEquipment);

        UserField userField1 = new UserField(savedUser.getId(), 1L, FieldStatus.UNLOCKED);
        userFieldRepository.save(userField1);
        UserField userField2 = new UserField(savedUser.getId(), 2L, FieldStatus.UNLOCKED);
        userFieldRepository.save(userField2);
    }

    // 유효성 검사
    private void validateSignUp(SignUpRequestDTO dto) {
        if (userRepository.existsByLoginId(dto.getLoginId())) {
            throw new GlobalException(ErrorCode.ID_ALREADY_EXISTS);
        }
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new GlobalException(ErrorCode.NICKNAME_ALREADY_EXISTS);
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new GlobalException(ErrorCode.PASSWORDS_DO_NOT_MATCH);
        }
    }

    // 로그인 로그 업데이트
    private void logUpdate(LogInRequestDTO loginRequestDTO, User target) {
        UserLog userLog = new UserLog();
        userLog.setUserId(target.getId());
        userLog.setTime(LocalDateTime.now());
        userLog.setIP(loginRequestDTO.getIP());
        userLogRepository.save(userLog);
    }

    // 비밀번호 확인
    public boolean verifyPassword(User user, String inputPassword) {
        String hashedInputPassword = EncryptionUtil.hashPassword(inputPassword, user.getSalt());
        return user.getPassword().equals(hashedInputPassword);
    }

    // HP 업데이트
    @Transactional
    public void updateUserHp(HPUpdateDTO updateDTO) {
        UserStats userStats = userStatsRepository.findByUserId(updateDTO.getUserId())
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_STATS_NOT_FOUND));
        userStats.setHp(updateDTO.getNewHp());
        userStats.setCurrentActionPoints(userStats.getCurrentActionPoints() - 1);
        userStatsRepository.save(userStats);
    }

    // EXP 업데이트
    @Transactional
    public void updateUserEXP(EXPUpdateDTO updateDTO) {
        List<UserMastery> masteries = userMasteryRepository.findByUserId(updateDTO.getUserId());
        List<UserMastery> updatedMasteries = new ArrayList<>();

        // 직업 숙련도 업데이트
        for (UserMastery mastery : masteries) {
            if (mastery.getJobStatus() == JobStatus.RUNNING) {
                Job job = jobRepository.findById(mastery.getJobId())
                        .orElseThrow(() -> new GlobalException(ErrorCode.JOB_NOT_FOUND));
                mastery.setJobMasteryEXP(mastery.getJobMasteryEXP() + updateDTO.getQuantity());

                if (mastery.getJobMasteryEXP() >= job.getMastery()) {
                    mastery.setJobMasteryEXP(job.getMastery());
                    mastery.setJobStatus(JobStatus.MASTER_RUNNING);
                }
                updatedMasteries.add(mastery); // 변경 사항을 추가
            }
        }
        // 패시브 숙련도 업데이트
        for (UserMastery mastery : masteries) {
            if (mastery.getPassiveSkillStatus() == SkillStatus.RUNNING &&
                    (mastery.getJobStatus() == JobStatus.RUNNING ||
                            mastery.getJobStatus() == JobStatus.MASTER_RUNNING ||
                            mastery.getJobStatus() == JobStatus.MASTER)) {

                PassiveSkill passiveSkill = passiveSkillRepository.findById(mastery.getPassiveSkillId())
                        .orElseThrow(() -> new GlobalException(ErrorCode.PASSIVE_SKILL_NOT_FOUND));
                mastery.setPassiveSkillMasteryEXP(mastery.getPassiveSkillMasteryEXP() + updateDTO.getQuantity());

                if (mastery.getPassiveSkillMasteryEXP() >= passiveSkill.getMastery()) {
                    mastery.setPassiveSkillMasteryEXP(passiveSkill.getMastery());
                    if (passiveSkill.getNextSkillId() != null) {
                        mastery.setPassiveSkillStatus(SkillStatus.MASTER);
                        mastery.setPassiveSkillId(passiveSkill.getNextSkillId());
                    } else {
                        mastery.setPassiveSkillStatus(SkillStatus.MASTER_RUNNING);
                    }
                }
                updatedMasteries.add(mastery);
            }
        }
        // 액티브 숙련도 업데이트
        for (UserMastery mastery : masteries) {
            if (mastery.getActiveSkillStatus() == SkillStatus.RUNNING &&
                    (mastery.getJobStatus() == JobStatus.RUNNING ||
                            mastery.getJobStatus() == JobStatus.MASTER_RUNNING ||
                            mastery.getJobStatus() == JobStatus.MASTER)) {

                ActiveSkill activeSkill = activeSkillRepository.findById(mastery.getActiveSkillId())
                        .orElseThrow(() -> new GlobalException(ErrorCode.ACTIVE_SKILL_NOT_FOUND));
                mastery.setActiveSkillMasteryEXP(mastery.getActiveSkillMasteryEXP() + updateDTO.getQuantity());

                if (mastery.getActiveSkillMasteryEXP() >= activeSkill.getMastery()) {
                    mastery.setActiveSkillMasteryEXP(activeSkill.getMastery());
                    if (activeSkill.getNextSkillId() != null) {
                        mastery.setActiveSkillStatus(SkillStatus.MASTER);
                        mastery.setActiveSkillId(activeSkill.getNextSkillId());
                    } else {
                        mastery.setActiveSkillStatus(SkillStatus.MASTER_RUNNING);
                    }
                }
                updatedMasteries.add(mastery);
            }
        }
        userMasteryRepository.saveAll(updatedMasteries);
    }

    // TODO : Achievement 업데이트
    public void updateUserCombatAchievement(AchieveUpdateDTO updateDTO) {
        UserAchievements userAchievements = userAchievementsRepository.findByUserId(updateDTO.getUserId())
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_ACHIEVEMENTS_NOT_FOUND));
        userAchievements.setTotalDamage(userAchievements.getTotalDamage() + updateDTO.getTotalDamage());
        if(updateDTO.getMaxDamage() > userAchievements.getMaxDamage()){
            userAchievements.setMaxDamage(updateDTO.getMaxDamage());
        }
        userAchievements.setKillCount(userAchievements.getKillCount() + updateDTO.getKillCount());
        userAchievementsRepository.save(userAchievements);
    }

    public ActionPointDTO getActionPoints(Long userId) {
        return userStatsRepository.findActionPointDTOByUserId(userId)
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_STATS_NOT_FOUND));
    }


    // 행동력
    @Transactional
    public ActionPointDTO updateActionPoints(Long userId) {
        UserStats userStats = userStatsRepository.findByUserId(userId)
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_STATS_NOT_FOUND));
        if(userStats.getCurrentActionPoints() + 1 <= userStats.getMaxActionPoints()){
            userStats.setCurrentActionPoints(userStats.getCurrentActionPoints() + 1);
            userStatsRepository.save(userStats);
        }
        ActionPointDTO dto = new ActionPointDTO();
        dto.setUserId(userId);
        dto.setCurrentActionPoints(userStats.getCurrentActionPoints());
        dto.setMaxActionPoints(userStats.getMaxActionPoints());
        return dto;
    }


    public Long getUserId(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        return jwtUtil.extractId(token);
    }

    public UserDTO getUserDTO(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND));
        UserDTO dto = new UserDTO();
        dto.setUserid(user.getId());
        dto.setUsername(user.getUsername());
        dto.setUserStats(getUserStatsDTO(userId));
        dto.setAchievements(getUserAchievementsDTO(userId));
        dto.setLogs(getUserLogDTOs(userId));
        dto.setFields(getUserFieldDTOs(userId));
        dto.setEquipments(getUserEquipmentDTO(userId));
        dto.setMastery(getUserMasteryDTO(userId));
        dto.setCombat(userCombatStatusService.getUserCombat(dto));
        return dto;
    }

    public UserStatsDTO getUserStatsDTO(Long userId) {
        return userStatsRepository.findUserStatsDTOByUserId(userId)
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_STATS_NOT_FOUND));
    }

    public UserAchievementsDTO getUserAchievementsDTO(Long userId) {
        return userAchievementsRepository.findUserAchievementsDTOByUserId(userId)
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_ACHIEVEMENTS_NOT_FOUND));
    }

    public List<UserLogDTO> getUserLogDTOs(Long userId) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, TIME));
        Page<UserLog> userLogs = userLogRepository.findByUserId(userId, pageable);
        return userLogs.stream().map(UserLogMapper::toDto).collect(Collectors.toList());
    }

    public List<UserFieldDTO> getUserFieldDTOs(Long userId) {
        List<UserField> fields = userFieldRepository.findByUserId(userId);
        return fields.stream().map(UserFieldMapper::toDTO).collect(Collectors.toList());
    }

    public List<UserEquipmentDTO> getUserEquipmentDTO(Long userId) {
        List<UserEquipment> equipments = userEquipmentRepository.findByUserId(userId);
        return equipments.stream().map(userEquipment -> UserEquipmentMapper.toDTO(userEquipment,
                        equipmentService.findEquipmentById(userEquipment.getEquipmentId())))
                .collect(Collectors.toList());
    }

    public List<UserMasteryDTO> getUserMasteryDTO(Long userId) {
        List<UserMastery> masteries = userMasteryRepository.findByUserId(userId);
        return masteries.stream().map(userMastery -> UserMasteryMapper.toDTO(userMastery, jobService.getJobDTOById(userMastery.getJobId(), userMastery.getPassiveSkillId(), userMastery.getActiveSkillId())))
                .collect(Collectors.toList());
    }



}
