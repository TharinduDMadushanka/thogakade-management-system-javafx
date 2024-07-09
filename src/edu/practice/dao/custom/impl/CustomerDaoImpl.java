package edu.practice.dao.custom.impl;

import edu.practice.dao.CrudUtil;
import edu.practice.dao.custom.CustomerDao;
import edu.practice.entity.CustomerEntity;

import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean create(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)",
                t.getId(), t.getTitle(), t.getName(), Date.valueOf(t.getDob()), t.getSalary(), t.getAddress(), t.getCity(), t.getProvince(), t.getPostal());
    }

    @Override
    public boolean update(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE customer SET CustTitle=?,CustName=?,DOB=?,salary=?,CustAddress=?,City=?,Province=?,PostalCode=? WHERE CustID = ?",
                t.getTitle(), t.getName(), Date.valueOf(t.getDob()), t.getSalary(), t.getAddress(), t.getCity(), t.getProvince(), t.getPostal(), t.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE CustID = ?", id);
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer WHERE CustID = ?", id);
        if (rst.next()) {
            CustomerEntity customerEntity = new CustomerEntity(
                    rst.getString("CustID"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getDate("DOB").toLocalDate(), // Convert SQL Date to LocalDate
                    rst.getDouble("salary"),
                    rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"),
                    rst.getString("PostalCode")
            );
            return customerEntity;
        }
        return null;
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
        ArrayList<CustomerEntity> customerEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer");

        while (rst.next()) {
            CustomerEntity entity = new CustomerEntity(
                    rst.getString("CustID"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getDate("DOB").toLocalDate(), // Convert SQL Date to LocalDate
                    rst.getDouble("salary"),
                    rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"),
                    rst.getString("PostalCode")
            );
            customerEntities.add(entity);
        }
        return customerEntities;
    }
}
