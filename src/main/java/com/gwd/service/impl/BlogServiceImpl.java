package com.gwd.service.impl;

import com.gwd.dao.BlogDao;
import com.gwd.entity.Blog;
import com.gwd.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    @Override
    public Blog selectBlogById(Integer id) {
        return blogDao.selectBlogById(id);
    }

    @Override
    public List<Blog> selectLastBlog() {
        return blogDao.selectLastBlog();
    }

    @Override
    public String selectBlogTitleById(Integer id) {
        return blogDao.selectBlogTitleById(id);
    }

    @Override
    public void updateBlogReadNumById(Integer id) {
        blogDao.updateBlogReadNumById(id);
    }

    @Override
    public List<Blog> selectLastBlogIdWithTitle() {
        return blogDao.selectLastBlogIdWithTitle();
    }

    @Override
    public List<Blog> selectBlogByFuzzy(String title) {
        return blogDao.selectBlogByFuzzy(title);
    }

    @Override
    public List<Blog> selectBlogByWithLimit(Integer start) {
        return blogDao.selectBlogByWithLimit(start);
    }

    @Override
    public List<Blog> selectBlogByYearAndMonth(String year, String month,Integer start) {
        return blogDao.selectBlogByYearAndMonth(year,month,start);
    }


}
