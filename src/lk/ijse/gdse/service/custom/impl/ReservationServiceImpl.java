package lk.ijse.gdse.service.custom.impl;

import lk.ijse.gdse.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.gdse.dto.ReservationDTO;
import lk.ijse.gdse.entity.Reservation;
import lk.ijse.gdse.service.custom.ReservationService;


public class ReservationServiceImpl implements ReservationService {

    ReservationDAOImpl reservationDAO = new ReservationDAOImpl();
    public ReservationDTO search(String res_id) {
        Reservation reservation = reservationDAO.search(res_id);

        return new ReservationDTO(
                reservation.getRes_id(),
                reservation.getStudent_id(),
                reservation.getRoom_type_id(),
                reservation.getDate(),
                reservation.getStatus());
    }

    public boolean save(ReservationDTO reservationDTO) throws Exception {
        reservationDAO.save(new Reservation(
                reservationDTO.getRes_id(),
                reservationDTO.getStudent_id(),
                reservationDTO.getRoom_type_id(),
                reservationDTO.getDate(),
                reservationDTO.getStatus()
        ));

        return true;
    }

//    Reservation reservation = reservationDAO.search(phoneNumber);
//
//        return new ReservationDTO(reservation.getreservationId,student.getName(),student.getAddress(),student.getContact_no(),
//                student.getDob(),student.getGender()
//                        );
}
