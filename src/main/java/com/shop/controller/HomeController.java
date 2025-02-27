package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @GetMapping(value = "/ajax")
    @ResponseBody
    public void ajaxTest() {
        System.out.println("call ajax");
    }
}
