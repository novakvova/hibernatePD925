import models.User;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

public class Main {
    public static void main(String [] args) {
//        System.out.println("Hello");
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//            System.out.println("Working data base....");
            session.beginTransaction();

            //Add new Employee object
            User user = new User();
            user.setName("ivan");

            //Save the employee in database
            session.save(user);
            //Commit the transaction
            session.getTransaction().commit();
            session.close();
            System.out.println("User id = "+ user.getId());

        }catch(Exception ex) {
            System.out.println("Problem! "+ex.getMessage());
        }
    }
}
