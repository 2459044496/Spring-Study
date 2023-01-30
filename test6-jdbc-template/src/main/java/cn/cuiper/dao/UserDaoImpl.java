package cn.cuiper.dao;

import cn.cuiper.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "insert into user values (?,?,?)";
        Object[] args = {user.getId(), user.getName(), user.getPwd()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("update sql返回结果:" + update);
    }
}
