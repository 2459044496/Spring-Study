package cn.cuiper.dao.impl;

import cn.cuiper.config.MyImportBeanDefinitionRegistrar;
import cn.cuiper.config.MyImportSelector;
import cn.cuiper.dao.PersonDao;
import cn.cuiper.pojo.User;
import cn.cuiper.service.PersonService;
import cn.cuiper.service.impl.PersonServiceImpl;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;

@Repository
@Import({PersonServiceImpl.class, User.class,
        MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class PersonDaoImpl implements PersonDao {
}
