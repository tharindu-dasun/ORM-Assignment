package lk.ijse.gdse.service.custom;

import lk.ijse.gdse.dto.ReservationDTO;
import lk.ijse.gdse.service.SuperService;

public interface ReservationService extends SuperService {
    ReservationDTO search(String res_id);
    boolean save(ReservationDTO reservationDTO) throws Exception;
}
