package com.pfy.blog.service;

import com.pfy.blog.entity.Type;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TypeService {
    void addType(String typeName);
    void changeType(Type type);
    void deleteType(int id);
    List<Type> selectTypes();
    Type selectTypeById(int id);
    int selectTypeNum();
    int selectOneTypeNum(int type_id);
    @MapKey("type_id")
    Map<Integer,Integer> selectTopType();
    List<Type> selectSomeType();
}
