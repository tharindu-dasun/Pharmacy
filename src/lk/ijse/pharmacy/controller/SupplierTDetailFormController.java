package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.model.SupplierModel;
import lk.ijse.pharmacy.to.Supplier;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class SupplierTDetailFormController {
    public AnchorPane Pane;
    public JFXButton btnBack;

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
       Navigation.navigate(Routes.DASHBOARD,Pane);
    }
}
