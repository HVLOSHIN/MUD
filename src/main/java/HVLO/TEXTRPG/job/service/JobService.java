package HVLO.TEXTRPG.job.service;

import HVLO.TEXTRPG.global.constants.ErrorCode;
import HVLO.TEXTRPG.global.exception.GlobalException;
import HVLO.TEXTRPG.job.dto.ActiveSkillDTO;
import HVLO.TEXTRPG.job.dto.JobDTO;
import HVLO.TEXTRPG.job.dto.JobTotalDTO;
import HVLO.TEXTRPG.job.dto.PassiveSkillDTO;
import HVLO.TEXTRPG.job.entity.*;
import HVLO.TEXTRPG.job.mapper.ActiveSkillMapper;
import HVLO.TEXTRPG.job.mapper.JobMapper;
import HVLO.TEXTRPG.job.mapper.JobTotalMapper;
import HVLO.TEXTRPG.job.mapper.PassiveSkillMapper;
import HVLO.TEXTRPG.job.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final PassiveSkillRepository passiveSkillRepository;
    private final PassiveSkillEffectRepository passiveSkillEffectRepository;
    private final ActiveSkillRepository activeSkillRepository;
    private final ActiveSkillEffectRepository activeSkillEffectRepository;
    private final JobEffectRepository jobEffectRepository;


    public JobTotalDTO getJobTotalDTOById(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new GlobalException(ErrorCode.JOB_NOT_FOUND));
        List<ActiveSkillDTO> activeSkills = findActiveSkillDTOsByJobId(jobId);
        List<PassiveSkillDTO> passiveSkills = findPassiveSkillDTOsByJobId(jobId);
        List<JobEffect> jobEffects = jobEffectRepository.findAllByJobId(jobId);

        return JobTotalMapper.toDTO(job, passiveSkills, activeSkills, jobEffects);
    }

    public JobDTO getJobDTOById(Long jobId, Long passiveSkillId, Long activeSkillId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new GlobalException(ErrorCode.JOB_NOT_FOUND));
        PassiveSkillDTO passiveSkillDTO = findPassiveSkillById(passiveSkillId);
        ActiveSkillDTO activeSkillDTO = findActiveSkillById(activeSkillId);
        List<JobEffect> jobEffects = jobEffectRepository.findAllByJobId(jobId);
        return JobMapper.toDTO(job, passiveSkillDTO, activeSkillDTO, jobEffects);
    }

    public List<ActiveSkillDTO> findActiveSkillDTOsByJobId(Long jobId) {
        List<ActiveSkill> activeSkills = activeSkillRepository.findAllByJobId(jobId);
        return activeSkills.stream().map(activeSkill -> {
            List<ActiveSkillEffect> effects = activeSkillEffectRepository.findAllBySkillId(activeSkill.getId())
                    .orElseThrow(() -> new GlobalException(ErrorCode.ACTIVE_SKILL_EFFECT_NOT_FOUND));
            return ActiveSkillMapper.toDTO(activeSkill, effects);
        }).collect(Collectors.toList());
    }

    public List<PassiveSkillDTO> findPassiveSkillDTOsByJobId(Long jobId) {
        List<PassiveSkill> passiveSkills = passiveSkillRepository.findAllByJobId(jobId);
        return passiveSkills.stream().map(passiveSkill -> {
            List<PassiveSkillEffect> effects = passiveSkillEffectRepository.findAllBySkillId(passiveSkill.getId())
                    .orElseThrow(() -> new GlobalException(ErrorCode.PASSIVE_SKILL_EFFECT_NOT_FOUND));
            return PassiveSkillMapper.toDTO(passiveSkill, effects);
        }).collect(Collectors.toList());
    }

    public PassiveSkillDTO findPassiveSkillById(Long skillId) {
        PassiveSkill passiveSkill = passiveSkillRepository.findById(skillId)
                .orElseThrow(() -> new GlobalException(ErrorCode.PASSIVE_SKILL_NOT_FOUND));
        List<PassiveSkillEffect> effects = passiveSkillEffectRepository.findAllBySkillId(skillId)
                .orElseThrow(() -> new GlobalException(ErrorCode.PASSIVE_SKILL_EFFECT_NOT_FOUND));
        return PassiveSkillMapper.toDTO(passiveSkill, effects);
    }

    public ActiveSkillDTO findActiveSkillById(Long skillId) {
        ActiveSkill activeSkill = activeSkillRepository.findById(skillId)
                .orElseThrow(() -> new GlobalException(ErrorCode.ACTIVE_SKILL_NOT_FOUND));
        List<ActiveSkillEffect> effects = activeSkillEffectRepository.findAllBySkillId(skillId)
                .orElseThrow(() -> new GlobalException(ErrorCode.ACTIVE_SKILL_EFFECT_NOT_FOUND));
        return ActiveSkillMapper.toDTO(activeSkill,effects);
    }
}
