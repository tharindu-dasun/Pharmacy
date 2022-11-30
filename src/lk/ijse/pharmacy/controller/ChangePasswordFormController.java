package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;

public class ChangePasswordFormController {
    public JFXButton btnSignin;
    public JFXRadioButton radioAdmin;
    public JFXRadioButton radioCashier;
    public JFXButton btnCreateCashier;
    public JFXButton btnPassword;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXButton btnSavePassword;
    public JFXButton btnCancelPassword;
    public AnchorPane PasswordPane;

    public void LoginOnAction(ActionEvent actionEvent) {
    }

    public void AdminOnAction(ActionEvent actionEvent) {
    }

    public void CashierOnAction(ActionEvent actionEvent) {
    }

    public void btnSavePasswordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN,PasswordPane);
    }

    public void btnCancelPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN,PasswordPane);
    }
}
