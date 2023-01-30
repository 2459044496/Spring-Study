package cn.cuiper.spring.service;

import cn.cuiper.spring.dao.UserDao;

public class UserServiceImpl implements UserService{

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void exeService() {
        System.out.println("UserService1Impl exe......");
        userDao.updateDb();
    }
}
