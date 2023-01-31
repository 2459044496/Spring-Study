package cn.cuiper.dao;

import cn.cuiper.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public void add(User user);

    public void update(User user);

    public void delById(Integer id);

    public Long getCount();

    public User selById(Integer id);

    public List<User> selAllUser();

    public void batchAddUser(List<User> list);

    public void batchUpdateUser(List<User> list);

}
