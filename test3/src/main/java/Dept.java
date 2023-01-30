import java.util.List;

// 抽取公共list示例的实体类,其他集合类型同
public class Dept {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "list=" + list +
                '}';
    }
}
