package com.lcjing;

import com.lcjing.mapper.BlogMapper;
import com.lcjing.model.Blog;
import com.lcjing.model.associate.AuthorAndBlog;
import com.lcjing.model.associate.BlogAndAuthor;
import com.lcjing.model.associate.BlogAndComment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis API 基本测试、关联查询、延迟加载、缓存
 *
 * @author lcjing
 * @date 2020/09/24
 */
public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 使用 MyBatis API方式
     */
    @Test
    public void testSession() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = session.selectOne("com.lcjing.mapper.BlogMapper.selectByPrimaryKey", 1);
            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    /**
     * Mapper 查询方式
     */
    @Test
    public void testMapper() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectByPrimaryKey(1);
            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    /**
     * 一对一，一篇文章对应一个作者
     * 嵌套结果，不存在 N+1问题
     */
    @Test
    public void testSelectBlogWithAuthorResult() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            BlogAndAuthor blog = mapper.selectBlogWithAuthorResult(1);
            System.out.println("-----------:" + blog);
        } finally {
            session.close();
        }
    }

    /**
     * 一对一，一篇文章对应一个作者
     * 嵌套查询，会有N+1的问题, 可通过开启延迟加载解决
     */
    @Test
    public void testSelectBlogWithAuthorQuery() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);

            BlogAndAuthor blog = mapper.selectBlogWithAuthorQuery(1);
            System.out.println("-----------:" + blog.getClass());
            // 如果开启了延迟加载(lazyLoadingEnabled=true)，会在使用的时候才发出SQL
            // equals,clone,hashCode,toString也会触发延迟加载
            //System.out.println("-----------调用toString方法:"+blog);
            //System.out.println("-----------getAuthor:"+blog.getAuthor().toString());
            // 如果 aggressiveLazyLoading = true ，也会触发加载，否则不会
            System.out.println("-----------getName:" + blog.getName());
        } finally {
            session.close();
        }
    }

    /**
     * 一对多关联查询：一篇文章对应多条评论
     *
     * @throws IOException
     */
    @Test
    public void testSelectBlogWithComment() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            BlogAndComment blog = mapper.selectBlogWithCommentById(1);
            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    /**
     * 多对多关联查询：作者的文章的评论
     *
     * @throws IOException
     */
    @Test
    public void testSelectAuthorWithBlog() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            List<AuthorAndBlog> authors = mapper.selectAuthorWithBlog();
            for (AuthorAndBlog author : authors) {
                System.out.println(author);
            }
        } finally {
            session.close();
        }
    }

    /**
     * 逻辑分页
     */
    @Test
    public void testSelectByRowBounds() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            int start = 0;
            int pageSize = 5;
            RowBounds rb = new RowBounds(start, pageSize);
            // 使用逻辑分页
            List<Blog> list = mapper.selectBlogList(rb);
            for (Blog b : list) {
                System.out.println(b);
            }
        } finally {
            session.close();
        }
    }


}
