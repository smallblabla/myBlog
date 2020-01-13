package com.pfy.blog.service;

import com.pfy.blog.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentService {
     void addComment(Comment comment);
     List<Comment> selectCommentById(int blog_id);
}
