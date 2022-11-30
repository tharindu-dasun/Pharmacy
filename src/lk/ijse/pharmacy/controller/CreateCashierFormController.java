package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;

public class CreateCashierFormController {
    public AnchorPane CashierPane;
    public JFXButton btnSignin;
    public JFXRadioButton radioAdmin;
    public JFXRadioButton radioCashier;
    public JFXButton btnCreateCashier;
    public JFXButton btnPassword;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXButton btnSaveCashier;
    public JFXButton btnCancelcashier;

    public void LoginOnAction(ActionEvent actionEvent) {
    }

    public void AdminOnAction(ActionEvent actionEvent) {
    }

    public void CashierOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveCashierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN,CashierPane);
    }

    public void btnCancelCashierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN,CashierPane);
    }
}
