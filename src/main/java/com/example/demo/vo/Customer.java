package com.example.demo.vo;


public class Customer {
    private int customer_seq;
    private String customer_password;
    private String customer_name;
    private String customer_email;
    private int membership_sale;

    public Customer() {
    }

    public Customer(int customer_seq, String customer_password, String customer_name, String customer_email, int membership_sale) {
        this.customer_seq = customer_seq;
        this.customer_password = customer_password;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.membership_sale = membership_sale;
    }

    public int getCustomer_seq() {
        return customer_seq;
    }

    public void setCustomer_seq(int customer_seq) {
        this.customer_seq = customer_seq;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public int getMembership_sale() {
        return membership_sale;
    }

    public void setMembership_sale(int membership_sale) {
        this.membership_sale = membership_sale;
    }
}
