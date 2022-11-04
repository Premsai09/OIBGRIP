import java.util.Iterator;
import java.util.Map;

public class Student extends lib{
    private int S_id;
    private String Student_name;
    private String name;
    private book_details book_carrying;

    public Student(int s_id, String name, book_details book_carrying) {
        S_id = s_id;
        this.name = name;
        this.book_carrying = book_carrying;
    }

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public book_details getBook_carrying() {
        return book_carrying;
    }

    public void setBook_carrying(book_details book_carrying) {
        this.book_carrying = book_carrying;
    }
    public void register_student(int S_id,String name){

    }
    public void get_book(int book_id){

    }
}
