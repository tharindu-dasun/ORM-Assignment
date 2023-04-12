package lk.ijse.gdse.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("LOGIN FORM");
                initUI("LoginForm.fxml");
                break;

            case NEW_USER:
                window.setTitle("SIGNIN FORM");
                initUI("SignInForm.fxml");
                break;

            case MAIN:
                window.setTitle("MAIN FORM");
                initUI("MainForm.fxml");
                break;

            case DASHBOARD:
                window.setTitle("DASH BOARD FORM");
                initUI("DashBoardForm.fxml");
                break;

            case STUDENTS:
                window.setTitle("MANAGE STUDENT FORM");
                initUI("ManageStudent.fxml");
                break;

            case ROOMS:
                window.setTitle("MANAGE ROOMS FORM");
                initUI("ManageRoomForm.fxml");
                break;

            case RESERVATION:
                window.setTitle("RESERVATION FORM");
                initUI("ReservationForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/gdse/view/" + location)));
    }
}

