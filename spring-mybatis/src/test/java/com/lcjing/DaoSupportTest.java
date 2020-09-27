package com.lcjing;

import com.lcjing.crud.daosupport.EmployeeDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lcjing
 * @date 2020/09/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DaoSupportTest {
    @Autowired
    EmployeeDaoImpl employeeDao;

    @Test
    public void EmployeeDaoSupportTest() {
        System.out.println(employeeDao.selectByPrimaryKey(1));
    }

}
