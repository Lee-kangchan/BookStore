package com.example.demo.service.impl;

import com.example.demo.dao.BookDAO;
import com.example.demo.service.BookService;
import com.example.demo.vo.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    SqlSession sqlSession;


    @Override
    public void insertBook(HashMap<String, Object> map) {
        BookDAO dao = new BookDAO(sqlSession);
        dao.insertBook(map);
    }

    @Override
    public List<Book> selectCurrentBook() {
        BookDAO dao = new BookDAO(sqlSession);
        return dao.selectCurrentBook();
    }

    @Override
    public List<Book> selectListBook(HashMap<String, Object> map) {
        BookDAO dao = new BookDAO(sqlSession);
        return dao.selectListBook(map);
    }

    @Override
    public List<HashMap<String, Object>> selectCart(HashMap<String, Object> map) {
        BookDAO dao = new BookDAO(sqlSession);
        return dao.selectCart(map);
    }
    @Override
    public void deleteCart(HashMap<String, Object> map){
        BookDAO dao = new BookDAO(sqlSession);
        dao.deleteCart(map);
    }
    @Override
    public Book selectDetailBook(HashMap<String, Object> map) {
        BookDAO dao = new BookDAO(sqlSession);
        return dao.selectDetailBook(map);
    }

    @Override
    public List<Book> searchBook(String map) {
        BookDAO dao = new BookDAO(sqlSession);
        return dao.searchBook(map);
    }

    @Override
    public String insertBookCart(HashMap<String, Object> map) {
        BookDAO dao = new BookDAO(sqlSession);
        HashMap<String, Object> result = new HashMap<>();
        result = dao.selectBookCart(map);
        if(result!=null){
            return "N";
        }
        dao.insertBookCart(map);

        return "Y";
    }

}
