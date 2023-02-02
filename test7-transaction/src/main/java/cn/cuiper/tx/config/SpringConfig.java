package cn.cuiper.tx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

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

    @Bean("myA")// 给bean起个名字，因为和getDataSourceTransactionManager()bean名重复
    public PlatformTransactionManager getPlatformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    @Bean
    // 参数使用@Autowired @Qualifier("getDataSourceTransactionManager")原因，bean重复
    public TransactionTemplate getTransactionTemplate(
            @Autowired @Qualifier("getDataSourceTransactionManager") DataSourceTransactionManager dataSourceTransactionManager) {
        TransactionTemplate template = new TransactionTemplate(dataSourceTransactionManager);
        return template;
    }
}
