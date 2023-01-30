package aspectj.service;

import org.springframework.stereotype.Service;

@Service
public interface BookService {

    public void add();

    public void del(int id);

    public Object sel();

    public Long addNum(int num1, int num2);

}
