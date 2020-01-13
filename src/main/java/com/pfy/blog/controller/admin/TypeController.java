package com.pfy.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pfy.blog.entity.Type;
import com.pfy.blog.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeServiceImpl typeServiceImpl;

    @RequestMapping("/type")
    public String showTypes(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Type> types = typeServiceImpl.selectTypes();
        PageInfo<Type> pageTypes = new PageInfo<Type>(types);
        model.addAttribute("pageTypes",pageTypes);
        return "admin/admin_types";
    }

    @RequestMapping("/type/toAddType")
    public String toAddType(){
        return "admin/admin_addType";
    }

    @RequestMapping("/type/addType")
    public String toAddType(@RequestParam String typeName){
        typeServiceImpl.addType(typeName);
        return "redirect:/admin/type";
    }


    @RequestMapping("/type/deleteType/{id}")
    public String deleteType(@PathVariable int id){
        typeServiceImpl.deleteType(id);
        return "redirect:/admin/type";
    }

    @RequestMapping("/type/toChangeType/{id}")
    public String toChangeType(@PathVariable int id,Model model){
        Type type = typeServiceImpl.selectTypeById(id);
        model.addAttribute("type",type);
        return "admin/admin_addType";
    }

    @RequestMapping("/type/changeType/{id}")
    public String changeType(@PathVariable int id,@RequestParam String typeName){
        Type type = new Type();
        type.setType_id(id);
        type.setType_name(typeName);
        typeServiceImpl.changeType(type);
        return "redirect:/admin/type";
    }
}
