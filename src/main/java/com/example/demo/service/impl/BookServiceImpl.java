package com.example.demo.service.impl;

import com.example.demo.controller.BookController;
import com.example.demo.dao.BookDAO;
import com.example.demo.service.BookService;
import com.example.demo.vo.Book;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    SqlSession sqlSession;
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);


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

    @Override
    public List<HashMap<String, Object>> bookOrder(HashMap<String, Object> map) {
        BookDAO dao = new BookDAO(sqlSession);
        return dao.bookOrder(map);

    }

    @Override
    public List<HashMap<String, Object>> bookCartOrder(HashMap<String, Object> map) {
        BookDAO dao = new BookDAO(sqlSession);
        return dao.bookCartOrder(map);
    }

    @Override
    public void order(List<HashMap<String, Object>> map, HttpSession session) {
        BookDAO dao = new BookDAO(sqlSession);
        dao.insertOrder(map.get(0));
        Integer num = dao.selectOrder(map.get(0));
        for(HashMap<String, Object> t : map){
            logger.info("",num);
            t.put("order_seq",num);
            dao.insertOrderDetail(t);
            dao.deleteCart(t);
        }
        HashMap<String, Object> membership = dao.selectMembership(map.get(0));
        membership.put("customer_seq",map.get(0).get("customer_seq"));
        logger.info("membership:"+membership.get("membership_num"));
        logger.info("customer"+membership.get("customer_seq"));
        dao.updateMembership(membership);
        session.setAttribute("sales", membership.get("membership_sale"));

    }
    @Override
    public List<HashMap<String, Object>> selectOrderDetail(HashMap<String, Object> map){
        BookDAO dao = new BookDAO(sqlSession);
        return dao.selectOrderDetail(map);
    }
}
