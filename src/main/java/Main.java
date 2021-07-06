import models.Book;
import models.User;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
//        System.out.println("Hello");
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//            System.out.printf("->_");
//            Scanner in = new Scanner(System.in);
//            String name = in.next();
//            System.out.println("Name = "+ name);
//            System.out.println("Working data base....");
            session.beginTransaction();
            Book book = new Book("Петро",2020,"Для Петра", 1);
            //Save the employee in database
            session.save(book);
            //Commit the transaction
            session.getTransaction().commit();
            session.close();
            System.out.println("Book id = "+ book.getId());

        }catch(Exception ex) {
            System.out.println("Problem! "+ex.getMessage());
        }
    }
}
