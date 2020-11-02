package com.example.demo.mapper;

import com.example.demo.vo.Book;
import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.HashMap;
import java.util.List;

public interface BookMapper {
    public void insertBook(HashMap<String, Object> map);
    public List<Book> selectCurrentBook();
    public List<Book> selectListBook(HashMap<String, Object> map);
    public List<HashMap<String, Object>> selectCart (HashMap<String, Object> map);
    public void deleteCart(HashMap<String, Object> map);
    public Book selectDetailBook (HashMap<String, Object> map);
    public List<Book> searchBook (String map);
    public void insertBookCart(HashMap<String, Object> map);
    public HashMap<String, Object> selectBookCart(HashMap<String, Object> map);
    public List<HashMap<String, Object>> bookOrder(HashMap<String, Object> map);
    public List<HashMap<String, Object>> bookCartOrder(HashMap<String, Object> map);
    public void insertOrder(HashMap<String, Object> map);
    public void insertOrderDetail(HashMap<String, Object> map);
    public int selectOrder(HashMap<String, Object> map);
    public List<HashMap<String, Object>> selectOrderDetail(HashMap<String, Object> map);

}
