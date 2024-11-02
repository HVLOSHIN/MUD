package HVLO.TEXTRPG.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class AccessTokenDTO {
    public String access_token;
    public String refresh_token;
    public Long userId;
}
