package com.pfy.blog.service.impl;

import com.pfy.blog.entity.Comment;
import com.pfy.blog.entity.Reply;
import com.pfy.blog.service.CommentService;
import com.pfy.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReplyServiceImpl {

    @Autowired
    private ReplyService replyService;

    public void addReply(Reply reply){
        replyService.addReply(reply);
    }

    public List<Reply> selectReply(int blog_id,int comment_id){
       return replyService.selectReplyByBlogAndComment(blog_id,comment_id);
    }


}
