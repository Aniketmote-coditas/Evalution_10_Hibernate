import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice ;

        do{
            System.out.println("1. Insert ");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Query1");
            System.out.println("6. Query2");
            System.out.println("7. Query3");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice) {
                case 1:
                    Dao.insert();
                    // Code for option 1
                    break;
                case 2:
                    Dao.update();
                    break;
                case 3:
                    Dao.delete();
                    break;
                case 4:
                    Dao.display();
                    break;
                case 5:
                    Dao.q1();
                    break;
                case 6:
                    Dao.q2();
                    break;
                case 7:
                    Dao.q3();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();

        }while(choice!=0);
    }
}

/*
1. Insert
2. Update
3. Delete
4. Display
5. Query1
6. Query2
7. Query3
0. Exit
Enter your choice: 1
Apr 21, 2023 3:51:37 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.5.Final
Apr 21, 2023 3:51:39 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
Apr 21, 2023 3:51:39 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Apr 21, 2023 3:51:39 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.cj.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/Book_System?createDatabaseIfNotExist=true]
Apr 21, 2023 3:51:39 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=root, password=****}
Apr 21, 2023 3:51:39 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Apr 21, 2023 3:51:39 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Apr 21, 2023 3:51:40 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
Apr 21, 2023 3:51:42 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@2098d37d] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: alter table Author_Book add constraint FKkbdejfbcvvae1tb1vcd7ymkcf foreign key (book_bid) references Book (bid)
Hibernate: alter table Author_Book add constraint FKetec6th96t2yblaw1a1xg6jc2 foreign key (Author_aid) references Author (aid)
Hibernate: alter table Book add constraint FK5gbo4o7yxefxivwuqjichc67t foreign key (author_id) references Author (aid)
Hibernate: alter table Book add constraint FKrlr070xgoeyil0jqu1013by6a foreign key (publisher_id) references Publication (pid)
Hibernate: alter table Publication add constraint FKabcs4sre9hkukj862buoifv6e foreign key (book_bid) references Book (bid)
Insert Author Details
Enter Author Name
Yash
How many book you want to inser
1
Enter the name of the book
JAVATECH
Enter the price of the book
499
Enter the publication of your Book
Nirali
Enter the publication year of your Book
2021-01-01
Hibernate: insert into Author (aname) values (?)
Hibernate: select publicatio_.pid, publicatio_.book_bid as book_bid4_3_, publicatio_.date as date2_3_, publicatio_.pname as pname3_3_ from Publication publicatio_ where publicatio_.pid=?
Hibernate: insert into Book (author_id, bname, bprice, publisher_id) values (?, ?, ?, ?)
Hibernate: update Publication set book_bid=?, date=?, pname=? where pid=?
Hibernate: insert into Author_Book (Author_aid, book_bid) values (?, ?)

1. Insert
2. Update
3. Delete
4. Display
5. Query1
6. Query2
7. Query3
0. Exit
Enter your choice: 2
Select whoes data you want to update
press 1 for Author/npress 2 for Books/npress 3 for publication/npress 0 for exit
1
Enter the id of Author
6
Enter the new name of Author
AniketMote
Hibernate: select author0_.aid as aid1_0_0_, author0_.aname as aname2_0_0_ from Author author0_ where author0_.aid=?
Hibernate: update Author set aname=? where aid=?

1. Insert
2. Update
3. Delete
4. Display
5. Query1
6. Query2
7. Query3
0. Exit
Enter your choice: 3
Select from the  below options whos data you want to delete
press 1 for Author/npress 2 for Books/npress3 for Publication
4

1. Insert
2. Update
3. Delete
4. Display
5. Query1
6. Query2
7. Query3
0. Exit
Enter your choice: 4
Select from the  below options whos data you want to see
press 1 for Author   press 2 for Books   press3 for Publication
1
Hibernate: select author0_.aid as aid1_0_, author0_.aname as aname2_0_ from Author author0_
Author ID: 1
Author Name: yash
--------------------------------------
Author ID: 2
Author Name: Ani
--------------------------------------
Author ID: 3
Author Name: akash
--------------------------------------
Author ID: 4
Author Name: tanmayA
--------------------------------------
Author ID: 7
Author Name: xxxxx
--------------------------------------
Author ID: 6
Author Name: AniketMote
--------------------------------------
Author ID: 8
Author Name: Aniketi
--------------------------------------
Author ID: 9
Author Name: Aaaaaaaiiiiii
--------------------------------------
Author ID: 10
Author Name: ANNNNNNNNNIIIIIIiiiii
--------------------------------------
Author ID: 11
Author Name: Aaaaii
--------------------------------------
Author ID: 12
Author Name: aaiii
--------------------------------------
Author ID: 13
Author Name: Aiii
--------------------------------------
Author ID: 14
Author Name: Yash
--------------------------------------

1. Insert
2. Update
3. Delete
4. Display
5. Query1
6. Query2
7. Query3
0. Exit
Enter your choice: 7
Hibernate: select book0_.bid as bid1_2_, book0_.author_id as author_i4_2_, book0_.bname as bname2_2_, book0_.bprice as bprice3_2_, book0_.publisher_id as publishe5_2_ from Book book0_ inner join Author author1_ on book0_.author_id=author1_.aid where author1_.aname like 'A%i'
Hibernate: select author0_.aid as aid1_0_0_, author0_.aname as aname2_0_0_ from Author author0_ where author0_.aid=?
Hibernate: select publicatio0_.pid as pid1_3_0_, publicatio0_.book_bid as book_bid4_3_0_, publicatio0_.date as date2_3_0_, publicatio0_.pname as pname3_3_0_, book1_.bid as bid1_2_1_, book1_.author_id as author_i4_2_1_, book1_.bname as bname2_2_1_, book1_.bprice as bprice3_2_1_, book1_.publisher_id as publishe5_2_1_, author2_.aid as aid1_0_2_, author2_.aname as aname2_0_2_, publicatio3_.pid as pid1_3_3_, publicatio3_.book_bid as book_bid4_3_3_, publicatio3_.date as date2_3_3_, publicatio3_.pname as pname3_3_3_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_bid=book1_.bid left outer join Author author2_ on book1_.author_id=author2_.aid left outer join Publication publicatio3_ on book1_.publisher_id=publicatio3_.pid where publicatio0_.pid=?
Hibernate: select author0_.aid as aid1_0_0_, author0_.aname as aname2_0_0_ from Author author0_ where author0_.aid=?
Hibernate: select author0_.aid as aid1_0_0_, author0_.aname as aname2_0_0_ from Author author0_ where author0_.aid=?
ramayan  Ani
Anikettti  Aniketi
Niii  Aiii

1. Insert
2. Update
3. Delete
4. Display
5. Query1
6. Query2
7. Query3
0. Exit
Enter your choice: 6
Hibernate: select publicatio0_.pid as pid1_3_, publicatio0_.book_bid as book_bid4_3_, publicatio0_.date as date2_3_, publicatio0_.pname as pname3_3_ from Publication publicatio0_ where publicatio0_.pname='Nirali'
Hibernate: select book0_.bid as bid1_2_0_, book0_.author_id as author_i4_2_0_, book0_.bname as bname2_2_0_, book0_.bprice as bprice3_2_0_, book0_.publisher_id as publishe5_2_0_, author1_.aid as aid1_0_1_, author1_.aname as aname2_0_1_, publicatio2_.pid as pid1_3_2_, publicatio2_.book_bid as book_bid4_3_2_, publicatio2_.date as date2_3_2_, publicatio2_.pname as pname3_3_2_, book3_.bid as bid1_2_3_, book3_.author_id as author_i4_2_3_, book3_.bname as bname2_2_3_, book3_.bprice as bprice3_2_3_, book3_.publisher_id as publishe5_2_3_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.aid left outer join Publication publicatio2_ on book0_.publisher_id=publicatio2_.pid left outer join Book book3_ on publicatio2_.book_bid=book3_.bid where book0_.bid=?

1. Insert
2. Update
3. Delete
4. Display
5. Query1
6. Query2
7. Query3
0. Exit

 */