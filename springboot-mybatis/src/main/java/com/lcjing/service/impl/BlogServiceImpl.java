package com.lcjing.service.impl;

import com.lcjing.mapper.BlogMapper;
import com.lcjing.model.Blog;
import com.lcjing.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lcjing
 * @date 2020/09/24
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 通过id查询指定文章
     * @param id id
     * @return Blog
     */
    @Override
    public Blog queryById(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }
}
