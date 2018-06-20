package com.gwd.controller.TestController;

import com.alibaba.fastjson.JSON;
import com.gwd.service.BlogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/testBlogController")
public class TestBlogController {

    @Resource
    private BlogService blogService;

    private static int topId=11;

    @RequestMapping("/selectBlogById")
    public void selectBlogById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        blogService.updateBlogReadNumById(Integer.valueOf(id));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(blogService.selectBlogById(Integer.valueOf(id))));
        out.flush();
        out.close();
    }


    @RequestMapping("/selectLastBlog")
    public void selectLastBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(blogService.selectLastBlog()));
        out.flush();
        out.close();
    }


    @RequestMapping("/forwardArticle")
    public ModelAndView forwardArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView=new ModelAndView();
        String id=request.getParameter("id");
        modelAndView.addObject("id",id);
        modelAndView.setViewName("Blog/article_detail");
        return modelAndView;
    }

    @RequestMapping("/selectLastAndNextBlogTitle")
    public void selectLastAndNextBlogTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strid=request.getParameter("id");
        Integer id=Integer.valueOf(strid);
        String arry[]=new String[2];
        if(id-1>=1)
        {
            arry[0]=blogService.selectBlogTitleById(id-1);
        }
        else {
            arry[0]=blogService.selectBlogTitleById(1);
        }
        arry[1]=blogService.selectBlogTitleById(id+1);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(arry));
        out.flush();
        out.close();
    }


    @RequestMapping("/updateBlogReadNumById")
    public void updateBlogReadNumById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("updateBlogReadNumById");
        String id=request.getParameter("id");
        blogService.updateBlogReadNumById(Integer.valueOf(id));
    }

    @RequestMapping("/selectLastBlogIdWithTitle")
    public void selectLastBlogIdWithTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(blogService.selectLastBlogIdWithTitle()));
        out.flush();
        out.close();
    }


    @RequestMapping("/selectTopBlog")
    public void selectTopBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(blogService.selectBlogById(topId)));
        out.flush();
        out.close();
    }


    @RequestMapping("/selectBlogByFuzzy")
    public void selectBlogByFuzzy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String title=request.getParameter("title");
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(blogService.selectBlogByFuzzy(title)));
        out.flush();
        out.close();
    }


    @RequestMapping("/selectBlogByWithLimit")
    public void selectBlogByWithLimit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page=request.getParameter("page");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if(Integer.valueOf(page)==null||Integer.valueOf(page)==0)
        {
            out.println(JSON.toJSONString(blogService.selectBlogByWithLimit(0)));
        }else {
            out.println(JSON.toJSONString(blogService.selectBlogByWithLimit(Integer.valueOf(page)*6-6)));
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/selectBlogByYearAndMonth")
    public void selectBlogByYearAndMonth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String year=request.getParameter("year");
        String month=request.getParameter("month");
        String page=request.getParameter("page");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if(Integer.valueOf(page)==null||Integer.valueOf(page)==0)
        {
            out.println(JSON.toJSONString(blogService.selectBlogByYearAndMonth(year,month,0)));
        }else {
            out.println(JSON.toJSONString(blogService.selectBlogByYearAndMonth(year,month,Integer.valueOf(page)*6-6)));
        }
        out.flush();
        out.close();
    }

}
