package cn.cuiper.tx.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public Boolean addMoney(int addMoney);
}
