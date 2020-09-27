package com.lcjing.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


/**
 * Mybatis 配置类
 * @author lcjing
 * @date 2020/09/24
 */
@Configuration
@MapperScan("com.lcjing.mapper")
public class MybatisConfig {
}
