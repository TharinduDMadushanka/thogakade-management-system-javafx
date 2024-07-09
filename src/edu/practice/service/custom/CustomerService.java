package edu.practice.service.custom;

import edu.practice.dto.CustomerDto;
import edu.practice.service.SuperService;

import java.util.ArrayList;

public interface CustomerService extends SuperService {
    String save(CustomerDto customerDto)throws Exception;
    String update(CustomerDto customerDto)throws Exception;
    String delete(String custId)throws Exception;
    CustomerDto getCustomer(String custId)throws Exception;
    ArrayList<CustomerDto> getAll()throws Exception;
}
