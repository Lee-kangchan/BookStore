package com.example.demo.service;

import com.example.demo.vo.Book;

import java.util.HashMap;
import java.util.List;

public interface BookService {
    public void insertBook(HashMap<String, Object> map);
    public List<Book> selectCurrentBook();
    public List<Book> selectListBook(HashMap<String, Object> map);
    public List<HashMap<String, Object>> selectCart (HashMap<String, Object> map);
    public void deleteCart(HashMap<String, Object> map);
    public Book selectDetailBook (HashMap<String, Object> map);
    public List<Book> searchBook (String map);
    public String insertBookCart(HashMap<String, Object> map);

}
