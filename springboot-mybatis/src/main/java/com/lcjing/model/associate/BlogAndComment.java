package com.lcjing.model.associate;

import com.lcjing.model.Comment;

import java.io.Serializable;
import java.util.List;

/**
 * 一篇文章对应多条评论
 *
 * @author lcjing
 * @date 2020/09/24
 */
public class BlogAndComment implements Serializable {
    private static final long serialVersionUID = -2140809573173681102L;
    /**
     * 文章id
     */
    Integer bid;
    /**
     * 文章标题
     */
    String name;
    /**
     * 对应的作者的id
     */
    Integer authorId;
    /**
     * 文章的所有评论
     */
    List<Comment> comment;

    @Override
    public String toString() {
        return "BlogAndComment{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", comment=" + comment +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
