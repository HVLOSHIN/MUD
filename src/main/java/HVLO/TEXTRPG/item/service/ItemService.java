package HVLO.TEXTRPG.item.service;

import HVLO.TEXTRPG.item.dto.ItemDTO;
import HVLO.TEXTRPG.item.entity.Item;
import HVLO.TEXTRPG.item.mapper.ItemMapper;
import HVLO.TEXTRPG.item.repository.ItemRepository;
import HVLO.TEXTRPG.user.mapper.UserFieldMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemDTO> getItemsByEnemyId(Long enemyId){
        List<Item> items =  itemRepository.getItemsByEnemyId(enemyId);
        return items.stream().map(ItemMapper::toDTO).collect(Collectors.toList());
    }
}
