package aspectj.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface BookDao {

    public void add();

    public void del(int id);

    public Object sel();

    public Long addNum(int num1, int num2);

}
