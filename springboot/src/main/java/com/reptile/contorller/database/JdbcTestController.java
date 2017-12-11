package com.reptile.contorller.database;

import com.reptile.service.database.JdbcTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jdbc")
public class JdbcTestController {
    @Autowired
    JdbcTestService service;

    @RequestMapping("test")
    public void test() {
        service.test();
    }
}
