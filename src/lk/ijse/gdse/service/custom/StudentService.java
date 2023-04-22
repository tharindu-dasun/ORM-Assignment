package lk.ijse.gdse.service.custom;

import lk.ijse.gdse.dto.StudentDTO;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.service.SuperService;

import java.util.List;

public interface StudentService  extends SuperService {
    boolean save(StudentDTO studentDTO) throws Exception;
    StudentDTO search(String phoneNumber);
    boolean update(StudentDTO studentDTO) throws  Exception ;
    boolean delete(String id) throws Exception ;
    List<Student> getAll()throws Exception ;
}
