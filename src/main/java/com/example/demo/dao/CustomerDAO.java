package com.example.demo.dao;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.vo.Customer;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class CustomerDAO {

    CustomerMapper mapper;
    SqlSession sqlSession;

    public CustomerDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        mapper = sqlSession.getMapper(CustomerMapper.class);
    }

    public void insertCustomer(HashMap<String, Object> customer) {
        mapper.insertCustomer(customer);

    }

    public Customer login(HashMap<String, Object> customer) {
        return mapper.login(customer);
    }

    public void updatePassword(HashMap<String, Object> customer) {
        mapper.updatePassword(customer);
    }

    public void deleteCustomer(HashMap<String, Object> customer) {
        mapper.deleteCustomer(customer);
    }

    public void AddressInsert(HashMap<String, Object> map) {
        mapper.AddressInsert(map);
    }

    public void AddressDelete(HashMap<String, Object> map) {
        mapper.AddressDelete(map);
    }

    public void CardInsert(HashMap<String, Object> map) {
        mapper.CardInsert(map);
    }

    public void CardDelete(HashMap<String, Object> map) {
        mapper.CardDelete(map);
    }

    public void passwordUpdate(HashMap<String, Object> map) {
        mapper.passwordUpdate(map);
    }

    public List<HashMap<String, Object>> selectCard(HashMap<String, Object> map) {
        return mapper.selectCard(map);
    }

    public List<HashMap<String, Object>> selectAddress(HashMap<String, Object> map) {
        return mapper.selectAddress(map);
    }
}
