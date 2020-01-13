package com.pfy.blog.entity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Blog {
    private Long id; //id，主键
    private String title; //标题
    private String content; //内容
    private String description; //描述
    private String picture; //首页图片
    private String flag; //标记
    private Integer views; //浏览次数
    private boolean appreciate_switch; //赞赏开关
    private boolean copyright_switch; //版权开关
    private boolean comment_switch; //评论开关
    private boolean release_switch; //发布开关
    private boolean recommend_switch; //推荐开关
    private Type type; //类型
    private String tagIds;
    private List<Tag> tags;
    @CreateTime
    private Date create_time; //创建时间
    @UpdateTime
    private Date update_time; //更新时间
    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciate_switch=" + appreciate_switch +
                ", copyright_switch=" + copyright_switch +
                ", comment_switch=" + comment_switch +
                ", release_switch=" + release_switch +
                ", recommend_switch=" + recommend_switch +
                ", type=" + type +
                ", tagIds='" + tagIds + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciate_switch() {
        return appreciate_switch;
    }

    public void setAppreciate_switch(boolean appreciate_switch) {
        this.appreciate_switch = appreciate_switch;
    }

    public boolean isCopyright_switch() {
        return copyright_switch;
    }

    public void setCopyright_switch(boolean copyright_switch) {
        this.copyright_switch = copyright_switch;
    }

    public boolean isComment_switch() {
        return comment_switch;
    }

    public void setComment_switch(boolean comment_switch) {
        this.comment_switch = comment_switch;
    }

    public boolean isRelease_switch() {
        return release_switch;
    }

    public void setRelease_switch(boolean release_switch) {
        this.release_switch = release_switch;
    }

    public boolean isRecommend_switch() {
        return recommend_switch;
    }

    public void setRecommend_switch(boolean recommend_switch) {
        this.recommend_switch = recommend_switch;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCreate_time() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm");
        return ft.format(create_time);
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm");
        return ft.format(update_time);
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
