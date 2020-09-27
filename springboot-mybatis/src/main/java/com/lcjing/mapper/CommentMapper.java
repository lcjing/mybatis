package com.lcjing.mapper;

import com.lcjing.model.Comment;

/**
 * @author lcjing
 * @date 2020/09/24
 */
public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}