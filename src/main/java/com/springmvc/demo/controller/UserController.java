package com.springmvc.demo.controller;


import com.springmvc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("name")
    @ResponseBody
    private String getUser() {
        userService.getUser();
        return "success";
    }

    @RequestMapping("id")
    public String getUserName() {
        userService.getUser();
        return "success";
    }
}
