package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.util.regex.Pattern;

public class LoginFormController {
    public JFXRadioButton radioAdmin;
    public JFXRadioButton radioCashier;
    public JFXButton btnSignin;
    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    public void AdminOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN, pane);
    }

    public void CashierOnAction(ActionEvent actionEvent) {
    }

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);

    }
}
