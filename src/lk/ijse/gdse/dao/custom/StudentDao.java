package lk.ijse.gdse.dao.custom;

import lk.ijse.gdse.dao.SuperDao;
import lk.ijse.gdse.entity.Student;

import java.util.List;

public interface StudentDao  extends SuperDao {
    boolean save(Student student)throws Exception;
    Student search(String phoneNumber);
    boolean update(Student student)throws Exception;
    boolean delete(String id)throws Exception;
    List<Student> getAll()throws Exception;
}
