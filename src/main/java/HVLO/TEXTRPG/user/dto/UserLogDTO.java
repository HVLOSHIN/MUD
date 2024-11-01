package HVLO.TEXTRPG.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UserLogDTO {

    private String IP;

    private LocalDateTime time;
}
