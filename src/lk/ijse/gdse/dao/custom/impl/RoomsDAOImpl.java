package lk.ijse.gdse.dao.custom.impl;

import lk.ijse.gdse.dao.custom.RoomDao;
import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomsDAOImpl implements RoomDao {
    public boolean save(Rooms rooms) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(rooms);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(String id)throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Rooms rooms = session.get(Rooms.class, id);
        session.delete(rooms);

        transaction.commit();
        session.close();
        return true;
    }

    public Rooms search(String Room_Type_Id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Rooms rooms = session.get(Rooms.class, Room_Type_Id);

        transaction.commit();
        session.close();
        return rooms;
    }

//    public boolean update(Rooms rooms)throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.update(rooms);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }

    public boolean update(Rooms rooms)throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(rooms);

        transaction.commit();
        session.close();
        return true;
    }

    public List<Rooms> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from Rooms";
        Query query = session.createQuery(hql);
        List <Rooms> roomList = query.list();

        transaction.commit();
        session.close();
        return roomList;
    }
}
