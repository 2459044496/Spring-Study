package cn.cuiper.tx.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public Boolean addMoney(int addMoney);

    // 测试声明式事务
    public void testPlatformTransactionManager();
    public void testTransactionTemplate();
}
