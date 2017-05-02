package com.zora.kung.biz.controller;

import com.zora.kung.biz.service.UserService;
import com.zora.kung.biz.vo.UserVo;
import com.zora.kung.utils.vo.ActionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Zora on 2017/4/28.
 */
@Controller
public class HelloController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/home")
    public String home() {
        return "welcome";
    }


    @ResponseBody
    @RequestMapping(value = "ajax/find/{userId}")
    public String attendRole(@PathVariable String userId) {
        UserVo vo = userService.findUserVoById(userId);
        return vo.getLoginName();
    }

}
