package com.lcjing.model;

import java.io.Serializable;

/**
 * @author lcjing
 * @date 2020/09/24
 */
public class Author implements Serializable {
    private Integer authorId;

    private String authorName;

    private static final long serialVersionUID = 1L;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}