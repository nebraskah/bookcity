package com.domingosm.bookcity.book;

public class Customer {

    private Long customerId;
    private String customerTitle;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerAddress;
    private String customerTelephone;

//    public Customer() {
//    }

    public Customer(String customerTitle,
                    String customerFirstName,
                    String customerLastName,
                    String customerEmail,
                    String customerAddress,
                    String customerTelephone) {
        this.customerTitle = customerTitle;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerTelephone = customerTelephone;
    }

    public Customer(Long customerId,
                    String customerTitle,
                    String customerFirstName,
                    String customerLastName,
                    String customerEmail,
                    String customerAddress,
                    String customerTelephone) {
        this.customerId = customerId;
        this.customerTitle = customerTitle;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerTelephone = customerTelephone;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerTitle() {
        return customerTitle;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerTitle='" + customerTitle + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerTelephone='" + customerTelephone + '\'' +
                '}';
    }
}
