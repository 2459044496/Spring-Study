package cn.cuiper.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BenzServiceImpl implements CarService{
    @Override
    public void back() {
        System.out.println("奔驰。。倒车。。");
    }
}
