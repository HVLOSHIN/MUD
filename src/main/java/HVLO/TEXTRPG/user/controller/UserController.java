package HVLO.TEXTRPG.user.controller;

import HVLO.TEXTRPG.user.dto.UserDTO;
import HVLO.TEXTRPG.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDTO> getUser() {
        return ResponseEntity.ok(userService.getUserDTO(1L));
    }

}
