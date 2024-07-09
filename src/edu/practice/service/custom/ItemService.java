package edu.practice.service.custom;

import edu.practice.dto.ItemDto;
import edu.practice.service.SuperService;

import java.util.ArrayList;

public interface ItemService extends SuperService {
    String save(ItemDto itemDto)throws Exception;
    String update(ItemDto itemDto)throws Exception;
    String delete(String itemCode)throws Exception;
    ItemDto get(String itemCode)throws Exception;
    ArrayList<ItemDto> getAll()throws Exception;
}
