package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.dto.StudentDTO;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.service.custom.impl.StudentServiceImpl;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ManageStudentController implements Initializable {
    public JFXTextField txtStudentID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXButton btnSearchStudent;
    public JFXTextField txtCountact;
    public JFXTextField txtNIC;
    public JFXButton btnSaveStudent;
    public JFXButton btnUpdateStudent;
    public JFXButton btnClearStudent;
    public JFXButton btnDeleteStudent;
    public TableView tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDob;
    public TableColumn colGender;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXTextField txtRoomId;
    public TableColumn colRoomId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomQty;
    public JFXDatePicker datePickerDob;
    public JFXRadioButton radioBtnFemale;
    public JFXRadioButton radioBtnMale;
    public ToggleGroup gender;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        setValueCell();

    }

    StudentServiceImpl studentService = new StudentServiceImpl();

    public void SearchStudentOnAction(ActionEvent actionEvent) {
        StudentDTO search = studentService.search(txtStudentID.getText());
        txtStudentID.setText(search.getStudent_id());
        txtCountact.setText(search.getContact_no());

    }

    public void SaveStudentOnAction(ActionEvent actionEvent)  {
        String gender ;

        if(radioBtnMale.isSelected()){
            gender = "Male";
        }else {
            gender = "Female";
        }


        String id = txtStudentID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtCountact.getText();
        try {

        }catch (Exception e){

        }
        Date value = Date.valueOf(datePickerDob.getValue());


        try {
            boolean save = studentService.save(new StudentDTO(id,name,address,contact,value,gender));
            if (save){
                new Alert(Alert.AlertType.CONFIRMATION,"Student save success").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Student can not save").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.WARNING,"System exception happen").show();
        }

    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) {
        if (datePickerDob.getValue() == null){
            System.out.println("AAAAAA");
        }

        String gender;

        String id = txtStudentID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtCountact.getText();
        Date value = Date.valueOf(datePickerDob.getValue());
        if(radioBtnMale.isSelected()){
            gender = "Male";
        }else {
            gender = "Female";
        }


        try {
            boolean update = studentService.update(new StudentDTO(id, name, address, contact, value, gender));
            if (update){
                new Alert(Alert.AlertType.CONFIRMATION,"Student save success").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Student can not save").show();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ClearStudentOnAction(ActionEvent actionEvent) {

    }

    public void DeleteStudentOnAction(ActionEvent actionEvent) {
        try {
            boolean delete = studentService.delete(txtStudentID.getText());
            if (delete){
                new Alert(Alert.AlertType.CONFIRMATION,"student delete success").show();
            }
        } catch (Exception e) {


        }
    }

    public void getAll() throws Exception {
        List<Student> studentList = studentService.getAll();
        ObservableList<Student> stList = FXCollections.observableArrayList();

        for (Student student:studentList) {
            stList.add(new Student(
                    student.getStudent_id(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact_no(),
                    student.getDob(),
                    student.getGender()

                    ));
        }

        tblStudent.setItems(stList);
    }

    public void setValueCell(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));

    }

}
