1,引入相关jar;druid、mysql、Spring-jdbc
2,配置连接信息,xml配置JdbcTemplate
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
<!--注入 dataSource-->
<property name="dataSource" ref="dataSource"></property><!--set方式注入-->
</bean>
3.Spring配置类新增 @ImportResource("classpath:druid.xml")
  xml和注解同时使用