package com.lcjing.crud.dao;

import com.lcjing.crud.bean.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * @author lcjing
 * @date 2020/09/27
 */
public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int updateBatch(List<Employee> list);

    int insertSelective(Employee record);

    int batchInsert(List<Employee> list);

    Employee selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    void deleteByList(List<Integer> ids);

    long countByMap(HashMap<String, String> map);

    List<Employee> selectByMap(HashMap<String, Object> map);
}