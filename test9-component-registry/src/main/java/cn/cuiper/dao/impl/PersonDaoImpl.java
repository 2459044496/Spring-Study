package cn.cuiper.dao.impl;

import cn.cuiper.dao.PersonDao;
import cn.cuiper.pojo.User;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;

@Repository
@Import({User.class})
public class PersonDaoImpl implements PersonDao {
}
