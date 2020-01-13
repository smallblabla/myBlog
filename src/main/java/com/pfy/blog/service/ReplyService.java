package com.pfy.blog.service;

import com.pfy.blog.entity.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyService {
     void addReply(Reply reply);
     List<Reply> selectReplyByBlogAndComment(int blog_id,int comment_id);
}
