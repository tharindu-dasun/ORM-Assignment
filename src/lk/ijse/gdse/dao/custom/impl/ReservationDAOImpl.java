package lk.ijse.gdse.dao.custom.impl;

import lk.ijse.gdse.dao.custom.ReservationDao;
import lk.ijse.gdse.entity.Reservation;
import lk.ijse.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationDAOImpl implements ReservationDao {
    public ReservationDAOImpl() {
    }

    public boolean save(Reservation reservation) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(reservation);
        transaction.commit();
        session.close();
        return true;
    }

    public Reservation search(String res_Id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Reservation reservation = session.get(Reservation.class, res_Id);

        transaction.commit();
        session.close();
        return reservation;
    }
}
