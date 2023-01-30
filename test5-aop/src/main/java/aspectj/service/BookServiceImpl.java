package aspectj.service;

import aspectj.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public void add() {
        System.out.println("BookServiceImpl exe add...");
        bookDao.add();
    }

    @Override
    public void del(int id) {
        System.out.println("BookServiceImpl exe del...");
        bookDao.del(id);
    }

    @Override
    public Object sel() {
        System.out.println("BookServiceImpl exe sel...");
        bookDao.sel();
        return null;
    }

    @Override
    public Long addNum(int num1, int num2) {
        System.out.println("BookServiceImpl exe addNum... num1:" + num1 + ";num2:" + num2);
        Long aLong = bookDao.addNum(num1, num2);
        return aLong;
    }
}
