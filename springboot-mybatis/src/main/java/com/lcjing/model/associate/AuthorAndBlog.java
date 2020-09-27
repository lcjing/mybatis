package com.lcjing.model.associate;

import java.io.Serializable;
import java.util.List;

/**
 * 作者对应的文章和评论列表---多对多
 *
 * @author lcjing
 * @date 2020/09/24
 */
public class AuthorAndBlog implements Serializable {
    private static final long serialVersionUID = 5575036101927170238L;
    /**
     * 作者id
     */
    Integer author_id;
    /**
     * 作者名字
     */
    String author_name;
    /**
     * 对应的文章和评论列表
     */
    List<BlogAndComment> blog;

    @Override
    public String toString() {
        return "AuthorAndBlog{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", blog=" + blog +
                '}';
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public List<BlogAndComment> getBlog() {
        return blog;
    }

    public void setBlog(List<BlogAndComment> blog) {
        this.blog = blog;
    }
}
