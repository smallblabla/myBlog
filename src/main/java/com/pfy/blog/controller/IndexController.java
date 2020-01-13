package com.pfy.blog.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pfy.blog.entity.Blog;
import com.pfy.blog.entity.Tag;
import com.pfy.blog.entity.Type;
import com.pfy.blog.entity.User;
import com.pfy.blog.service.impl.BlogServiceImpl;
import com.pfy.blog.service.impl.TagServiceImpl;
import com.pfy.blog.service.impl.TypeServiceImpl;
import com.pfy.blog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    BlogServiceImpl blogServiceImpl;
    @Autowired
    TagServiceImpl tagServiceImpl;
    @Autowired
    TypeServiceImpl typeServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;
    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        User user = userServiceImpl.getUser();
        user.setPassword(null);
        PageHelper.startPage(pageNum,5);
        List<Blog> blogs = blogServiceImpl.selectAllBlog();
        PageInfo<Blog> pageBlogs = new PageInfo<Blog>(blogs);
        int blogNum = blogServiceImpl.selectBlogNum();
        List<Type> someTypes = typeServiceImpl.selectSomeType();
        List<Tag> someTags = tagServiceImpl.selectSomeTag();
        List<Blog> newBlogs = blogServiceImpl.selectNewBlog();
        model.addAttribute("blogNum",blogNum);
        model.addAttribute("pageBlogs",pageBlogs);
        model.addAttribute("someTypes",someTypes);
        model.addAttribute("someTags",someTags);
        model.addAttribute("newBlogs",newBlogs);
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                         @RequestParam String query){
        User user = userServiceImpl.getUser();
        user.setPassword(null);
        PageHelper.startPage(pageNum,7);
        List<Blog> blogs = blogServiceImpl.searchBlog(query);
        PageInfo<Blog> pageBlogs = new PageInfo<Blog>(blogs);
        model.addAttribute("pageBlogs",pageBlogs);
        model.addAttribute("query",query);
        model.addAttribute("user",user);
        return "search";
    }


}
