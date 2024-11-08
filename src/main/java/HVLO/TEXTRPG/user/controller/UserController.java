package HVLO.TEXTRPG.user.controller;

import HVLO.TEXTRPG.user.dto.*;
import HVLO.TEXTRPG.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<IdDTO> getUserId(HttpServletRequest request) {
        IdDTO dto = new IdDTO();
        dto.setUserId(userService.getUserId(request));
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserDTO(id));
    }

    @GetMapping("/{id}/field")
    public ResponseEntity<List<UserFieldDTO>> getField(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserFieldDTOs(id));
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> createUser(@Valid @RequestBody SignUpRequestDTO dto) {
        userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenDTO> login(@RequestBody LogInRequestDTO loginRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(loginRequestDTO));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AccessTokenDTO> refreshAccessToken(@RequestBody AccessTokenDTO accessTokenDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.refreshAccessToken(accessTokenDTO));
    }

    // 스텟 조회
    @GetMapping("/{id}/stats")
    public ResponseEntity<UserStatsDTO> getUserStats(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserStatsDTO(id));
    }

    @PutMapping("/hp")
    public ResponseEntity<Void> updateUserHp(@RequestBody HPUpdateDTO hpUpdateDTO) {
        userService.updateUserHp(hpUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/exp")
    public ResponseEntity<Void> updateUserEXP(@RequestBody EXPUpdateDTO expUpdateDTO){
        userService.updateUserEXP(expUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/achieve")
    public ResponseEntity<Void> updateUserAchieve(@RequestBody AchieveUpdateDTO achieveUpdateDTO){
        userService.updateUserCombatAchievement(achieveUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("action-points")
    public ResponseEntity<ActionPointDTO> getActionPoints(@RequestParam Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getActionPoints(userId));
    }

    @PostMapping("action-points")
    public ResponseEntity<ActionPointDTO> updateActionPoints(@RequestParam Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateActionPoints(userId));
    }

    // 레벨업
    @PostMapping("/{id}/training")
    public ResponseEntity<UserStatsDTO> updateUserStats(@PathVariable Long id, @RequestBody LevelUpDTO levelUpDTO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserStats(id, levelUpDTO));
    }

    @GetMapping("/{id}/mastery")
    public ResponseEntity<List<UserMasteryDTO>> getUserMastery(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserMasteryDTO(id));
    }

    @PutMapping("/mastery")
    public ResponseEntity<UserMasteryDTO> updateUserMastery(@RequestBody UserMasteryDTO userMasteryDTO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.toggleSkill(userMasteryDTO));
    }

    // 보유 장비 조회
    @GetMapping("/{id}/equipment")
    public ResponseEntity<List<UserEquipmentDTO>> getEquipment(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserEquipmentDTO(id));
    }

    // 보유 장비 상태 업데이트
    @PutMapping("/equipment")
    public ResponseEntity<UserEquipmentDTO> toggleEquipment(@RequestBody ToggleEquipmentDTO toggleEquipmentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.toggleEquipment(toggleEquipmentDTO));
    }
}
