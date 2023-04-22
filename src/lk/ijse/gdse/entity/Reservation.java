package lk.ijse.gdse.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    private String res_id;
    @ManyToOne
    private Student student_id;
    @ManyToOne
    private Rooms room_type_id;
    private Date date;
    private String status;

//    public Reservation(String reservationId, Student student, Rooms rooms, String status) {
//        this.res_id = reservationId;
//        this.student_id = student;
//        this.room_type_id = rooms;
//        this.status = status;
//    }
}
