package com.zhaoxi.java.vip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 标注控制器
public class TestController {
    @RequestMapping("/hello")
    public String index(){
        return "index";
    }
}
