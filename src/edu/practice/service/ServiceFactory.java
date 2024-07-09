package edu.practice.service;

import edu.practice.service.custom.ItemService;
import edu.practice.service.custom.impl.CustomerServiceImpl;
import edu.practice.service.custom.impl.ItemServiceImpl;
import edu.practice.service.custom.impl.OrderServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type){
            case ITEM:
                return new ItemServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        ITEM,
        CUSTOMER,
        ORDER
    }
}
