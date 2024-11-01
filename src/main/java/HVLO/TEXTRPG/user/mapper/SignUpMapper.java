package HVLO.TEXTRPG.user.mapper;

import HVLO.TEXTRPG.user.dto.SignUpRequestDTO;
import HVLO.TEXTRPG.user.entity.User;

public class SignUpMapper {

    public static User toEntity(SignUpRequestDTO dto){
        User user = new User();
        user.setLoginId(dto.getLoginId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }
}
