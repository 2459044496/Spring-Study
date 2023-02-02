package cn.cuiper.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
