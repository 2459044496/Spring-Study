package cn.cuiper.spring;

// 职工
public class Emp {

    private String eName;

    private String eAge;

    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void seteAge(String eAge) {
        this.eAge = eAge;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eName='" + eName + '\'' +
                ", eAge='" + eAge + '\'' +
                ", dept=" + dept +
                '}';
    }
}
