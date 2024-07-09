package edu.practice.service.custom.impl;

import edu.practice.dao.DaoFactory;
import edu.practice.dao.custom.ItemDao;
import edu.practice.dao.custom.OrderDao;
import edu.practice.dao.custom.OrderDetailDao;
import edu.practice.db.DBConnection;
import edu.practice.dto.OrderDetailDto;
import edu.practice.dto.OrderDto;
import edu.practice.entity.ItemEntity;
import edu.practice.entity.OrderDetailEntity;
import edu.practice.entity.OrderEntity;
import edu.practice.service.custom.OrderService;

import java.sql.Connection;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
    private OrderDetailDao orderDetailDao= (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER_DETAIL);
    private ItemDao itemDao= (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();

        try {

            connection.setAutoCommit(false);

            OrderEntity orderEntity = new OrderEntity(orderDto.getOrederId(),orderDto.getCustId(),orderDto.getDate());
            if (orderDao.create(orderEntity)){
                boolean isOrderDetailSaved = true;

                for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()){
                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity(
                            orderDto.getOrederId(),
                            orderDetailDto.getItemCode(),
                            orderDetailDto.getQty(),
                            orderDetailDto.getDiscount()
                    );
                    if (!orderDetailDao.create(orderDetailEntity)){
                        isOrderDetailSaved = false;
                    }
                }

                if (isOrderDetailSaved){

                    boolean isItemSaved = true;

                    for(OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()){
                        ItemEntity itemEntity = itemDao.get(orderDetailDto.getItemCode());
                        if (itemEntity != null){
                            itemEntity.setQoh(itemEntity.getQoh()-orderDetailDto.getQty());

                            if (!itemDao.update(itemEntity)){
                                isItemSaved = false;
                            }
                        }
                    }
                    if (isItemSaved){
                        connection.commit();
                        return "Success";
                    }else {
                        connection.rollback();
                        return "Item Update Failed";
                    }
                }else {
                    connection.rollback();
                    return "OrderDetail Insert Failed";
                }

            }else {
                connection.rollback();
                return "Order Insert Failed";
            }

        }catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            connection.setAutoCommit(true);
        }
    }
}
