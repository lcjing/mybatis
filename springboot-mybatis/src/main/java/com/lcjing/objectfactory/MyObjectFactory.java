package com.lcjing.objectfactory;

import com.lcjing.model.Blog;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * 自定义ObjectFactory，通过反射的方式实例化对象
 * 一种是无参构造函数，一种是有参构造函数——第一个方法调用了第二个方法
 *
 * @author lcjing
 * @date 2020/09/24
 */
public class MyObjectFactory extends DefaultObjectFactory {

    /**
     * 创建DefaultResultSetHandler 或创建对象的时候调用该方法
     * @param type
     * @return
     */
    @Override
    public Object create(Class type) {
        System.out.println("创建对象方法：" + type);
        if (type.equals(Blog.class)) {
            Blog blog = (Blog) super.create(type);
            blog.setName("object factory");
            blog.setBid(1111);
            blog.setAuthorId(2222);
            blog.setValue("12345");
            return blog;
        }
        Object result = super.create(type);
        return result;
    }
}
