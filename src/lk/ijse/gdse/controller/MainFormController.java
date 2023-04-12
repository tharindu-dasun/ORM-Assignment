package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.gdse.util.Navigation;
import lk.ijse.gdse.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController {
    public AnchorPane pane;

    public AnchorPane context;



    public void btnManageStudentsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENTS,context);
    }

    public void DashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,context);
    }

    public void ManageRoomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ROOMS,context);
    }

    public void ReservationOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.RESERVATION,context);
    }

    public void logOutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }
}
