package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;

public class AdminFormController {
    public AnchorPane pane;
    public JFXButton btnSignin;
    public JFXRadioButton radioAdmin;
    public JFXRadioButton radioCashier;
    public JFXButton btnCreateCashier;
    public JFXButton btnPassword;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }

    public void AdminOnAction(ActionEvent actionEvent) {
    }

    public void CashierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void CreateCasherOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CASHIER,pane);
    }

    public void changepasswordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PASSWORD,pane);
    }
}
