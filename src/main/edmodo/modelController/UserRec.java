package edmodo.modelController;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


/**
 * Created by pc on 29.01.2017.
 */
public class UserRec extends RecordAbstact {

    public UserRec() {

    }

    public int checkEmail(String emailToCheck) {
        System.out.println("\nЧтение записей таблицы User");
        String q = "SELECT u FROM User u WHERE u.email = :emailToCheck";
        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q).setParameter("emailToCheck", emailToCheck);

        List<User> users = query.list();
        s.close();

        return users.size();
    }

    public User checkAccount(String emailToCheck, String passToCheck) {
        System.out.println("\nЧтение записей таблицы User");
        String q = "SELECT u FROM User u WHERE u.password = :passToCheck and u.email =:emailToCheck";
        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q).setParameter("passToCheck", passToCheck).setParameter("emailToCheck", emailToCheck);

        List<User> users = query.list();
        s.close();

        if (users.size() == 1) {
            return users.get(0);
        } else return null;
    }
}
