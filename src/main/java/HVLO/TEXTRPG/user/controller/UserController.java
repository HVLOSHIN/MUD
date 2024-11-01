package HVLO.TEXTRPG.user.controller;

import HVLO.TEXTRPG.user.dto.SignUpRequestDTO;
import HVLO.TEXTRPG.user.dto.UserUnitedDTO;
import HVLO.TEXTRPG.user.entity.User;
import HVLO.TEXTRPG.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserUnitedDTO> getUser() {
        return ResponseEntity.ok(userService.getUserDTO(1L));
    }

    @PostMapping
    public ResponseEntity<UserUnitedDTO> createUser(@Valid @RequestBody SignUpRequestDTO dto) {
        User user = userService.createUser(dto);
        return ResponseEntity.ok(userService.getUserDTO(user.getId()));
    }
}
