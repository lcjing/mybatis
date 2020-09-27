##  Mybatis 源码编译

###  1.  环境配置

* JDK 环境配置
* maven 环境配置

###  2.  下载源码包

```java
https://github.com/mybatis/parent
https://github.com/mybatis/mybatis-3
```

###  3.  进行解压

![image-20200924151151226](.\images\image-20200924151151226.png)

###  4.  编译

####  4.1   编译 parent

* 进入 parent-mybatis-parent-31 目录

* cmd 命令执行

  ```java
  mvn install -Dlicense.skip=true
  ```

* 编译成功如下

![image-20200924151430631](.\images\image-20200924151430631.png)

####  4.2  编译 Mybatis

* 进入 mybatis-3-mybatis-3.5.5 目录

* 修改 pom.xml 文件中的 mybatis 版本为：3.5.5-snapshot，避免编译出来和官方jar包名字相同。

  ![image-20200924152507820](.\images\image-20200924152507820.png)

* cmd 命令执行：

  ```java
  mvn clean
  mvn install -DskipTests=true -Dmaven.test.skip=true -Dlicense.skip=true
  ```

#### 4.3  编译成功，生成 jar 包

![image-20200924151943498](.\images\image-20200924151943498.png)

![image-20200924151901337](.\images\image-20200924151901337.png)

###  5.  使用

* 在 IDEA 中配置好 maven 仓库
* pom.xml 文件引入编译好的 mybatis-3.5.5-snapshot.jar
* jar 包关联源码，进行调试，源码添加注释
* 添加注释导致了 debug 的当前行跟实际行不一致，再重新编译一次即可