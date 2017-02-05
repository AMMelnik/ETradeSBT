package edmodo.modelController;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by pc on 31.01.2017.
 */
public class BidRec extends RecordAbstact {

    public List<Bid> checkItemBuyerByItemId(Integer itemId) {
        System.out.println("\nЧтение записей таблицы Bid");
        String q = "SELECT b.user FROM Bid b WHERE b.item = :itemId";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q).setParameter("itemId", itemId);

        List<Bid> bids = query.list();
        s.close();

        if (bids.size() > 0) {
            return bids;
        } else return null;
    }

  /*  public void buyItem(User user, Item item) {
        System.out.println("\nЗапись в таблицу Bid");
        String q = "SELECT b FROM Bid b WHERE b.item = :itemId";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q).setParameter("itemId", itemId);

        List<Bid> bids = query.list();
        s.close();

        if (bids.size() > 0) {
            return bids;
        } else return null;
    }*/
}
