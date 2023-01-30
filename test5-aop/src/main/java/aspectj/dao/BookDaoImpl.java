package aspectj.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    @Override
    public void add() {
        System.out.println("BookDaoImpl exe add...");
    }

    @Override
    public void del(int id) {
        System.out.println(1 / 0);// 测试异常通知
        System.out.println("BookDaoImpl exe del... id:" + id);
    }

    @Override
    public Object sel() {
        System.out.println("BookDaoImpl exe sel...");
        return null;
    }

    @Override
    public Long addNum(int num1, int num2) {
        System.out.println("BookDaoImpl exe addNum...");
        return Long.valueOf(num1 + num2);
    }
}
