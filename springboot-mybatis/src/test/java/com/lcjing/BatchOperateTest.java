package com.lcjing;

import com.lcjing.mapper.BlogMapper;
import com.lcjing.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * 测试批量更新操作性能
 *
 * @author lcjing
 * @date 2020/09/24
 */
public class BatchOperateTest {
    private BlogMapper mapper;
    private SqlSession session;

    @Before
    public void init() {
        System.out.println("init......");
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            mapper = session.getMapper(BlogMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // session.close();
        }
    }

    /**
     * 循环批量插入---1万条
     */
    @Test
    public void testInsertOneByOne() {
        long start = System.currentTimeMillis();
        int count = 12000;
        for (int i = 2000; i < count; i++) {
            Blog blog = new Blog();
            blog.setBid(i);
            blog.setName("name" + i);
            blog.setAuthorId(i);
            mapper.insertBlog(blog);
        }
        session.commit();
        session.close();
        long end = System.currentTimeMillis();
        System.out.println("循环批量插入" + count + "条，耗时：" + (end - start) + "毫秒");
    }


    /**
     * MyBatis 动态SQL批量插入
     */
    @Test
    public void testInsert() {
        long start = System.currentTimeMillis();
        int count = 12000;
        List<Blog> list = new ArrayList<>();
        for (int i = 2000; i < count; i++) {
            Blog blog = new Blog();
            blog.setBid(i);
            blog.setName("name" + i);
            blog.setAuthorId(i);
            list.add(blog);
        }
        mapper.insertBlogList(list);
        session.commit();
        session.close();
        long end = System.currentTimeMillis();
        System.out.println("动态SQL批量插入" + count + "条，耗时：" + (end - start) + "毫秒");
    }

    /**
     * MyBatis 动态SQL批量更新
     */
    @Test
    public void updateBlogList() {
        long start = System.currentTimeMillis();
        int count = 12000;
        List<Blog> list = new ArrayList<Blog>();
        for (int i = 2000; i < count; i++) {
            Blog blog = new Blog();
            blog.setBid(i);
            blog.setName("modified name" + i);
            blog.setAuthorId(i);
            list.add(blog);
        }
        mapper.updateBlogList(list);
        session.commit();
        session.close();
        long end = System.currentTimeMillis();
        System.out.println("批量更新" + count + "条，耗时：" + (end - start) + "毫秒");
    }
}
