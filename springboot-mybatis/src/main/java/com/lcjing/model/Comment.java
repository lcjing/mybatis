package com.lcjing.model;

import java.io.Serializable;


/**
 * @author lcjing
 * @date 2020/09/24
 */
public class Comment implements Serializable {
    private Integer commentId;

    private String content;

    private Integer bid;

    private static final long serialVersionUID = 1L;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", bid=" + bid +
                '}';
    }
}