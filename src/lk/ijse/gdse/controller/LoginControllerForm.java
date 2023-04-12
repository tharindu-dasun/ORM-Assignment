package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.util.Navigation;
import lk.ijse.gdse.util.Routes;

import java.io.IOException;

public class LoginControllerForm {

    public AnchorPane pane;

    public JFXButton btnSignin;
    public JFXButton btnLogin;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MAIN,pane);
    }

    public void SignInOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.NEW_USER,pane);
    }
}
