package edu.practice.controller;

import edu.practice.dto.CustomerDto;
import edu.practice.service.ServiceFactory;
import edu.practice.service.custom.CustomerService;

import java.util.ArrayList;

public class CustomerController {
    private CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public String save(CustomerDto customerDto)throws Exception {
        return customerService.save(customerDto);
    }

    public String update(CustomerDto customerDto)throws Exception {
        return customerService.update(customerDto);
    }

    public String delete(String custId)throws Exception {
        return customerService.delete(custId);
    }

    public ArrayList<CustomerDto> getAll()throws Exception {
        return customerService.getAll();
    }

    public CustomerDto getCustomer(String custId)throws Exception {
        return customerService.getCustomer(custId);
    }
}
