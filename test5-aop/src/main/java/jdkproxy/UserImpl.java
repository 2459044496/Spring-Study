package jdkproxy;

public class UserImpl implements User{
    @Override
    public void say() {
        System.out.println("userimpl say.");
    }

    @Override
    public long add(int num1, int num2) {
        return num1 + num2;
    }
}
