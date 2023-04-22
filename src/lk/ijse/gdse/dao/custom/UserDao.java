package lk.ijse.gdse.dao.custom;

import lk.ijse.gdse.dao.SuperDao;
import lk.ijse.gdse.entity.User;

public interface UserDao   extends SuperDao {
    boolean save(User user)throws Exception;
    User search(String userName);
}
