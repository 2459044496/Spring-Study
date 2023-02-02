package cn.cuiper.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Boolean addMoney(int addMoney) {
        String addMoneySql = "update account set money = money + ? where name = 'cui'";
        jdbcTemplate.update(addMoneySql, addMoney);

        int i = 1 / 0;

        String reduceMoneySql = "update account set money = money - ? where name = 'pai'";
        jdbcTemplate.update(reduceMoneySql, addMoney);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED,
    timeout = 10, readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public void transactionDetail() {
        /*
         * propagation 事务传播行为，默认REQUIRED
         * REQUIRED 如果当前没有事务，则自己新建一个事务，如果当前存在事务，则加入这个事务
         * SUPPORTS 当前存在事务，则加入当前事务，如果当前没有事务，就以非事务方法执行
         * MANDATORY 当前存在事务，则加入当前事务，如果当前事务不存在，则抛出异常
         * REQUIRES_NEW 创建一个新事务，如果存在当前事务，则挂起该事务。
         * NOT_SUPPORTED 始终以非事务方式执行,如果当前存在事务，则挂起当前事务
         * NEVER 不使用事务，如果当前事务存在，则抛出异常
         * NESTED 如果当前事务存在，则在嵌套事务中执行，否则REQUIRED的操作一样（开启一个事务）
         */

        // timeout 超时时间，单位秒，默认-1
        // readOnly 是否只读 默认false

        /*
         *  isolation 事务隔离级别，默认可重复读REPEATABLE_READ，会导致幻读
         *                              脏读	不可重复读	虚读
         * READ_UNCOMMITED（读未提交）	有	    有	    有
         * READ_COMMITED（读已提交）	    无	    有	    有
         * REPEATABLE READ（可重复读）	无	    无	    有
         * SERIALIZABLE（串行化）	        无	    无	    无
         * 脏读：一个未提交事物可以读取到另一个未提交事务修改的数据
         * 不可重复读：一个未提交事物读取到另一个已提交事物修改的数据
         * 幻读：一个未提交事物可以读取到另一个已提交事务新增的数据
         */
    }


    /*
     * 编程式事务
     * 1.通过PlatformTransactionManager控制事务
     * 2.通过TransactionTemplate控制事务
     */

    @Autowired
    @Qualifier("myA")
    private PlatformTransactionManager manager;

    @Autowired
    private TransactionTemplate template;

    public void testPlatformTransactionManager() {
        TransactionStatus transaction = manager.getTransaction(new DefaultTransactionAttribute());
        try {
            String addMoneySql = "update account set money = money + 123 where name = 'cui'";
            jdbcTemplate.update(addMoneySql);
            int i = 1 / 0;
            // do something
            manager.commit(transaction);
        } catch (Exception e) {
            System.out.println("回滚");
            // 回滚
            manager.rollback(transaction);
        }
    }

    public void testTransactionTemplate() {
        template.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try {
                    String addMoneySql = "update account set money = money + 123 where name = 'cui'";
                    jdbcTemplate.update(addMoneySql);
                    int i = 1 / 0;
                    // do something
                    return null;
                } catch (Exception e) {
                    // 回滚
                    System.out.println("回滚");
                    status.setRollbackOnly();
                    return null;
                }
            }
        });
    }



}
