package lk.ijse.gdse.service.custom;

import lk.ijse.gdse.dto.RoomsDTO;
import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.service.SuperService;

import java.util.List;

public interface RoomService extends SuperService {
    boolean save(RoomsDTO roomsDTO) throws Exception;
    boolean delete(String id) throws Exception;
    List<Rooms> getAll();
    RoomsDTO search(String Room_Type_Id);
    boolean update(RoomsDTO roomsDTO);
}
