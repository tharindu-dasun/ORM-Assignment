package lk.ijse.gdse.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor

public class RoomsDTO {

    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;

}
