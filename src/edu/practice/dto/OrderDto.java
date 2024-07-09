package edu.practice.dto;

public class OrderDto {

    private String orederId;
    private String custId;
    private String date;

    public OrderDto() {
    }

    public OrderDto(String orederId, String custId, String date) {
        this.orederId = orederId;
        this.custId = custId;
        this.date = date;
    }

    public String getOrederId() {
        return orederId;
    }

    public void setOrederId(String orederId) {
        this.orederId = orederId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orederId='" + orederId + '\'' +
                ", custId='" + custId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
