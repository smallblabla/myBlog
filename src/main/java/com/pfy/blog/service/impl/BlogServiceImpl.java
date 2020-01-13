package com.pfy.blog.service.impl;


import com.pfy.blog.entity.Blog;
import com.pfy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BlogServiceImpl {

    @Autowired
    private BlogService blogService;

    public void addBlog(Blog blog){
        blogService.addBlog(blog);
    }
    public void deleteBlog(int id){blogService.deleteBlog(id);}
    public void changeBlog(Blog blog){blogService.changeBlog(blog);}
    public Blog selectBlogById(int id){return blogService.selectBlogById(id);}
    public int selectBlogNum(){return blogService.selectBlogNum();}
    public List<Blog> selectAllBlog(){
        return blogService.selectAllBlog();
    }
    public List<Blog> selectBlogByTag(int tag_id){return blogService.selectBlogByTag(tag_id);}
    public List<Blog> selectBlogByType(int type_id){return blogService.selectBlogByType(type_id);}
    public List<String> selectYears(){return blogService.selectYears();}
    public List<Blog> selectBlogByYear(String year){return blogService.selectBlogByYear(year);}
    public List<Blog> selectNewBlog(){return blogService.selectNewBlog();}
    public List<Blog> searchBlog(String query){return blogService.selectBlogBySearch(query);}
    public void addView(int blog_id){blogService.addView(blog_id);}
}
