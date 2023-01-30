package cn.cuiper.dao;

import cn.cuiper.projo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public void add(User user);
}
