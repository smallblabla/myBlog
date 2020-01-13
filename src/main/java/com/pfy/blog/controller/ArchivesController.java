package com.pfy.blog.controller;
import com.pfy.blog.entity.Blog;
import com.pfy.blog.entity.Type;
import com.pfy.blog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArchivesController {

    @Autowired
    private BlogServiceImpl blogServiceImpl;

    @RequestMapping("/archives")
    public String archives(Model model) {
        int blogNum = blogServiceImpl.selectBlogNum();
        Map<String, List<Blog>> blogMap = new HashMap<String, List<Blog>>();
        for (String year:blogServiceImpl.selectYears()){
            blogMap.put(year,blogServiceImpl.selectBlogByYear(year));
        }
        model.addAttribute("blogNum",blogNum);
        model.addAttribute("blogMap",blogMap);
        return "archives";
    }


}
