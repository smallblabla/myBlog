package com.pfy.blog.controller;

import com.pfy.blog.entity.Blog;
import com.pfy.blog.entity.Comment;
import com.pfy.blog.entity.Reply;
import com.pfy.blog.entity.User;
import com.pfy.blog.service.impl.BlogServiceImpl;
import com.pfy.blog.service.impl.CommentServiceImpl;
import com.pfy.blog.service.impl.ReplyServiceImpl;
import com.pfy.blog.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class BlogsController {

    @Autowired
    BlogServiceImpl blogServiceImpl;
    @Autowired
    CommentServiceImpl commentServiceImpl;
    @Autowired
    ReplyServiceImpl replyServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping("/blog/{id}")
    public String blog(Model model, @PathVariable int id){
        User user = userServiceImpl.getUser();
        user.setPassword(null);
        model.addAttribute("user",user);
        blogServiceImpl.addView(id);
        Blog blog = blogServiceImpl.selectBlogById(id);
        List<Comment> comments = commentServiceImpl.selectCommentById(id);
        for (Comment comment : comments) {
            List<Reply> replies = replyServiceImpl.selectReply(id,comment.getComment_id());
            if (comment.isAdmin_if()){
                comment.setUser(user);
            }
            for (Reply reply : replies){
                if (reply.isAdmin_if()){
                    reply.setUser(user);
                }
            }
            comment.setReplies(replies);
        }
        model.addAttribute("blog",blog);
        model.addAttribute("comments",comments);
        return "blog";
    }

    @RequestMapping("/comment/{id}")
    public String comment(Model model,
                          @RequestParam int blog_id,
                          @RequestParam String username,
                          @RequestParam String email,
                          @RequestParam String content,
                          @RequestParam String adminIf,
                          @PathVariable int id){
        String toShow = "/blog/"+blog_id;
        Comment comment = new Comment();
        comment.setBlog_id(blog_id);
        comment.setContent(content);
        comment.setUsername(username);
        comment.setEmail(email);
        System.out.println(adminIf);
        System.out.println(adminIf);
        System.out.println(adminIf);
        System.out.println(adminIf);
        System.out.println(adminIf);
        if (adminIf.equals("true")) {
            comment.setAdmin_if(true);
        }else{
            comment.setAdmin_if(false);
        }
        commentServiceImpl.addComment(comment);
        return "redirect:"+toShow;
    }

    @RequestMapping("/reply")
    public String reply(@RequestParam int blog_id,
                        @RequestParam String username,
                        @RequestParam String email,
                        @RequestParam String content,
                        @RequestParam String reply_name,
                        @RequestParam String adminIf,
                        @RequestParam int comment_id
                        ){
        System.out.println(reply_name);
        Reply reply = new Reply();
        reply.setBlog_id(blog_id);
        reply.setComment_id(comment_id);
        reply.setContent(content);
        reply.setEmail(email);
        reply.setReply_name(reply_name);
        reply.setUsername(username);
        if (adminIf.equals("true")) {
            reply.setAdmin_if(true);
        }else {
            reply.setAdmin_if(false);
        }
        replyServiceImpl.addReply(reply);
        String toShow = "/blog/"+blog_id;
        return "redirect:"+toShow;
    }


}
