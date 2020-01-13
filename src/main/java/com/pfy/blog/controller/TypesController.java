package com.pfy.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pfy.blog.entity.Blog;
import com.pfy.blog.entity.Type;
import com.pfy.blog.entity.User;
import com.pfy.blog.service.impl.BlogServiceImpl;
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
public class TypesController {

    @Autowired
    private TypeServiceImpl typeServiceImpl;
    @Autowired
    private BlogServiceImpl blogServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;

//    @RequestMapping("/type")
//    public String type(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
//        int typeNum = typeServiceImpl.selectTypeNum();
//        List<Type> types = typeServiceImpl.selectTypes();
//        for(Type type:types){
//            type.setTypeNum(typeServiceImpl.selectOneTypeNum(type.getType_id()));
//        }
//        PageHelper.startPage(pageNum,5);
//        List<Blog> blogs = blogServiceImpl.selectBlogByType(types.get(0).getType_id());
//        PageInfo<Blog> pageBlogs = new PageInfo<Blog>(blogs);
//        model.addAttribute("pageBlogs", pageBlogs);
//        model.addAttribute("types",types);
//        model.addAttribute("typeNum",typeNum);
//        model.addAttribute("nowId",types.get(0).getType_id());
//        return "types";
//    }

    @RequestMapping("/type")
    public String type(){
        List<Type> types = typeServiceImpl.selectTypes();
        String toShow = "/type/" + types.get(0).getType_id();
        return "redirect:"+toShow;
    }


    @RequestMapping("/type/{id}")
    public String typeNum(Model model,
                          @PathVariable int id,
                          @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        User user = userServiceImpl.getUser();
        user.setPassword(null);
        model.addAttribute("user",user);
        int typeNum = typeServiceImpl.selectTypeNum();
        List<Type> types = typeServiceImpl.selectTypes();
        for (Type type : types) {
            type.setTypeNum(typeServiceImpl.selectOneTypeNum(type.getType_id()));
        }
        PageHelper.startPage(pageNum,5);
        List<Blog> blogs = blogServiceImpl.selectBlogByType(id);
        System.out.println(blogs);
        PageInfo<Blog> pageBlogs = new PageInfo<Blog>(blogs);
        model.addAttribute("types", types);
        model.addAttribute("typeNum", typeNum);
        model.addAttribute("pageBlogs", pageBlogs);
        model.addAttribute("nowId",id);
        return "types";
    }


}
