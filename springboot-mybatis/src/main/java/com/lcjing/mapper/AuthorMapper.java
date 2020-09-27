package com.lcjing.mapper;

import com.lcjing.model.Author;

/**
 * @author lcjing
 * @date 2020/09/24
 */
public interface AuthorMapper {
    int deleteByPrimaryKey(Integer authorId);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Integer authorId);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}