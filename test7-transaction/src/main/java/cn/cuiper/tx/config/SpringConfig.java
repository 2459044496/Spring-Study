package cn.cuiper.tx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
@Aspect
@EnableTransactionManagement
@ComponentScan(basePackages = "cn.cuiper.tx")
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

    @Value("${prop.driverClass}")
    private String driverClass;

    @Value("${prop.url}")
    private String url;

    @Value("${prop.userName}")
    private String userName;

    @Value("${prop.passWord}")
    private String passWord;

    @Pointcut("execution(* cn.cuiper.tx..*.*(..))")
    public void pointCut(){}

    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        return dataSource;
    }

    @Bean
    // 通过方法注入dataSource,避免通过方法getDruidDataSource()调用产生多个实例
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }


}
