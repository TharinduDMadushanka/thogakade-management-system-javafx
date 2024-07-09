package edu.practice.controller;

import edu.practice.dto.OrderDto;
import edu.practice.service.ServiceFactory;
import edu.practice.service.custom.OrderService;

public class OrderController {
    private OrderService orderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);

    public String placeOrder(OrderDto orderDto)throws Exception{
        return orderService.placeOrder(orderDto);
    }
}
