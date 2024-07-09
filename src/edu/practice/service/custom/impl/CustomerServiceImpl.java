package edu.practice.service.custom.impl;

import edu.practice.dao.DaoFactory;
import edu.practice.dao.custom.CustomerDao;
import edu.practice.dto.CustomerDto;
import edu.practice.entity.CustomerEntity;
import edu.practice.service.custom.CustomerService;

import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);
    @Override
    public String save(CustomerDto customerDto) throws Exception {
        CustomerEntity entity = getCustomerEntity(customerDto);
        return customerDao.create(entity)? "Success": "Fail";

    }

    @Override
    public String update(CustomerDto customerDto) throws Exception {
        CustomerEntity entity = getCustomerEntity(customerDto);
        return customerDao.update(entity)? "Success": "Fail";
    }

    @Override
    public String delete(String custId) throws Exception {
        return customerDao.delete(custId)? "Success": "Fail";
    }

    @Override
    public CustomerDto getCustomer(String custId) throws Exception {
        CustomerEntity entity = customerDao.get(custId);
        if (entity != null) {
            return getCustomerDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        ArrayList<CustomerEntity> entities = customerDao.getAll();

        if (entities != null && !entities.isEmpty()) {
            ArrayList<CustomerDto> customerDtos = new ArrayList<>();
            for (CustomerEntity entity : entities) {
                customerDtos.add(getCustomerDto(entity));
            }
            return customerDtos;
        }
        return null;
    }

    private CustomerEntity getCustomerEntity(CustomerDto customerDto) throws Exception {
        return new CustomerEntity(
                customerDto.getId(),
                customerDto.getTitle(),
                customerDto.getName(),
                customerDto.getDob(),
                customerDto.getSalary(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getPostal()
        );
    }

    private CustomerDto getCustomerDto(CustomerEntity entity) throws Exception {
        return new CustomerDto(
                entity.getId(),
                entity.getTitle(),
                entity.getName(),
                entity.getDob(),
                entity.getSalary(),
                entity.getAddress(),
                entity.getCity(),
                entity.getProvince(),
                entity.getPostal()
        );
    }
}
