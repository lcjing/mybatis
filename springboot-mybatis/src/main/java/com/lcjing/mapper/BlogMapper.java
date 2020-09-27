package com.lcjing.mapper;

import com.lcjing.model.Blog;
import com.lcjing.model.associate.AuthorAndBlog;
import com.lcjing.model.associate.BlogAndAuthor;
import com.lcjing.model.associate.BlogAndComment;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author lcjing
 * @date 2020/09/24
 */
public interface BlogMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    /**
     * 新增博客
     *
     * @param blog
     * @return
     */
    int insertBlog(Blog blog);

    /**
     * 批量插入博客
     *
     * @param list
     * @return
     */
    int insertBlogList(List<Blog> list);

    /**
     * 批量更新博客
     *
     * @param list
     * @return
     */
    int updateBlogList(List<Blog> list);

    /**
     * 根据博客查询作者，一对一，嵌套结果
     *
     * @param bid
     * @return
     */
    BlogAndAuthor selectBlogWithAuthorResult(Integer bid);

    /**
     * 根据博客查询作者，一对一，嵌套查询，存在N+1问题
     *
     * @param bid
     * @return
     */
    BlogAndAuthor selectBlogWithAuthorQuery(Integer bid);

    /**
     * 查询文章带出文章所有评论（一对多）
     *
     * @param bid
     * @return
     */
    BlogAndComment selectBlogWithCommentById(Integer bid);

    /**
     * 查询作者带出博客和评论（多对多）
     *
     * @return
     */
    List<AuthorAndBlog> selectAuthorWithBlog();

    /**
     * 文章列表翻页查询
     * @param rowBounds
     * @return
     */
    List<Blog> selectBlogList(RowBounds rowBounds);
}