package edu.practice.service.custom;

import edu.practice.dto.OrderDto;
import edu.practice.service.SuperService;

public interface OrderService extends SuperService {
    String placeOrder(OrderDto orderDto)throws Exception;
}
