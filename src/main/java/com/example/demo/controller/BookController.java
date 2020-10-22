package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.example.demo.service.CustomerService;
import com.example.demo.vo.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    CustomerService customerService;

    @Autowired
    BookService bookService;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);


    @GetMapping("/home")
    public String home(Model model){
        List<Book> book = bookService.selectCurrentBook();
        for(Book bo :book){
            logger.info(bo.toString());
        }
        model.addAttribute("book", book);
        return "home";

    }


    @GetMapping ("/book/{seq}")
    public String book(@PathVariable String seq, Model model, HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        int page = Integer.parseInt(seq);
        map.put("book_seq", (page-1)*6);
        List<Book> book = bookService.selectListBook(map);
        for(Book bo :book){
            logger.info(bo.toString());
        }

        model.addAttribute("login", session.getAttribute("customer_id"));
        model.addAttribute("login_seq", session.getAttribute("customer_seq"));
        model.addAttribute("book",book);

        if(page==1){
            page = 2;
        }

        model.addAttribute("first", page-1);
        model.addAttribute("second", page);
        model.addAttribute("third",page+1);
        return "book";
    }
    @PostMapping("/book")
    public String searchBook(@RequestParam String search, Model model, HttpSession session){
        List<Book> book = bookService.searchBook(search);

        model.addAttribute("book", book);
        logger.info(search);
        for(Book b :book) {
            logger.info(b.toString());
        }
        model.addAttribute("first", 0);
        model.addAttribute("second", 0);
        model.addAttribute("third",0);
        return "book";
    }
    @GetMapping("/book/detail/{seq}")
    public String book2(@PathVariable String seq, Model model, HttpSession session){
        HashMap<String , Object> map = new HashMap<>();
        map.put("book_seq", Integer.parseInt(seq));
        Book book = bookService.selectDetailBook(map);
        book.setBook_img(book.getBook_img().replace("..",""));
        model.addAttribute("book", book);
        return "detail";
    }
    @ResponseBody
    @GetMapping("/cart/{seq}")
    public HashMap<String, Object> cartInsert(@PathVariable String seq, HttpSession session){
        logger.info("왜안대");
        HashMap<String, Object> map = new HashMap<>();
        map.put("book_seq", seq);
        map.put("customer_seq", session.getAttribute("customer_seq"));
        if (map.get("customer_seq")==null){
            map.put("result", "S");
            return map;
        }
        logger.info("왜안대22");

        map.put("result", bookService.insertBookCart(map));

        return map;
    }
    @GetMapping("/mypage/cart")
    public String cartB(Model model, HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        map.put("customer_seq",session.getAttribute("customer_seq"));
        List<HashMap<String , Object>> book = bookService.selectCart(map);

        int money = 0 ;
        for(HashMap<String,Object> t : book){
            t.put("book_img",t.get("book_img").toString().replace("..",""));
            logger.info(t.get("book_img").toString());
            money = money + Integer.parseInt(t.get("book_price").toString());
        }

        model.addAttribute("book",book);
        model.addAttribute("money", money);
        return "cart";
    }
    @GetMapping("/cart/delete/{seq}")
    public String deleteCart(HttpSession session, @PathVariable int seq){
        HashMap<String, Object> map = new HashMap<>();
        map.put("customer_seq", session.getAttribute("customer_seq"));
        map.put("book_seq", seq);
        bookService.deleteCart(map);

        return "redirect:/mypage/cart";
    }

}
