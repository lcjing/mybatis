# Spring集成MyBatis

* **包含如下示例**

　　1、Spring  JDBC

　　2、Spring 集成 MyBatis 的示例

​        3、MyBatis 插件原理解析

* **使用说明**

　　测试类主要在 test/java/com.lcjing 中

　　需要部署到tomcat中启动，访问：
    http://localhost:8080/spring_mybatis_war/emp/1

* **SqlSessionFactoryBean 用到的 Spring 的扩展点总结**

| 接口                                                         | 方法                                | 作用                                                         |
| ------------------------------------------------------------ | ----------------------------------- | ------------------------------------------------------------ |
| FactoryBean                                                  | getObject()                         | 返回由 FactoryBean创建的 Bean实例                            |
| InitializingBean                                             | afterPropertiesSet()                | Bean属性初始化完成后调用                                     |
| ApplicationListener                                          | onApplicationEvent()                | 对应用的事件进行监听                                         |
| BeanFactoryPostProcessor<br />BeanDefinitionRegistryPostProcessor | postProcessBeanDefinitionRegistry() | Spring创建Bean之前会调用：可以在 Spring创建Bean之前, 修改某些Bean在容器中的定义 |

* **Spring 替代 Mybatis 的 DefaultSqlSession 组件**

| 对象                  | 生命周期                                                     |
| --------------------- | ------------------------------------------------------------ |
| SqlSessionTemplate    | Spring 中 SqlSession 的替代品, 是线程安全的                  |
| SqlSessionInterceptor | 代理对象, 用来代理DefaultSqlSession, 在 SqlSessionTemplate中使用 |
| SqlSessionDaoSupport  | 用于获取 SqlSessionTemplate                                  |
| MapperFactoryBean     | 代理对象, 继承了 SqlsessionDaoSupport, 用来获取 SqlSessionTemplate |
| SqlSessionHolder      | 控制 SqlSession 和事务                                       |

* **MyBatis 设计模式总结**

| 设计模式     | 类/接口                                                      |
| ------------ | ------------------------------------------------------------ |
| 工厂模式     | SqlSessionFactory、ObjectFactory、MapperProxyFactoy          |
| 建造者模式   | XMLConfigBuilder、XMLMapperBuilder、XMLStatementBuilder      |
| 单例模式     | SqlSessionFactory、Configuration、ErrorContext               |
| 代理模式     | 绑定：MapperProxy<br />延迟加载：ProxyFactory<br />插件：Plugin<br />Spring 集成 MyBatis：SqlSessionTemplate 内部的 SqlSessionInterceptor<br />MyBatis 自带连接池：PooledConnection<br />日志打印：ConnectionLogger、StatementLogger |
| 适配器模式   | Log，对于Log4j、JDK logging 这些没有直接实现 Slf4j 接口的日志组件，需要适配器 |
| 模板方法模式 | BaseExecutor、SimpleExecutor、BatchExecutor、ReuseExecutor、BaseStatementHandler |
| 装饰器模式   | LoggingCache、LruCache 对 PerpetualCache 装饰<br />CachingExecutor 对其他 Executor 装饰 |
| 责任链模式   | Interceptor、InterceptorChain                                |

