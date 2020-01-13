package com.pfy.blog.service;

import com.pfy.blog.entity.Tag;
import com.pfy.blog.entity.Type;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TagService {
    void addTag(String tagName);
    void changeTag(Tag tag);
    void deleteTag(int id);
    List<Tag> selectTags();
    Tag selectTagById(int id);
    int selectTagNum();
    int selectOneTagNum(int tag_id);
    List<Tag> selectOneBlogTag(@Param("tag_ids")List<Long> tags_id);
    List<Tag> selectSomeTag();
}
