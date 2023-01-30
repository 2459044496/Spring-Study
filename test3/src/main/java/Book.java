public class Book {

    private String bName;

    public void setbName(String bName) {
        this.bName = bName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bName='" + bName + '\'' +
                '}';
    }
}
