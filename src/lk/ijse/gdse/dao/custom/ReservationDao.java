package lk.ijse.gdse.dao.custom;

import lk.ijse.gdse.dao.SuperDao;
import lk.ijse.gdse.entity.Reservation;

public interface ReservationDao extends SuperDao {
    boolean save(Reservation reservation) throws Exception;
    Reservation search(String res_Id);
}
