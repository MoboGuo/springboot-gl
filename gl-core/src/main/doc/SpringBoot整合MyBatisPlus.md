1、pom文件

```pom
<!--MyBatis-Plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.3.1</version>
</dependency>
<!-- mysql驱动7.0-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.27</version>
</dependency>
```

2、配置文件application.yml

```yml
spring:
  #MySQL数据源连接
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://101.200.145.49:3306/satokens?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT
    username: root
    password: LIUkl@159357
```

```yml
mybatis-plus:
  mapper-locations: mapper/*.xml  #mapper文件路径
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl #控制台输出日志
    map-underscore-to-camel-case: true #驼峰命名转换
  type-aliases-package: com.example.gladmin.domain #实体类路径
```

3、SpringBoot启动类增加mapper文件扫描路径

```java
@MapperScan(basePackages = "com.example.gladmin.mapper")
```

注意，如果有service层，需要添加@Service注解以便被Spring扫描加载

4、使用MybatisPlus：

```java
//mapper文件需要继承BaseMapper<Entity>
//1、服务层可直接调用BaseMapper中的CRUD方法。
//2、LambdaQueryWrapper用法示例：
public TSysUser getUserByName(String userName) {
        LambdaQueryWrapper<TSysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TSysUser::getUsername, userName);
        return mpTestDao.selectOne(lambdaQueryWrapper);
    }
//3、更多用法自行探索
```

