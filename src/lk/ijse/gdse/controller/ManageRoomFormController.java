package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.dto.RoomsDTO;
import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.service.custom.impl.RoomServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManageRoomFormController implements Initializable {
    public JFXTextField txtRoomId;
    public JFXTextField txtType;
    public JFXButton btnSearchRoom;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXButton btnSaveRoom;
    public JFXButton btnUpdateRoom;
    public JFXButton btnClearRoom;
    public JFXButton btnDeleteRoom;
    public TableView<Rooms> tblRooms;
    public TableColumn colRoomId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomQty;


    RoomServiceImpl roomService = new RoomServiceImpl();
    public void SearchRoomOnAction(ActionEvent event) {
        RoomsDTO search = roomService.search(txtRoomId.getText());
        txtRoomId.setText(search.getRoom_type_id());
        txtType.setText(search.getType());
//        txtKeyMoney.setText(search.getKey_money());
//        txtRoomQty.setText(search.getQty());

    }

    public void SaveRoomOnAction(ActionEvent event) throws Exception {

        String room_type_id = txtRoomId.getText();
        String room_type = txtType.getText();
        int key_money = Integer.parseInt(txtKeyMoney.getText());
        int quantity = Integer.parseInt(txtRoomQty.getText());
        try {

        }catch (Exception e){

        }

        try {
            boolean save = roomService.save(new RoomsDTO(room_type_id,room_type,key_money,quantity));
            if (save){
                new Alert(Alert.AlertType.CONFIRMATION,"Room save success").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Room can not save").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.WARNING,"System exception happen").show();
        }
        getAll();
       //setValueCell();
    }

    public void UpdateRoomOnAction(ActionEvent event) {

    }

    public void DeleteRoomOnAction(ActionEvent event) {
        try {
            boolean delete = roomService.delete(txtRoomId.getText());
            if (delete){
                new Alert(Alert.AlertType.CONFIRMATION,"Room delete success").show();
            }
        } catch (Exception e) {

        }
    }

    public void ClearRoomOnAction(ActionEvent event) {
    }

    public void getAll() throws Exception {
        List<Rooms> roomsList = roomService.getAll();
        ObservableList<Rooms> stList = FXCollections.observableArrayList();

        for (Rooms rooms:roomsList) {
            stList.add(new Rooms(
                    rooms.getRoom_type_id(),
                    rooms.getType(),
                    rooms.getKey_money(),
                    rooms.getQty()
            ));
        }

        tblRooms.setItems(stList);
    }

    public void setValueCell(){
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAll();
            setValueCell();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
