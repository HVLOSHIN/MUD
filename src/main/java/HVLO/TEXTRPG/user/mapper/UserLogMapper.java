package HVLO.TEXTRPG.user.mapper;

import HVLO.TEXTRPG.user.dto.UserLogDTO;
import HVLO.TEXTRPG.user.entity.UserLog;

public class UserLogMapper {
    public static UserLogDTO toDto(UserLog userLog) {
        UserLogDTO dto = new UserLogDTO();
        dto.setIP(userLog.getIP());
        dto.setTime(userLog.getTime());
        return dto;
    }
}
