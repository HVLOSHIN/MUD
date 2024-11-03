package HVLO.TEXTRPG.user.dto;

import HVLO.TEXTRPG.global.constants.EffectType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserCombatDTO {
    private Map<EffectType, Double> baseStats;
    private Map<EffectType, Double> skillStats;
    private Map<EffectType, Double> equipmentStats;
    private Map<EffectType, Double> jobStats;


}
