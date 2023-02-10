package cn.cuiper.service.impl;

import cn.cuiper.pojo.User;
import cn.cuiper.service.PersonService;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

public class PersonServiceImpl implements PersonService {

    @Override
    public void say() {
        System.out.println("say hello");
    }
}
