package com.lcjing.model.associate;

import com.lcjing.model.Author;

import java.io.Serializable;

/**
 * 一篇文章对应一个作者
 *
 * @author lcjing
 * @date 2020/09/24
 */
public class BlogAndAuthor implements Serializable {
    /**
     * 文章ID
     */
    Integer bid;
    /**
     * 文章标题
     */
    String name;
    /**
     * 对应的作者
     */
    Author author;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BlogAndAuthor{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
