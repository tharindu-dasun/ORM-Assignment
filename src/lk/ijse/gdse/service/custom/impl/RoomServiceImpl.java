package lk.ijse.gdse.service.custom.impl;

import lk.ijse.gdse.dao.custom.impl.RoomsDAOImpl;
import lk.ijse.gdse.dto.RoomsDTO;
import lk.ijse.gdse.entity.Rooms;

import java.util.List;

public class RoomServiceImpl {

    RoomsDAOImpl  roomsDAO = new RoomsDAOImpl();

    public boolean save(RoomsDTO roomsDTO) throws Exception {
        roomsDAO.save(new Rooms(
                roomsDTO.getRoom_type_id(),
                roomsDTO.getType(),
                roomsDTO.getKey_money(),
                roomsDTO.getQty()
        ));

        return true;
    }

    public boolean delete(String id) throws Exception {
        roomsDAO.delete(id);
        return true;
    }

    public List<Rooms> getAll() {
        return roomsDAO.getAll();
    }

    public RoomsDTO search(String Room_Type_Id) {
            Rooms rooms = roomsDAO.search(Room_Type_Id);

        return new RoomsDTO(rooms.getRoom_type_id(),rooms.getType(),rooms.getKey_money(),rooms.getQty());
    }

    public boolean update(RoomsDTO roomsDTO) {
        roomsDTO.update(new Rooms(roomsDTO.getRoom_type_id(),roomsDTO.getType(),roomsDTO.getKey_money(),
                roomsDTO.getQty()
        ));
        return true;
    }

//    public boolean update(RoomsDTO roomsDTO) throws Exception {
//        roomsDTO.update(new Rooms(roomsDTO.getRoom_type_id(),roomsDTO.getType(),roomsDTO.getKey_money(),
//                roomsDTO.getQty()
//        ));
//        return true;
//    }


}
