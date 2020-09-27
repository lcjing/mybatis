package com.lcjing.crud.dao;

import com.lcjing.crud.bean.Department;

import java.util.List;

/**
 * @author lcjing
 * @date 2020/09/27
 */
public interface DepartmentMapper {

    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByMap(Object o);
}