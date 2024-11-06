package HVLO.TEXTRPG.user.service;

import HVLO.TEXTRPG.equipment.dto.EquipmentEffectDTO;
import HVLO.TEXTRPG.global.constants.EffectType;
import HVLO.TEXTRPG.global.constants.JobStatus;
import HVLO.TEXTRPG.global.constants.SkillStatus;
import HVLO.TEXTRPG.job.dto.JobEffectDTO;
import HVLO.TEXTRPG.job.dto.PassiveSkillDTO;
import HVLO.TEXTRPG.job.dto.PassiveSkillEffectDTO;
import HVLO.TEXTRPG.user.dto.UserCombatDTO;
import HVLO.TEXTRPG.user.dto.UserDTO;
import HVLO.TEXTRPG.user.dto.UserEquipmentDTO;
import HVLO.TEXTRPG.user.dto.UserMasteryDTO;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;


@Service
public class UserCombatStatusService {

    Map<EffectType, Double> baseStats = new EnumMap<>(EffectType.class);
    Map<EffectType, Double> skillStats = new EnumMap<>(EffectType.class);
    Map<EffectType, Double> jobStats = new EnumMap<>(EffectType.class);
    Map<EffectType, Double> equipmentStats = new EnumMap<>(EffectType.class);

    public UserCombatDTO getUserCombat(UserDTO user) {
        initializeBaseStats(user);
        initializeStatsMap(skillStats);
        initializeStatsMap(jobStats);
        initializeStatsMap(equipmentStats);

        getJobStatus(user);
        getEquipmentStatus(user);
        return new UserCombatDTO(baseStats, skillStats, equipmentStats, jobStats);
    }

    private void initializeBaseStats(UserDTO user) {
        int basicSTR = user.getUserStats().getStrength();
        int basicDEX = user.getUserStats().getDexterity();
        int basicINT = user.getUserStats().getIntelligence();

        baseStats.put(EffectType.HP, (double) user.getUserStats().getHp());
        baseStats.put(EffectType.PA, (double) basicSTR);
        baseStats.put(EffectType.MA, (double) basicINT);
        baseStats.put(EffectType.PD, 0.0);
        baseStats.put(EffectType.MD, 0.0);
        baseStats.put(EffectType.CT, Math.pow(basicDEX, 0.3));
        baseStats.put(EffectType.CD, 150.0);
        baseStats.put(EffectType.AV, Math.pow(basicDEX, 0.25));
        baseStats.put(EffectType.AR, 0.0);
    }

    private void initializeStatsMap(Map<EffectType, Double> statsMap) {
        for (EffectType effectType : EffectType.values()) {
            statsMap.put(effectType, 0.0);
        }
    }

    private void getJobStatus(UserDTO user) {
        // 직업 보너스 가져오기
        for (UserMasteryDTO masteryDTO : user.getMastery()) {
            if (masteryDTO.getJobStatus() == JobStatus.RUNNING || masteryDTO.getJobStatus() == JobStatus.MASTER_RUNNING  || masteryDTO.getJobStatus() == JobStatus.MASTER) {
                for (JobEffectDTO effect : masteryDTO.getJob().getEffects()) {
                    applyEffect(jobStats, effect);
                }

                // 패시브 보너스 가져오기
                for (PassiveSkillDTO passiveSkill : masteryDTO.getJob().getPassiveSkills()) {
                    if (passiveSkill.getPassiveId().equals(masteryDTO.getPassiveSkillId()) &&
                            (masteryDTO.getPassiveSkillStatus() == SkillStatus.RUNNING)) {

                        for (PassiveSkillEffectDTO skillEffect : passiveSkill.getEffects()) {
                            applyEffect(skillStats, skillEffect);
                        }
                    }
                }
            }
        }
    }

    private void getEquipmentStatus(UserDTO user) {
        for (UserEquipmentDTO equipment : user.getEquipments()) {
            if (equipment.isEquipped()) {
                for (EquipmentEffectDTO effect : equipment.getEffects()) {
                    applyEffect(equipmentStats, effect);
                }
            }
        }
    }

    private void applyEffect(Map<EffectType, Double> statsMap, JobEffectDTO effect) {
        statsMap.merge(effect.getEffectType(), effect.getValue(), Double::sum);
    }


    private void applyEffect(Map<EffectType, Double> statsMap, EquipmentEffectDTO effect) {
        statsMap.merge(effect.getEffectType(), effect.getValue(), Double::sum);
    }

    private void applyEffect(Map<EffectType, Double> statsMap, PassiveSkillEffectDTO skillEffect) {
        statsMap.merge(skillEffect.getEffectType(), skillEffect.getValue(), Double::sum);
    }
}
