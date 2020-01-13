package com.pfy.blog.entity;

import java.util.Date;
import java.util.List;

public class Comment {
    private int comment_id;
    private String username;
    private String email;
    private String content;
    @CreateTime
    private Date create_time;
    private int blog_id;
    private List<Reply> replies;
    private boolean admin_if;
    private User user;

    public int getComment_id() {
        return comment_id;
    }


    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAdmin_if() {
        return admin_if;
    }

    public void setAdmin_if(boolean admin_if) {
        this.admin_if = admin_if;
    }
}
