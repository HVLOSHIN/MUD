package HVLO.TEXTRPG.user.service;

import HVLO.TEXTRPG.equipment.service.EquipmentService;
import HVLO.TEXTRPG.global.constants.ErrorCode;
import HVLO.TEXTRPG.global.exception.GlobalException;
import HVLO.TEXTRPG.job.service.JobService;
import HVLO.TEXTRPG.user.dto.*;
import HVLO.TEXTRPG.user.entity.UserEquipment;
import HVLO.TEXTRPG.user.entity.UserLog;
import HVLO.TEXTRPG.user.entity.UserMastery;
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
    private final UserStatsRepository userStatsRepository;
    private final UserEquipmentRepository userEquipmentRepository;
    private final UserLogRepository userLogRepository;
    private final EquipmentService equipmentService;
    private final JobService jobService;
    private final UserAchievementsRepository userAchievementsRepository;
    private final UserMasteryRepository userMasteryRepository;


    public UserDTO getUserDTO(Long userId){
        UserDTO dto = new UserDTO();
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
        return equipments.stream().map(userEquipment -> {
            return UserEquipmentMapper.toDTO(userEquipment, equipmentService.findEquipmentById(userEquipment.getEquipmentId()));
        }).collect(Collectors.toList());
    }

    public List<UserMasteryDTO> getUserMasteryDTO(Long userId) {
        List<UserMastery> masteries = userMasteryRepository.findByUserId(userId);
        return masteries.stream().map(userMastery -> {
            return UserMasteryMapper.toDTO(userMastery, jobService.getJobDTOById(userMastery.getJobId()));
        }).collect(Collectors.toList());


    }



}
