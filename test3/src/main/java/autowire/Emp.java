package autowire;

public class Emp {

    private String eName;

    private Dept dept;

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eName='" + eName + '\'' +
                ", dept=" + dept +
                '}';
    }
}
