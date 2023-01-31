package cn.cuiper.service;

import cn.cuiper.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cuiper.pojo.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delById(Integer id) {
        userDao.delById(id);
    }

    @Override
    public Long getCount() {
        return userDao.getCount();
    }

    @Override
    public User selById(Integer id) {
        return userDao.selById(id);
    }

    @Override
    public List<User> selAllUser() {
        return userDao.selAllUser();
    }

    @Override
    public void batchAddUser(List<User> list) {
        userDao.batchAddUser(list);
    }

    @Override
    public void batchUpdateUser(List<User> list) {
        userDao.batchUpdateUser(list);
    }
}
