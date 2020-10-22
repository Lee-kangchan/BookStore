package com.example.demo.dao;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.vo.Book;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

public class BookDAO {

    BookMapper mapper;
    SqlSession sqlSession;
    private Logger logger = LoggerFactory.getLogger(BookDAO.class);
    public BookDAO(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        mapper = sqlSession.getMapper(BookMapper.class);
    }
    public void insertBook(HashMap<String, Object> map){
        mapper.insertBook(map);
    }
    public List<Book> selectCurrentBook() {
        return mapper.selectCurrentBook();
    }
    public List<Book> selectListBook(HashMap<String, Object> map) {
        return mapper.selectListBook(map);
    }
    public List<HashMap<String, Object>> selectCart (HashMap<String, Object> map) {
        return mapper.selectCart(map);
    }
    public void deleteCart(HashMap<String, Object> map){mapper.deleteCart(map);}
    public Book selectDetailBook (HashMap<String, Object> map){
        System.out.println("오류오류오류야");
        Book book = mapper.selectDetailBook(map);
        System.out.println(book.toString());
        return book;
    }
    public List<Book> searchBook (String map){
        logger.info(map);
        List<Book> book = mapper.searchBook(map);
        for(Book b : book){
            logger.info(b.toString());
        }

        return book;
    }
    public void insertBookCart(HashMap<String, Object> map){
        mapper.insertBookCart(map);
    }
    public HashMap<String, Object> selectBookCart(HashMap<String, Object> map){
        return mapper.selectBookCart(map);
    }
}
