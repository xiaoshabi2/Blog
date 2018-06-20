package com.gwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello,this is a springboot demo";
    }
    @RequestMapping("/Blog")
    public String Blog(HttpServletRequest request)
    {
        String viewName=request.getParameter("viewName");
        viewName="Blog/"+viewName;
        return viewName;
    }
}
