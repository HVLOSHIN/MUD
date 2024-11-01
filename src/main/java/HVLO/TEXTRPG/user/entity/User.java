package HVLO.TEXTRPG.user.entity;

import HVLO.TEXTRPG.global.constants.Role;
import HVLO.TEXTRPG.global.entity.BaseTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.BASIC;

    @Column(nullable = false)
    private String salt;
}
