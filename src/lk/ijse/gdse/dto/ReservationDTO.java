package lk.ijse.gdse.dto;

import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.entity.Student;
import lombok.*;

import java.sql.Date;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
public class ReservationDTO {
    private String res_id;
    private Student student_id;
    private Rooms room_type_id;
    private Date date;
    private String status;
}
