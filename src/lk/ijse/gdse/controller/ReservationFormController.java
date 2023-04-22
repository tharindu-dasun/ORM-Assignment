package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lk.ijse.gdse.dto.ReservationDTO;
import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.service.ServiceFactory;
import lk.ijse.gdse.service.custom.RoomService;
import lk.ijse.gdse.service.custom.StudentService;
import lk.ijse.gdse.service.custom.impl.ReservationServiceImpl;
import lk.ijse.gdse.service.util.ServiceType;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {
    public JFXTextField txtReservationId;
    public JFXTextField txtStudentId;
    public JFXButton btnSearchReservation;
    public JFXTextField txtQty;
    public JFXButton btnSaveReservation;
    public JFXButton btnUpdateReservation;
    public JFXButton btnClearReservation;
    public JFXButton btnDeleteReservation;
    public TableView tblReservation;
    public TableColumn colReservationId;
    public TableColumn colStudentId;
    public TableColumn colRoomTypeIdRes;
    public TableColumn colDate;
    public TableColumn colQty;
    public JFXTextField txtStatus;
    public TableColumn colStatus;
    public JFXTextField txtRoomTypeId;
    public JFXDatePicker txtDate;
    public JFXButton btnPlaceReservation;
    public JFXDatePicker datePicker;
    public ComboBox<String> cmbStudentId;
    public RadioButton rbtnPaid;
    public ToggleGroup payment;
    public ComboBox<String> cmbRoomId;

    ReservationServiceImpl reservationService = ServiceFactory.getInstance().getService(ServiceType.RESERVATION);

    public void SearchReservationOnAction(ActionEvent event) {
        ReservationDTO search = reservationService.search(txtReservationId.getText());
        txtReservationId.setText(search.getRes_id());
        txtStudentId.setText(String.valueOf(search.getStudent_id()));
        txtRoomTypeId.setText(String.valueOf(search.getRoom_type_id()));
//        datePicker.setValue(search.getDate());
        txtStatus.setText(search.getStatus());
    }

    public void ClearReservationOnAction(ActionEvent event) {
    }

    public void DeleteReservationOnAction(ActionEvent event) {
    }

    public void PlaceReservationOnAction(ActionEvent event) {

        try {
            //create reservation
            ReservationDTO reservationDTO = new ReservationDTO();
//            reservationDTO.



            //add student to reservation

            //add room  to reservation

            //booloan flag = reservationService.save( );

            if (true) {
                new Alert(Alert.AlertType.CONFIRMATION, "Reservation Complete").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Can't Place Reservation").show();
            }
        } catch (Exception e) {
//            System.out.println(e);
            new Alert(Alert.AlertType.WARNING, "System exception happen").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            loadStudentsList();
            loadRoomList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    RoomService roomService = ServiceFactory.getInstance().getService(ServiceType.ROOM);

    private void loadRoomList() {
        List<Rooms> all = roomService.getAll();
        ObservableList<String> roomIdList = FXCollections.observableArrayList();
        all.forEach(room -> roomIdList.add(room.getRoom_type_id()));
        cmbRoomId.setItems(roomIdList);
    }

    StudentService studentService = ServiceFactory.getInstance().getService(ServiceType.STUDENT);

    private void loadStudentsList() throws Exception {
        List<Student> all = studentService.getAll();
        ObservableList<String> idList = FXCollections.observableArrayList();
        all.forEach(student -> idList.add(student.getStudent_id()));
        cmbStudentId.setItems(idList);
    }
}
