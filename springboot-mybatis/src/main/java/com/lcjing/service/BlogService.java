package com.lcjing.service;

import com.lcjing.model.Blog;

/**
 * @author lcjing
 * @date 2020/09/24
 */
public interface BlogService {
    /**
     * 通过id查询指定文章
     * @param id id
     * @return Blog
     */
    Blog queryById(Integer id);
}
