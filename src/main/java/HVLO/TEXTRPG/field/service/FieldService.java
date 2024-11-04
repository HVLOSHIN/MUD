package HVLO.TEXTRPG.field.service;

import HVLO.TEXTRPG.field.dto.FieldDTO;
import HVLO.TEXTRPG.field.entity.Field;
import HVLO.TEXTRPG.field.mapper.FieldMapper;
import HVLO.TEXTRPG.field.repository.FieldRepository;
import HVLO.TEXTRPG.user.mapper.UserLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FieldService {
    private final FieldRepository fieldRepository;

    public List<FieldDTO> getFields() {
        List<Field> fields = fieldRepository.findAll();
        return fields.stream().map(FieldMapper::toDTO).collect(Collectors.toList());
    }
}
