package com.lcjing.controller;

import com.lcjing.model.Blog;
import com.lcjing.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lcjing
 * @date 2020/09/24
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 查询Blog
     * @param id id
     * @return Blog
     */
    @GetMapping
    public Blog queryBlog(Integer id) {
        return blogService.queryById(id);
    }
}
