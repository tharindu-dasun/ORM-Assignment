package lk.ijse.gdse.service.custom;

import lk.ijse.gdse.dto.UserDTO;
import lk.ijse.gdse.service.SuperService;

public interface UserService extends SuperService {
    boolean save(UserDTO userDTO) throws Exception;
    UserDTO search(String username) throws Exception;
}
