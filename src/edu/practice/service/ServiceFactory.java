package edu.practice.service;

import edu.practice.service.custom.ItemService;
import edu.practice.service.custom.impl.ItemServiceImpl;

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
            default:
                return null;
        }
    }

    public enum ServiceType {
        ITEM
    }
}
