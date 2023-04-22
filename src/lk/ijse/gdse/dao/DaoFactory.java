package lk.ijse.gdse.dao;

import lk.ijse.gdse.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.gdse.dao.custom.impl.RoomsDAOImpl;
import lk.ijse.gdse.dao.custom.impl.StudentDAOImpl;
import lk.ijse.gdse.dao.custom.impl.UserDAOImpl;
import lk.ijse.gdse.dao.util.DaoType;

public class DaoFactory {
    private static DaoFactory daoFactory;

    public static DaoFactory getInstance() {
        return daoFactory == null ? (daoFactory = new DaoFactory()) : daoFactory;
    }

    public <T extends SuperDao> T getDao(DaoType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case ROOM:
                return (T) new RoomsDAOImpl();
            case RESERVATION:
                return (T) new ReservationDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            default: throw new RuntimeException("DAO not found");
        }
    }
}
