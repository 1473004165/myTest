package com.rx.controller;


import com.rx.domain.Account;
import com.rx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("findAll")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Account> list = accountService.findAll();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/insert")
    public String insert(Account account){
        accountService.addAccount(account);
        return "success";
    }
}
