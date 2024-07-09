package edu.practice.controller;

import edu.practice.dto.ItemDto;
import edu.practice.service.ServiceFactory;
import edu.practice.service.custom.ItemService;

import java.util.ArrayList;

public class ItemController {
    private ItemService itemService = (ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);

    public String save(ItemDto itemDto)throws Exception{
        return itemService.save(itemDto);
    }

    public String update(ItemDto itemDto)throws Exception{
        return itemService.update(itemDto);
    }

    public String delete(String itemCode)throws Exception{
        return itemService.delete(itemCode);
    }

    public ArrayList<ItemDto> getAll()throws Exception{
        return itemService.getAll();
    }

    public ItemDto get(String itemCode)throws Exception{
        return itemService.get(itemCode);
    }
}
