package HVLO.TEXTRPG.job.mapper;

import HVLO.TEXTRPG.job.dto.JobEffectDTO;
import HVLO.TEXTRPG.job.entity.JobEffect;

public class JobEffectMapper {
    public static JobEffectDTO toDTO(JobEffect jobEffect) {
        JobEffectDTO dto = new JobEffectDTO();
        dto.setEffectType(jobEffect.getEffectType());
        dto.setOperation(jobEffect.getOperation());
        dto.setValue(jobEffect.getValue());
        return dto;
    }
}
