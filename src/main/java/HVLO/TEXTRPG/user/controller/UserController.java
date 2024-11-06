package HVLO.TEXTRPG.user.controller;

import HVLO.TEXTRPG.user.dto.*;
import HVLO.TEXTRPG.user.service.UserService;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserDTO(id));
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

    @PutMapping("/hp")
    public ResponseEntity<Void> updateUserHp(@RequestBody HPUpdateDTO hpUpdateDTO) {
        userService.updateUserHp(hpUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
