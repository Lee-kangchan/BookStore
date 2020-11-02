package com.example.demo.controller;

import com.example.demo.service.CustomerService;
import com.example.demo.service.impl.CustomerServiceImpl;
import com.example.demo.vo.Customer;
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
public class MainController {

    @Autowired
    CustomerService customerService;


    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "<h1>END</h1> <br> <h2> end</h2>");
        return "index";
    }

    // timeleaf를 사용
    // GetMapping 주로 Page 이동 할 때 사용

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/sign")
    public String sign(Model model, HttpSession session){
        model.addAttribute("login", session.getAttribute("customer_email"));
        model.addAttribute("login_seq", session.getAttribute("customer_seq"));
        return "sign";
    }
    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session){
        HashMap<String,Object> map = new HashMap<>();
        map.put("customer_seq", session.getAttribute("customer_seq"));
        model.addAttribute("login", session.getAttribute("customer_email"));
        model.addAttribute("login_seq", session.getAttribute("customer_seq"));
        model.addAttribute("login_name", session.getAttribute("customer_name"));
        model.addAttribute("card", customerService.selectCard(map));
        model.addAttribute("address",customerService.selectAddress(map));
        return "mypage";
    }


    @GetMapping("/mypage/delete")
    public String customerDelete (Model model, HttpSession session){
        model.addAttribute("login", session.getAttribute("customer_id"));
        model.addAttribute("login_seq", session.getAttribute("customer_seq"));return "delete";}

    //회원 가입
    @PostMapping("sign")
    public ModelAndView sign(@RequestParam HashMap<String, Object> customer, Model model){

        logger.info("회원.");
        customerService.insertCustomer(customer);
        Customer result = customerService.login(customer);

        ModelAndView mv = new ModelAndView();
        if (result.getCustomer_seq() == 0){

        }
        else{
            mv.setViewName("redirect:/login");
        }

        return mv;
    }

    //login
    @PostMapping("/login")
    public ModelAndView login(@RequestParam HashMap<String, Object> customer , Model model, HttpSession session){

        logger.info("로그인입니다.");
        ModelAndView mv = new ModelAndView();
        Customer result = customerService.login(customer);

        if ( result.getCustomer_email().isEmpty()){

        }
        else{
            session.setAttribute("customer_email" , result.getCustomer_email());
            session.setAttribute("customer_seq", result.getCustomer_seq());
            session.setAttribute("customer_name", result.getCustomer_name());
            mv.setViewName("redirect:/home");
        }


        return mv;
    }
    @PostMapping("/mypage/delete")
    public ModelAndView myDelete(@RequestParam HashMap<String, Object> customer, Model model, HttpSession session){

        logger.info("회원탈퇴입니다.");
        ModelAndView mv = new ModelAndView();
        boolean result = customerService.deleteCustomer(customer);
        if(result == true && customer.get("Customer_email").equals(session.getAttribute("Customer_email"))){
            mv.setViewName("redirect:/login");
        }
        else{

        }
        return mv;
    }
    @PostMapping("/card")
    public String cardInsert(@RequestParam HashMap<String, Object> map, Model model, HttpSession session){
        map.put("customer_seq", session.getAttribute("customer_seq"));
        customerService.CardInsert(map);

        return "redirect:/mypage";
    }
    @GetMapping("/card/{seq}")
    public String cardDelete(@PathVariable int seq, Model model, HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        map.put("card_seq", seq);
        map.put("customer_seq", session.getAttribute("customer_seq"));
        customerService.CardDelete(map);


        return "redirect:/mypage";
    }
    @PostMapping("/address")
    public String addressInsert(@RequestParam HashMap<String, Object> map, Model model, HttpSession session){
        map.put("customer_seq", session.getAttribute("customer_seq"));
        customerService.AddressInsert(map);
        return "redirect:/mypage";
    }
    @GetMapping("/address/{seq}")
    public String addressDelete(@PathVariable int seq, Model model, HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        map.put("address_seq", seq);
        map.put("customer_seq", session.getAttribute("customer_seq"));
        customerService.AddressDelete(map);

        return "redirect:/mypage";
    }
    @PostMapping("/password") // ajax처리 해야댐
    public String passwordUpdate(@RequestParam HashMap<String, Object> customer, Model model, HttpSession session){
        customer.put("customer_seq", session.getAttribute("customer_seq"));
        customerService.CardInsert(customer);

        return "redirect:/mypage";
    }

}
