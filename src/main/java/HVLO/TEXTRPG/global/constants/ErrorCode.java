package HVLO.TEXTRPG.global.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_REFRESH_TOKEN(HttpStatus.NOT_FOUND, "SECURITY-01","올바르지 않은 리프레시 토큰"),
    NOT_AUTHORIZED(HttpStatus.UNAUTHORIZED,"SECURITY-02","올바르지 않은 접근"),

    //User
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER-01","User를 찾을 수 없습니다."),
    ID_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "USER-02","이미 존재하는 아이디입니다."),
    NICKNAME_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "USER-03","이미 존재하는 닉네임입니다."),
    PASSWORDS_DO_NOT_MATCH(HttpStatus.BAD_REQUEST, "USER-04","비밀번호가 일치하지 않습니다."),


    USER_STATS_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_STATS-01","User Stats를 찾을 수 없습니다."),

    USER_ACHIEVEMENTS_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_ACHIEVEMENTS-01","User Achievements를 찾을 수 없습니다."),

    EQUIPMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "EQUIPMENT-01","Equipment를 찾을 수 없습니다."),

    EQUIPMENT_EFFECTS_NOT_FOUND(HttpStatus.NOT_FOUND, "EQUIPMENT_EFFECTS-01","Equipment Effects를 찾을 수 없습니다."),

    ACTIVE_SKILL_NOT_FOUND(HttpStatus.NOT_FOUND, "ACTIVE_SKILL-01","Active skill을 찾을 수 없습니다."),

    ACTIVE_SKILL_EFFECT_NOT_FOUND(HttpStatus.NOT_FOUND, "ACTIVE_SKILL_EFFECT-01","Active skill effect를 찾을 수 없습니다."),

    PASSIVE_SKILL_NOT_FOUND(HttpStatus.NOT_FOUND, "PASSIVE_SKILL-01","Passive skill을 찾을 수 없습니다."),

    PASSIVE_SKILL_EFFECT_NOT_FOUND(HttpStatus.NOT_FOUND, "PASSIVE_SKILL_EFFECT-01","Passive skill effect를 찾을 수 없습니다."),

    JOB_NOT_FOUND(HttpStatus.NOT_FOUND,"JOB-01","Job을 찾을 수 없습니다." ),

    ENEMY_NOT_FOUND(HttpStatus.NOT_FOUND,"ENEMY-01","Enemy를 찾을 수 없습니다." );


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


}
