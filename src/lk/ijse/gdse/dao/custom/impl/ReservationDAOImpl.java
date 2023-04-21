package lk.ijse.gdse.dao.custom.impl;

import lk.ijse.gdse.entity.Reservation;
import lk.ijse.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationDAOImpl {
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
}
