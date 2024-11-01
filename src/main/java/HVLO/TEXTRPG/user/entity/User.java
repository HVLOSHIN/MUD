package HVLO.TEXTRPG.user.entity;

import HVLO.TEXTRPG.global.constants.Role;
import HVLO.TEXTRPG.global.entity.BaseTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @Size(min = 8, max = 16, message = "비밀번호는 8글자 이상, 16글자 이하로 입력해주세요.")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.BASIC;

    public User(String loginId, String username, String password) {
        this.loginId = loginId;
        this.username = username;
        this.password = password;
    }


    //    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private UserStats stats;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private UserAchievements achievements;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private UserLog log;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<UserEquipment> userEquipments = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<UserMastery> userMasteries = new ArrayList<>();

//    public void recoverActionPoints() {
//        LocalDateTime now = LocalDateTime.now();
//        long secondsSinceLastRecovery = Duration.between(lastRecoveryTime, now).getSeconds();
//
//        // 10초마다 1씩 회복
//        int pointsToRecover = (int) (secondsSinceLastRecovery / 10);
//        if (pointsToRecover > 0) {
//            this.actionPoints = Math.min(this.actionPoints + pointsToRecover, this.maxActionPoints);
//            this.lastRecoveryTime = now;
//        }
//    }
}
