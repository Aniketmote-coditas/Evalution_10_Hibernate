import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
@Entity
public class Publication {
    @Id
    private int pid;

    private String pname;

    private Date date;
    @OneToOne
    private Book book;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", date=" + date +
                ", book=" + book +
                '}';
    }
}
