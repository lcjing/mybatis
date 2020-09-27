package com.lcjing;

import com.lcjing.mapper.BlogMapper;
import com.lcjing.model.Blog;
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
 * 测试 mybatis 插件
 *
 * @author lcjing
 * @date 2020/09/24
 */
public class PageInterceptorTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    /**
     * 要先在配置文件中开启插件
     */
    @Test
    public void testPlugin() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int start = 2;
            int pageSize = 5;
            RowBounds rb = new RowBounds(start, pageSize);
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            List<Blog> list = mapper.selectBlogList(rb);
            for (Blog b : list) {
                System.out.println(b);
            }
        } finally {
            session.close();
        }
    }
}
