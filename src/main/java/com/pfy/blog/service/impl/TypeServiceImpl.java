package com.pfy.blog.service.impl;

import com.pfy.blog.entity.Type;
import com.pfy.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl {

    @Autowired
    private TypeService typeService;
    public void addType(String typeName){
        typeService.addType(typeName);
    }
    public void deleteType(int id){
        typeService.deleteType(id);
    }
    public List<Type> selectTypes(){
        return typeService.selectTypes();
    }
    public void changeType(Type type){
        typeService.changeType(type);
    }
    public Type selectTypeById(int id){
        return typeService.selectTypeById(id);
    }
    public int selectTypeNum(){return typeService.selectTypeNum();}
    public int selectOneTypeNum(int type_id){return typeService.selectOneTypeNum(type_id);}
    public Map<Integer,Integer> selectTopType(){return typeService.selectTopType();}
    public List<Type> selectSomeType(){ return typeService.selectSomeType();}
}
