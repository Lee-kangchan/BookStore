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
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    CustomerService customerService;

    @Autowired
    BookService bookService;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);


    @GetMapping("/home")
    public String home(Model model, HttpSession session){
        List<Book> book = bookService.selectCurrentBook();
        model.addAttribute("name", session.getAttribute("customer_name"));
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
        model.addAttribute("name", session.getAttribute("customer_name"));

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
        model.addAttribute("name", session.getAttribute("customer_name"));
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
        model.addAttribute("name", session.getAttribute("customer_name"));
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
        model.addAttribute("name", session.getAttribute("customer_name"));
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
    @GetMapping("/order/{seq}")
    public String bookOrder(HttpSession session, Model model,@PathVariable int seq){
        HashMap<String, Object> map = new HashMap<>();
        map.put("book_seq", seq);
        map.put("customer_seq", session.getAttribute("customer_seq"));
        List<HashMap<String, Object>> result = bookService.bookOrder(map);
        model.addAttribute("book",result);
        for(Map<String ,Object> m : result){
            logger.info(m.get("book_seq").toString());
            logger.info(m.get("book_name").toString());
            logger.info(m.get("book_comment").toString());
        }
        model.addAttribute("name", session.getAttribute("customer_name"));
        model.addAttribute("card", customerService.selectCard(map));
        model.addAttribute("address",customerService.selectAddress(map));

        model.addAttribute("sales", session.getAttribute("sales"));
        model.addAttribute("money", Integer.parseInt(result.get(0).get("book_price").toString()));
        return "order";
    }
    @GetMapping("/order/cart")
    public String bookCartOrder(HttpSession session, Model model){
        HashMap<String, Object> map = new HashMap<>();
        map.put("customer_seq", session.getAttribute("customer_seq"));
        List<HashMap<String, Object>> result = bookService.bookCartOrder(map);
        model.addAttribute("book", result);
        int money = 0;
        for(Map<String ,Object> m : result){
            logger.info(m.get("book_seq").toString());
            logger.info(m.get("book_name").toString());
            logger.info(m.get("book_comment").toString());
            money = money + Integer.parseInt(m.get("book_price").toString());
        }
        model.addAttribute("name", session.getAttribute("customer_name"));
        model.addAttribute("card", customerService.selectCard(map));
        model.addAttribute("address",customerService.selectAddress(map));
        model.addAttribute("money", money);
        model.addAttribute("sales", session.getAttribute("sales"));
        model.addAttribute("sales_money", money /100 *(100-(Integer)session.getAttribute("sales")));
        return "order";
    }
    @ResponseBody
    @PostMapping(value = "/order", consumes = "application/json")
    public void order(@RequestBody List<HashMap<String, Object>> list, HttpSession session){

        logger.info(list.get(0).get("name").toString());
        logger.info(list.get(0).get("address").toString());
        logger.info(list.get(0).get("card_seq").toString());
        for(HashMap<String, Object> map : list){
            map.put("customer_seq",session.getAttribute("customer_seq"));
            map.put("price",Integer.parseInt(map.get("price").toString())*Integer.parseInt(map.get("amount").toString())/100 *(100-(Integer)session.getAttribute("sales")));
            logger.info(map.get("book_seq").toString());
            logger.info(map.get("amount").toString());

        }
        bookService.order(list, session);
    }
    @GetMapping("/mypage/order")
    public String myOrder(Model model, HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        map.put("customer_seq",session.getAttribute("customer_seq"));
        List<HashMap<String, Object>> result = bookService.selectOrderDetail(map);
        for(HashMap<String, Object> t : result){
            t.get("order_seq").toString();
        }


        model.addAttribute("book",result);
        model.addAttribute("name", session.getAttribute("customer_name"));

        return "myOrder";
    }

}
