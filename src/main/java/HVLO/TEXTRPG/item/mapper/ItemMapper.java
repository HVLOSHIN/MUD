package HVLO.TEXTRPG.item.mapper;

import HVLO.TEXTRPG.item.dto.ItemDTO;
import HVLO.TEXTRPG.item.entity.Item;

public class ItemMapper {
    public static ItemDTO toDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setEnemyId(item.getEnemyId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        dto.setPrice(item.getPrice());
        dto.setDropRate(item.getDropRate());
        return dto;
    }
}
