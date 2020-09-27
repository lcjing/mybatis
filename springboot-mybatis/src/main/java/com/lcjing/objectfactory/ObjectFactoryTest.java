package com.lcjing.objectfactory;

import com.lcjing.model.Blog;

/**
 * @author lcjing
 * @date 2020/09/24
 */
public class ObjectFactoryTest {
    public static void main(String[] args) {
        MyObjectFactory factory = new MyObjectFactory();
        Blog myBlog = (Blog) factory.create(Blog.class);
        System.out.println(myBlog);
    }
}
