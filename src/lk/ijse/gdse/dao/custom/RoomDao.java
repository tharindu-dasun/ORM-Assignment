package lk.ijse.gdse.dao.custom;

import lk.ijse.gdse.dao.SuperDao;
import lk.ijse.gdse.entity.Rooms;

import java.util.List;

public interface RoomDao extends SuperDao {
    boolean save(Rooms rooms) throws Exception;
    boolean delete(String id)throws Exception;
    Rooms search(String Room_Type_Id);
    boolean update(Rooms rooms)throws Exception;
    List<Rooms> getAll();
}
