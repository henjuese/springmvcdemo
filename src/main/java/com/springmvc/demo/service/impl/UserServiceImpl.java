package com.springmvc.demo.service.impl;

import com.springmvc.demo.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public void getUser() {
        System.out.println("getUser...........................");
    }
}
