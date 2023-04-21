package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.gdse.dto.ReservationDTO;
import lk.ijse.gdse.dto.StudentDTO;
import lk.ijse.gdse.service.custom.impl.ReservationServiceImpl;
import lk.ijse.gdse.service.custom.impl.StudentServiceImpl;

public class ReservationFormController {
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

    ReservationServiceImpl reservationService = new ReservationServiceImpl();

    public void SearchReservationOnAction(ActionEvent event) {
        ReservationDTO search = reservationService.search(txtReservationId.getText());
        txtReservationId.setText(search.getRes_id());
        txtStudentId.setText(search.getStudent_id());
        txtRoomTypeId.setText(search.getRoom_type_id());
//        datePicker.setValue(search.getDate());
        txtStatus.setText(search.getStatus());
    }

    public void ClearReservationOnAction(ActionEvent event) {
    }

    public void DeleteReservationOnAction(ActionEvent event) {
    }

    public void PlaceReservationOnAction(ActionEvent event) {
    }
}
