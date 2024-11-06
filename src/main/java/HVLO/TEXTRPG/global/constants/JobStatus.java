package HVLO.TEXTRPG.global.constants;

public enum JobStatus {
    NOT_STARTED,
    RUNNING, // 현재 이 직업을 선택중임
    MASTER_RUNNING,
    HOLD, // 보류 (잠시 다른 직업으로 이동)
    MASTER
}
