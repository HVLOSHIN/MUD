package HVLO.TEXTRPG.user.service;

import HVLO.TEXTRPG.equipment.service.EquipmentService;
import HVLO.TEXTRPG.global.EncryptionUtil;
import HVLO.TEXTRPG.global.constants.ErrorCode;
import HVLO.TEXTRPG.global.exception.GlobalException;
import HVLO.TEXTRPG.job.service.JobService;
import HVLO.TEXTRPG.user.dto.*;
import HVLO.TEXTRPG.user.entity.*;
import HVLO.TEXTRPG.user.mapper.SignUpMapper;
import HVLO.TEXTRPG.user.mapper.UserEquipmentMapper;
import HVLO.TEXTRPG.user.mapper.UserLogMapper;
import HVLO.TEXTRPG.user.mapper.UserMasteryMapper;
import HVLO.TEXTRPG.user.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    // 회원가입
    public User createUser(SignUpRequestDTO dto) {
        validateSignUp(dto);
        User target = SignUpMapper.toEntity(dto);
        // 암호화
        String salt = EncryptionUtil.generateSalt();
        target.setSalt(salt);
        target.setPassword(EncryptionUtil.hashPassword(dto.getPassword(), salt));
        User savedUser = userRepository.save(target);
        saveRelativeEntity(savedUser);
        return savedUser;
    }

    // 관계있는 엔티티 같이 생성
    private void saveRelativeEntity(User savedUser) {
        UserStats userStats = new UserStats();
        userStats.setUserId(savedUser.getId());
        userStatsRepository.save(userStats);

        UserAchievements userAchievements = new UserAchievements();
        userAchievements.setUserId(savedUser.getId());
        userAchievementsRepository.save(userAchievements);
    }

    // 유효성 검사
    private void validateSignUp(SignUpRequestDTO dto) {
        if(userRepository.existsByLoginId(dto.getLoginId())) {
            throw new GlobalException(ErrorCode.ID_ALREADY_EXISTS);
        }
        if(userRepository.existsByUsername(dto.getUsername())) {
            throw new GlobalException(ErrorCode.NICKNAME_ALREADY_EXISTS);
        }
        if(!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new GlobalException(ErrorCode.PASSWORDS_DO_NOT_MATCH);
        }
    }

    // 비밀번호 확인
    public boolean verifyPassword(User user, String inputPassword) {
        String hashedInputPassword = EncryptionUtil.hashPassword(inputPassword, user.getSalt());
        return user.getPassword().equals(hashedInputPassword);
    }


    public UserUnitedDTO getUserDTO(Long userId){
        UserUnitedDTO dto = new UserUnitedDTO();
        dto.setUserStats(getUserStatsDTO(userId));
        dto.setAchievements(getUserAchievementsDTO(userId));
        dto.setLogs(getUserLogDTOs(userId));
        dto.setEquipments(getUserEquipmentDTO(userId));
        dto.setMastery(getUserMasteryDTO(userId));

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
        List<UserLog> userLogs = userLogRepository.findByUserId(userId);
        return userLogs.stream().map(UserLogMapper::toDto).collect(Collectors.toList());
    }

    public List<UserEquipmentDTO> getUserEquipmentDTO(Long userId) {
        List<UserEquipment> equipments = userEquipmentRepository.findByUserId(userId);
        return equipments.stream().map(userEquipment -> UserEquipmentMapper.toDTO(userEquipment,
                        equipmentService.findEquipmentById(userEquipment.getEquipmentId())))
                .collect(Collectors.toList());
    }

    public List<UserMasteryDTO> getUserMasteryDTO(Long userId) {
        List<UserMastery> masteries = userMasteryRepository.findByUserId(userId);
        return masteries.stream().map(userMastery -> UserMasteryMapper.toDTO(userMastery,
                jobService.getJobDTOById(userMastery.getJobId()))).collect(Collectors.toList());
    }
}
