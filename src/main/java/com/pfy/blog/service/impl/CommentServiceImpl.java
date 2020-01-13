package com.pfy.blog.service.impl;

import com.pfy.blog.entity.Comment;
import com.pfy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl {

    @Autowired
    private CommentService commentService;

    public void addComment(Comment comment){
        commentService.addComment(comment);
    }

    public List<Comment> selectCommentById(int blog_id){
        return commentService.selectCommentById(blog_id);
    }


}
