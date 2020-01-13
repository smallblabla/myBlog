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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TagsController {

    @Autowired
    private TagServiceImpl tagServiceImpl;
    @Autowired
    private BlogServiceImpl blogServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;


//    public String tag(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
//        int tagNum = tagServiceImpl.selectTagNum();
//        List<Tag> tags = tagServiceImpl.selectTags();
//        for(Tag tag:tags){
//            tag.setTagNum(tagServiceImpl.selectOneTagNum(tag.getTag_id()));
//        }
//        PageHelper.startPage(pageNum,5);
//        List<Blog> blogs = blogServiceImpl.selectBlogByTag(tags.get(0).getTag_id());
//        PageInfo<Blog> pageBlogs = new PageInfo<Blog>(blogs);
//        for(Blog blog:blogs){
//            blog.setTags(tagServiceImpl.selectOneBlogTag(tagServiceImpl.tagsToList(blogServiceImpl.selectBlogById(Math.toIntExact(blog.getId())).getTagIds())));
//            System.out.println(blog.getTags());
//        }
//        model.addAttribute("pageBlogs", pageBlogs);
//        model.addAttribute("tags",tags);
//        model.addAttribute("tagNum",tagNum);
//        model.addAttribute("nowId",tags.get(0).getTag_id());
//        return "tags";
//    }

    @RequestMapping("/tag")
    public String tag(){
        List<Tag> tags = tagServiceImpl.selectTags();
        String toShow = "/tag/" + tags.get(0).getTag_id();
        return "redirect:"+toShow;
    }


    @RequestMapping("/tag/{id}")
    public String tagNum(Model model,
                          @PathVariable int id,
                          @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        User user = userServiceImpl.getUser();
        user.setPassword(null);
        model.addAttribute("user",user);
        int tagNum = tagServiceImpl.selectTagNum();
        List<Tag> tags = tagServiceImpl.selectTags();
        for(Tag tag:tags){
            tag.setTagNum(tagServiceImpl.selectOneTagNum(tag.getTag_id()));
        }
        PageHelper.startPage(pageNum,5);
        List<Blog> blogs = blogServiceImpl.selectBlogByTag(id);
        PageInfo<Blog> pageBlogs = new PageInfo<Blog>(blogs);
        for(Blog blog:blogs){
            blog.setTags(tagServiceImpl.selectOneBlogTag(tagServiceImpl.tagsToList(blogServiceImpl.selectBlogById(Math.toIntExact(blog.getId())).getTagIds())));
            System.out.println(blog.getTags());
        }
        model.addAttribute("pageBlogs", pageBlogs);
        model.addAttribute("tags",tags);
        model.addAttribute("tagNum",tagNum);
        model.addAttribute("nowId",id);
        return "tags";
    }
}
