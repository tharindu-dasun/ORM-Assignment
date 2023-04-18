package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    public void SearchReservationOnAction(ActionEvent event) {
    }

    public void SaveReservationOnAction(ActionEvent event) {
    }

    public void UpdateReservationOnAction(ActionEvent event) {
    }

    public void ClearReservationOnAction(ActionEvent event) {
    }

    public void DeleteReservationOnAction(ActionEvent event) {
    }
}
