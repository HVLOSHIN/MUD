package HVLO.TEXTRPG.field.controller;

import HVLO.TEXTRPG.field.dto.FieldDTO;
import HVLO.TEXTRPG.field.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/field")
public class FieldController {

    private final FieldService fieldService;

    @GetMapping
    public ResponseEntity<List<FieldDTO>> getFields() {
        return ResponseEntity.status(HttpStatus.OK).body(fieldService.getFields());
    }
}
