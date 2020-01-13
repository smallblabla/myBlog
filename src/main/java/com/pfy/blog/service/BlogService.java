package com.pfy.blog.service;

import com.pfy.blog.entity.Blog;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface BlogService {
     void addBlog(Blog blog);
     Blog selectBlogById(int id);
     int selectBlogNum();
     void deleteBlog(int id);
     void changeBlog(Blog blog);
     List<Blog> selectAllBlog();
     List<Blog> selectBlogByTag(int tag_id);
     List<Blog> selectBlogByType(int type_id);
     List<String> selectYears();
     List<Blog> selectBlogByYear(String year);
     List<Blog> selectNewBlog();
     List<Blog> selectBlogBySearch(String query);
     void addView(int blog_id);
}
