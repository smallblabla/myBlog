package com.pfy.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pfy.blog.entity.Blog;
import com.pfy.blog.entity.Tag;
import com.pfy.blog.entity.Type;
import com.pfy.blog.service.impl.BlogServiceImpl;
import com.pfy.blog.service.impl.TagServiceImpl;
import com.pfy.blog.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogServiceImpl;
    @Autowired
    private TagServiceImpl tagServiceImpl;
    @Autowired
    private TypeServiceImpl typeServiceImpl;

    @RequestMapping("/blog")
    public String showBlogs(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Blog> blogs = blogServiceImpl.selectAllBlog();
        PageInfo<Blog> pageBlogs = new PageInfo<Blog>(blogs);
        List<Tag> tags = tagServiceImpl.selectTags();
        List<Type> types = typeServiceImpl.selectTypes();
        System.out.println(blogs);
        model.addAttribute("pageBlogs",pageBlogs);
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        return "admin/admin_blogs";
    }

    @RequestMapping("/blog/toAddBlog")
    public String toAddBlog(Model model){
        List<Tag> tags = tagServiceImpl.selectTags();
        List<Type> types = typeServiceImpl.selectTypes();
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        return "admin/admin_addBlog";
    }

    @RequestMapping("/blog/addBlog")
    public String addBlog(@RequestParam String title,
                          @RequestParam String content,
                          @RequestParam String picture,
                          @RequestParam String flag,
                          @RequestParam int type,
                          @RequestParam String tags,
                          @RequestParam String description,
                          @RequestParam boolean recommendSwitch,
                          @RequestParam boolean copyrightSwitch,
                          @RequestParam boolean appreciateSwitch,
                          @RequestParam boolean commentSwitch,
                          @RequestParam boolean releaseSwitch
                          ){
        Blog blog = new Blog();
        Type type1 = new Type();
        type1.setType_id(type);
        type1.setType_name(typeServiceImpl.selectTypeById(type).getType_name());
        blog.setFlag(flag);
        blog.setPicture(picture);
        blog.setContent(content);
        blog.setTitle(title);
        blog.setType(type1);
        blog.setDescription(description);
        blog.setRecommend_switch(recommendSwitch);
        blog.setCopyright_switch(copyrightSwitch);
        blog.setAppreciate_switch(appreciateSwitch);
        blog.setComment_switch(commentSwitch);
        blog.setRelease_switch(releaseSwitch);
        blog.setTagIds(tags);
        blogServiceImpl.addBlog(blog);
        return "redirect:/admin/blog";
    }

    @RequestMapping("/blog/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id){
        blogServiceImpl.deleteBlog(id);
        return "redirect:/admin/blog";
    }


    @RequestMapping("/blog/toChangeBlog/{id}")
    public String toChangeBlog(@PathVariable int id,Model model){
        List<Tag> tags = tagServiceImpl.selectTags();
        List<Type> types = typeServiceImpl.selectTypes();
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        Blog blog = blogServiceImpl.selectBlogById(id);
        System.out.println(blog);
        model.addAttribute("blog",blog);
        return "admin/admin_addBlog";
    }

    @RequestMapping("/blog/changeBlog/{id}")
    public String changeBlog(
                          @PathVariable int id,
                          @RequestParam String title,
                          @RequestParam String content,
                          @RequestParam String picture,
                          @RequestParam String flag,
                          @RequestParam int type,
                          @RequestParam String tags,
                          @RequestParam String description,
                          @RequestParam boolean recommendSwitch,
                          @RequestParam boolean copyrightSwitch,
                          @RequestParam boolean appreciateSwitch,
                          @RequestParam boolean commentSwitch,
                          @RequestParam boolean releaseSwitch
                            ){
        Blog blog = new Blog();
        Type type1 = new Type();
        type1.setType_id(type);
        blog.setId((long) id);
        blog.setFlag(flag);
        blog.setPicture(picture);
        blog.setContent(content);
        blog.setTitle(title);
        blog.setType(type1);
        blog.setDescription(description);
        blog.setRecommend_switch(recommendSwitch);
        blog.setCopyright_switch(copyrightSwitch);
        blog.setAppreciate_switch(appreciateSwitch);
        blog.setComment_switch(commentSwitch);
        blog.setRelease_switch(releaseSwitch);
        blog.setTagIds(tags);
        blogServiceImpl.changeBlog(blog);
        return "redirect:/admin/blog";
    }

    @RequestMapping("/blog/search")
    public String search(@RequestParam int type,
                         @RequestParam String title,
                         @RequestParam boolean recommendSwitch,
                         Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum ){
        PageHelper.startPage(pageNum,5);
        List<Blog> blogs = new ArrayList<Blog>();
        List<Type> types = typeServiceImpl.selectTypes();
        if (title.equals("null")){
            blogs = blogServiceImpl.selectBlogByType(type);
        }if (type==0){
            blogs = blogServiceImpl.searchBlog(title);
        }
        PageInfo<Blog> pageBlogs = new PageInfo<Blog>(blogs);
        model.addAttribute("pageBlogs",pageBlogs);
        model.addAttribute("types",types);
        model.addAttribute("type_id",type);
        model.addAttribute("title",title);
        model.addAttribute("recommendSwitch",recommendSwitch);
        return "admin/admin_search";
    }

//    @RequestMapping("/t")
//    public String t1(){
//        Type type = new Type();
//        Blog blog = new Blog();
//        blog.setRecommend_switch(true);
//        blog.setTags("123");
//        blog.setFlag("原创");
//        blog.setTitle("测试");
//        blog.setContent("ceshi");
//        blog.setPicture("picture");
//        blog.setAppreciate_switch(true);
//        blog.setComment_switch(true);
//        blog.setCopyright_switch(true);
//        blog.setRelease_switch(true);
//        blog.setViews(10);
//        type.setId(1);
//        type.setType_name("java");
//        blog.setType(type);
//        for (int i=0;i<20;i++){
//            blogServiceImpl.addBlog(blog);
//        }
//        return "redirect:/admin/blog";
//    }

}
