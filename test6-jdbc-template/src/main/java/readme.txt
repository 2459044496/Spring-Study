1,引入相关jar;druid、mysql、Spring-jdbc
2,配置连接信息,xml配置JdbcTemplate
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
<!--注入 dataSource-->
<property name="dataSource" ref="dataSource"></property><!--set方式注入-->
</bean>
3.Spring配置类新增 @ImportResource("classpath:druid.xml")
  xml和注解同时使用

 使用JdbcTemplate
 1,新增、修改、删除
 jdbcTemplate.update(sql, param);
 2,查询返回单个值
 jdbcTemplate.queryForObject(sql, 返回值类型);
 3,查询返回对象
 jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(对象类型), param);
 4,查询返回集合对象
 jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(对象类型), param);
 5,批量新增、修改
 jdbcTemplate.batchUpdate(sql, List<Object[]>)