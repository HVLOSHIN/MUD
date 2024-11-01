package HVLO.TEXTRPG.user.controller;

import HVLO.TEXTRPG.user.dto.AccessTokenDTO;
import HVLO.TEXTRPG.user.dto.LogInRequestDTO;
import HVLO.TEXTRPG.user.dto.SignUpRequestDTO;
import HVLO.TEXTRPG.user.dto.UserUnitedDTO;
import HVLO.TEXTRPG.user.entity.User;
import HVLO.TEXTRPG.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserUnitedDTO> getUser() {
        return ResponseEntity.ok(userService.getUserDTO(2L));
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
}
