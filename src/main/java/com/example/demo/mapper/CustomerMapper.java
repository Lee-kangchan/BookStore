package com.example.demo.mapper;

import com.example.demo.vo.Customer;

import java.util.HashMap;
import java.util.List;

public interface CustomerMapper {
    public void insertCustomer(HashMap<String, Object> customer);
    public Customer login (HashMap<String, Object> customer);
    public void updatePassword(HashMap<String, Object> customer);
    public void deleteCustomer(HashMap<String, Object> customer);
    public void AddressInsert (HashMap<String, Object> map);
    public void AddressDelete (HashMap<String, Object> map);
    public void CardInsert (HashMap<String, Object> map);
    public void CardDelete (HashMap<String, Object> map);
    public void passwordUpdate (HashMap<String, Object> map);
    public List<HashMap<String, Object>> selectCard(HashMap<String, Object> map);
    public List<HashMap<String, Object>> selectAddress(HashMap<String, Object> map);


}
