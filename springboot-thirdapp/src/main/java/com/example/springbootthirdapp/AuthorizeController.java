package com.example.springbootthirdapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AuthorizeController {

    @RequestMapping(value = "/login")
    public String login(HttpSession session) {
        session.setAttribute("USER_NAME","XIAOLEI.HE");
        return "have login";
    }

}
