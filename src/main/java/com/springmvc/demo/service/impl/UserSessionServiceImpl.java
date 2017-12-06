package com.springmvc.demo.service.impl;

import com.springmvc.demo.service.UserSessionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserSessionServiceImpl implements UserSessionService {

    //不能直接使用userDate作为变量进行传递，因为他是单例，在并发的时候，第一个线程刚获取值的时候，第二个线程正好调用了setUserDate方法则修改了userDate的值。
    //此时第一个线程getUserDate的时候就会get到第二个线程修改后的值。
//    private String userDate;

    private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public boolean setUserDate(String date) {
        System.out.println("set name====" + date);
        if (StringUtils.hasText(date)) {
            threadLocal.set(date);
        }
        return true;
    }

    @Override
    public String getUserDate() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get user Date=========" + threadLocal.get());
        return threadLocal.get();
    }
}
