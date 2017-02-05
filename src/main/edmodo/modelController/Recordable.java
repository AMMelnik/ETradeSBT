package com.edmodo.modelController;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import org.hibernate.Transaction;

/**
 * Created by pc on 29.01.2017.
 */
public interface Recordable {
/*    void addRecord(User user);

    void addRecord(Item item);

    void addRecord(Bid bid);*/

    void addRecord(int type, User user, Item item, Bid bid);

    //   void removeRecord(Integer id);

    //   void updateRecord(User user);

    //   void updateRecord(Item item);
}
