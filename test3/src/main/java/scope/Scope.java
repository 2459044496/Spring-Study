package scope;

public class Scope {

    public Scope(){
        System.out.println("构造方法");
    }

    static {
        System.out.println("static代码块");
    }
}
