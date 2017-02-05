package edmodo.modelController;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.jws.soap.SOAPBinding;

/**
 * Created by pc on 29.01.2017.
 */
public class RecordAbstact implements Recordable {

    public RecordAbstact() {

    }

    @Override
    public void addRecord(int type, User user, Item item, Bid bid) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        switch (type) {
            case 1:
                s.save(user);
                break;
            case 2:
                s.save(item);
                break;
            case 3:
                s.save(bid);
                break;
            case 4:
                s.save(user);
                s.save(item);
                s.save(bid);
        }
        s.getTransaction().commit();
        s.close();
    }

  /* @Override
    public void addRecord(User user) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.save(user);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void addRecord(Item item) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.save(item);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void addRecord(Bid bid) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.save(bid);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void removeRecord(Integer id) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        recordAbstact = (RecordAbstact) s.load(RecordAbstact.class, id);
        s.delete(recordAbstact);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updateRecord(User user) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.update(user);
        s.getTransaction().commit();
        s.close();
    }


    @Override
    public void updateRecord(Item item) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.update(item);
        s.getTransaction().commit();
        s.close();
    }*/
}
