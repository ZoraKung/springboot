package com.zora.kung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zora on 2017/4/28.
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        return "welcome";
    }
}
