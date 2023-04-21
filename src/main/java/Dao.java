import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

public class Dao {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();
    public static void insert() throws IOException {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("Insert Author Details");
        System.out.println("Enter Author Name");
        String aname = bufferedReader.readLine();

        Author author = new Author();
        author.setAname(aname);
        List<Book> list = new ArrayList<>();
        System.out.println("How many book you want to inser");
        int numberOfBooks = Integer.parseInt(bufferedReader.readLine());



        while (numberOfBooks-->0){
            System.out.println("Enter the name of the book");
            String bookname = bufferedReader.readLine();
            System.out.println("Enter the price of the book");
            int bookprice = Integer.parseInt(bufferedReader.readLine());
            Book book = new Book();
            book.setBname(bookname);
            book.setBprice(bookprice);
            book.setAuthor(author);


            System.out.println("Enter the publication of your Book");
            String publ = bufferedReader.readLine();
            System.out.println("Enter the publication year of your Book");
           // String pubyear = bufferedReader.readLine();


            Date date = Date.valueOf(bufferedReader.readLine());

            Publication publication = new Publication();
            publication.setPname(publ);
            publication.setBook(book);
            publication.setDate(date);
            book.setPublication(publication);




            list.add(book);

            author.setBook(list);


            session.save(author);
            session.save(book);
            session.save(publication);

        }


        transaction.commit();
        session.close();
    }

    public static void update() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Select whoes data you want to update");
        System.out.println("press 1 for Author/npress 2 for Books/npress 3 for publication/npress 0 for exit");

        int id = Integer.parseInt(bufferedReader.readLine());

        if(id==1){
            System.out.println("Enter the id of Author");
            int n = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter the new name of Author");
            String name = bufferedReader.readLine();

            Author author =session.get(Author.class,n);
            author.setAname(name);

            session.saveOrUpdate(author);
            transaction.commit();
            session.close();
        }else if(id==2){
            System.out.println("Enter the id of Book");
            int n = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter the new name of Book");
            String name = bufferedReader.readLine();
            Book book = session.get(Book.class,n);

            book.setBname(name);

            session.saveOrUpdate(book);
            transaction.commit();
            session.close();
        }else if(id==3){
            System.out.println("Enter the id of publisher");
            int n = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter the new name of publisher");
            String name = bufferedReader.readLine();

            Publication publication = session.get(Publication.class,n);
            publication.setPname(name);

            session.saveOrUpdate(publication);
            transaction.commit();
            session.close();
        }

    }

    public static void delete() throws IOException {

        System.out.println("Select from the  below options whos data you want to delete");
        System.out.println("press 1 for Author/npress 2 for Books/npress3 for Publication");
        int n = Integer.parseInt(bufferedReader.readLine());



        if(n==1){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            System.out.println("Enter the id to be deleted");
            int id = Integer.parseInt(bufferedReader.readLine());

            Author author = session.get(Author.class,id);

            session.delete(author);

            transaction.commit();

            session.close();
        }else if(n==2){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            System.out.println("Enter the id to be deleted");
            int id = Integer.parseInt(bufferedReader.readLine());

            Book b = session.get(Book.class,id);

            session.delete(b);

            transaction.commit();

            session.close();
        }else if(n==3){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            System.out.println("Enter the id to be deleted");
            int id = Integer.parseInt(bufferedReader.readLine());

            Publication p = session.get(Publication.class,id);

            session.delete(p);

            transaction.commit();

            session.close();
        }

    }

    public static void display() throws IOException {
        System.out.println("Select from the  below options whos data you want to see");
        System.out.println("press 1 for Author   press 2 for Books   press3 for Publication");
        int n = Integer.parseInt(bufferedReader.readLine());

        if(n==1){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            List<Author> authors = session.createQuery("FROM Author", Author.class).list();

            for (Author author : authors) {
                System.out.println("Author ID: " + author.getAid());
                System.out.println("Author Name: " + author.getAname());
                System.out.println("--------------------------------------");
            }

        }else if(n==2){

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            List<Book> books = session.createQuery("FROM Book", Book.class).list();

            for (Book author : books) {
                System.out.println("Author ID: " + author.getBid());
                System.out.println("Author Name: " + author.getBname());
                System.out.println("--------------------------------------");
            }


        }else if(n==3){

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            List<Publication> books = session.createQuery("FROM Publication", Publication.class).list();

            for (Publication author : books) {
                System.out.println("Author ID: " + author.getPid());
                System.out.println("Author Name: " + author.getPname());
                System.out.println("--------------------------------------");
            }

        }
    }
    public static void q1() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        LocalDate userDate = LocalDate.parse("2021-01-01");


        List<Author> authors = session.createQuery("SELECT DISTINCT p.author FROM Publication p WHERE p.date < :userDate")
                .setParameter("userDate", userDate)
                .getResultList();

        for (Author author:authors) {
            System.out.println("--------------------------------------");
            System.out.println("Author name ::"+ author.getAname());
            System.out.println("--------------------------------------");
        }

        transaction.commit();
        session.close();

    }
    public static void q2() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        //List<Book> b = (List<Book>) session.createNativeQuery("select b.bname from Book b join Publication p on b.bid=p.book_bid where p.pname='Nirali' and b.bprice>=500");

       // List<Book> book = session.createQuery("SELECT b.bname FROM Book b JOIN b.Publication p WHERE p.pname = 'Nirali' AND b.bprice >= 500").getResultList();
       // List<Book> books1 = session.createNativeQuery("SELECT b.bname FROM book b JOIN publication p ON b.bid = p.book_id WHERE p.pname = 'Nirali' AND b.bprice >= 500", Book.class).getResultList();
        //List<Book> books = session.createNativeQuery("SELECT * FROM p JOIN publication p ON b.publisher_id = p.pid WHERE p.pname = 'Nirali' AND b.bprice >= 500", Book.class).getResultList();
        List<Publication> publicationList1 = session.createQuery("from Publication where pname='Nirali'").getResultList();
//        for (Book author:books) {
//            System.out.println("--------------------------------------");
//            System.out.println("Author name ::"+author.getBname());
//            System.out.println("Author pub   ::"+author.getPublication());
//            System.out.println("--------------------------------------");
//        }
        for(Publication publication:publicationList1){
            if(publication.getBook().getBprice()>=500){
                System.out.println(publication.getBook().getBname());
            }
        }

        transaction.commit();
        session.close();

    }
    public static void q3() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //LocalDate userDate = LocalDate.parse("2021-01-01");

        //List<Book> books = session.createNativeQuery("SELECT b.bname FROM book b JOIN author a on a.aid=b.author_id WHERE a.aname LIKE 'A%I'",Book.class).getResultList();
        /*List<Book> books = session.createNativeQuery("SELECT b.bname FROM book b JOIN author a on a.aid=b.author_id WHERE a.aname LIKE 'A%I'",Book.class).getResultList();


        for (Book author:books) {
            System.out.println("--------------------------------------");
            System.out.println("Author name ::"+ author.getBname());
            System.out.println("--------------------------------------");
        }

        transaction.commit();
        session.close();*/
        Query query = session.createQuery("SELECT b FROM Book b JOIN b.author a WHERE a.aname LIKE 'A%i'", Book.class);

// Execute the query and get the result list
        List<Book> books = query.getResultList();

// Print the books
        for (Book book : books) {
            System.out.println(book.getBname()+"  "+ book.getAuthor().getAname());
        }

        transaction.commit();
        session.close();

    }
}