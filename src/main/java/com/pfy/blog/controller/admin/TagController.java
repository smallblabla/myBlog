package com.pfy.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pfy.blog.entity.Tag;
import com.pfy.blog.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagServiceImpl tagServiceImpl;

    @RequestMapping("/tag")
    public String showTags(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Tag> tags = tagServiceImpl.selectTags();
        PageInfo<Tag> pageTags = new PageInfo<Tag>(tags);
        model.addAttribute("pageTags",pageTags);
        return "admin/admin_tags";
    }

    @RequestMapping("/tag/toAddTag")
    public String toAddTag(){
        return "admin/admin_addTag";
    }

    @RequestMapping("/tag/addTag")
    public String toAddTag(@RequestParam String tagName){
        tagServiceImpl.addTag(tagName);
        return "redirect:/admin/tag";
    }


    @RequestMapping("/tag/deleteTag/{id}")
    public String deleteTag(@PathVariable int id){
        tagServiceImpl.deleteTag(id);
        return "redirect:/admin/tag";
    }

    @RequestMapping("/tag/toChangeTag/{id}")
    public String toChangeTag(@PathVariable int id,Model model){
        Tag tag = tagServiceImpl.selectTagById(id);
        model.addAttribute("tag",tag);
        return "admin/admin_addTag";
    }

    @RequestMapping("/tag/changeTag/{id}")
    public String changeTag(@PathVariable int id,@RequestParam String tagName){
        Tag tag = new Tag();
        tag.setTag_id(id);
        tag.setTag_name(tagName);
        tagServiceImpl.changeTag(tag);
        return "redirect:/admin/tag";
    }
}
