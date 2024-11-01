package HVLO.TEXTRPG.user.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpRequestDTO {

    @Column(nullable = false, unique = true)
    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 4, max = 12, message = "아이디는 4글자 이상, 12글자 이하로 입력해주세요.")
    private String loginId;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 12, message = "닉네임은 2글자 이상, 12글자 이하로 입력해주세요.")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 16, message = "비밀번호는 8글자 이상, 16글자 이하로 입력해주세요.")
    private String password;
}
