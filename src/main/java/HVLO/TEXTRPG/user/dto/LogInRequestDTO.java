package HVLO.TEXTRPG.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LogInRequestDTO {

    private String IP;
    private String loginId;
    private String password;
}
