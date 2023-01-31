package cn.cuiper.service;

import org.springframework.stereotype.Service;
import cn.cuiper.pojo.User;

import java.util.List;

@Service
public interface UserService {

    public void add(User user);

    public void update(User user);

    public void delById(Integer id);

    public Long getCount();

    public User selById(Integer id);

    public List<User> selAllUser();

    public void batchAddUser(List<User> list);

    public void batchUpdateUser(List<User> list);

}
