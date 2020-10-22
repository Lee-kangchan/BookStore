package com.example.demo.service.impl;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.service.CustomerService;
import com.example.demo.vo.Customer;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    SqlSession sqlSession;

    @Override
    public void insertCustomer(HashMap<String, Object> customer) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        customerDAO.insertCustomer(customer);
    }

    @Override
    public Customer login(HashMap<String, Object> customer) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        return customerDAO.login(customer);

    }

    @Override
    public boolean updatePassword(HashMap<String, Object> customer) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        customerDAO.updatePassword(customer);
        Customer result = customerDAO.login(customer);

        if(result.getCustomer_seq() == 0){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean deleteCustomer(HashMap<String, Object> customer) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        customerDAO.deleteCustomer(customer);
        Customer result = customerDAO.login(customer);
        if(result.getCustomer_seq() != 0){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void AddressInsert(HashMap<String, Object> map) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        customerDAO.AddressInsert(map);
    }

    @Override
    public void AddressDelete(HashMap<String, Object> map) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        customerDAO.AddressDelete(map);
    }

    @Override
    public void CardInsert(HashMap<String, Object> map) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        customerDAO.CardInsert(map);
    }

    @Override
    public void CardDelete(HashMap<String, Object> map) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        customerDAO.CardDelete(map);
    }

    @Override
    public void passwordUpdate(HashMap<String, Object> map) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        customerDAO.passwordUpdate(map);
    }

    @Override
    public List<HashMap<String, Object>> selectCard(HashMap<String, Object> map) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        List<HashMap<String, Object>> list = new ArrayList<>();
        list =customerDAO.selectCard(map);
        for(HashMap<String, Object> i : list){
            i.toString();
        }
        return customerDAO.selectCard(map);
    }

    @Override
    public List<HashMap<String, Object>> selectAddress(HashMap<String, Object> map) {
        CustomerDAO customerDAO = new CustomerDAO(sqlSession);
        List<HashMap<String, Object>> list = new ArrayList<>();
        list =customerDAO.selectAddress(map);
        for(HashMap<String, Object> i : list){
            i.toString();
        }
        return customerDAO.selectAddress(map);
    }
}
