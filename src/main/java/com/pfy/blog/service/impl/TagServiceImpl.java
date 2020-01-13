package com.pfy.blog.service.impl;

import com.pfy.blog.entity.Tag;
import com.pfy.blog.service.TagService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl {

    @Autowired
    private TagService tagService;
    public void addTag(String tagName){
        tagService.addTag(tagName);
    }
    public void deleteTag(int id){
        tagService.deleteTag(id);
    }
    public List<Tag> selectTags(){ return tagService.selectTags(); }
    public void changeTag(Tag tag){
        tagService.changeTag(tag);
    }
    public Tag selectTagById(int id){
        return tagService.selectTagById(id);
    }
    public List<Long> tagsToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
    public String listToTags(List<Integer> tags){
        StringBuffer str = new StringBuffer();
        for (int s : tags) {
            str.append(s);
        }
        return str.toString();
    }
    public int selectTagNum(){
        return tagService.selectTagNum();
    }

    public int selectOneTagNum(int tag_id){return tagService.selectOneTagNum(tag_id);}

    public List<Tag> selectOneBlogTag(@Param("tag_ids")List<Long> tags_id){return tagService.selectOneBlogTag(tags_id);}

    public List<Tag> selectSomeTag(){return tagService.selectSomeTag();}
}
