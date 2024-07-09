package edu.practice.service.custom.impl;

import edu.practice.dao.DaoFactory;
import edu.practice.dao.custom.ItemDao;
import edu.practice.dto.ItemDto;
import edu.practice.entity.ItemEntity;
import edu.practice.service.custom.ItemService;

import java.util.ArrayList;

public class ItemServiceImpl implements ItemService {
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public String save(ItemDto itemDto) throws Exception {
        ItemEntity entity = getItemEntity(itemDto);
        return itemDao.create(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(ItemDto itemDto) throws Exception {
        ItemEntity entity = getItemEntity(itemDto);
        return itemDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(String itemCode) throws Exception {
        return itemDao.delete(itemCode) ? "Success" : "Fail";
    }

    @Override
    public ItemDto get(String itemCode) throws Exception {
        ItemEntity entity = itemDao.get(itemCode);
        if (entity != null) {
            return getItemDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<ItemDto> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntities = itemDao.getAll();

        if (itemEntities != null && !itemEntities.isEmpty()) {
            ArrayList<ItemDto> itemDtos = new ArrayList<>();

            for (ItemEntity itemEntity : itemEntities) {
                itemDtos.add(getItemDto(itemEntity));
            }
            return itemDtos;
        }
        return null;
    }

    private ItemEntity getItemEntity(ItemDto itemDto) throws Exception {
        return new ItemEntity(
                itemDto.getItemCode(),
                itemDto.getDescription(),
                itemDto.getPack(),
                itemDto.getQoh(),
                itemDto.getUnitPrice()
        );
    }

    private ItemDto getItemDto(ItemEntity entity) throws Exception {
        return new ItemDto(
                entity.getItemCode(),
                entity.getDescription(),
                entity.getPack(),
                entity.getQoh(),
                entity.getUnitPrice()
        );
    }
}
