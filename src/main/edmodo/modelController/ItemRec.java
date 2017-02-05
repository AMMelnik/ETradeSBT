package edmodo.modelController;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 30.01.2017.
 */
public class ItemRec extends RecordAbstact {

    public ItemRec() {
        super();
    }

    public List<Item> search(String itemSearch, Integer userId) {
        System.out.println("\nЧтение записей таблицы item и bid в поиске некупленных товаров, которые выставил другой юзер");

        String q = "SELECT i FROM Bid as b RIGHT JOIN b.item as i where" +
                "(i.name LIKE :itemSearch OR i.description LIKE :itemSearch) " +
                "AND i.user.id != :userId AND b.item is null";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q).setParameter("itemSearch", "%" + itemSearch + "%")
                .setParameter("itemSearch", "%" + itemSearch + "%").setParameter("userId", userId);

        List<Item> items = query.list();
        s.close();

        if (items.size() > 0) {
            return items;
        } else return null;
    }

    public List<Item> showMyItems(Integer userId) {
        System.out.println("\n Чтение записей таблицы item и bid в поиске купленных юзером товаров");

        String q = "SELECT i FROM Bid as b JOIN b.item as i where b.user.id = :userId";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q).setParameter("userId", userId);

        List<Item> items = query.list();
        s.close();

        if (items.size() > 0) {
            return items;
        } else return null;
    }
}
