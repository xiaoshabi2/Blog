package com.gwd.dao;

import com.gwd.entity.Blog;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface BlogDao {
    public Blog selectBlogById(Integer id);//通过id查找博客
    public List<Blog> selectLastBlog();//查找最新发布的博客
    public List<Blog> selectLastBlogIdWithTitle();//查找最新发布的博客10
    public String selectBlogTitleById(Integer id);//查找博客标题
    public void updateBlogReadNumById(Integer id);//更新博客阅读次数
    public List<Blog> selectBlogByFuzzy(String title);//模糊匹配查找博客
    public List<Blog> selectBlogByWithLimit(Integer start);//查找博客
    public List<Blog> selectBlogByYearAndMonth(@Param("year")String year, @Param("month")String month,@Param("start") Integer start);//查找指定月的博客
}
