package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import javax.naming.Context;
import java.io.IOException;

public class DashboardFormController {


    public AnchorPane pane;
    public AnchorPane context;

    public void btnAddCusOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADDCUSTOMER,context);
    }

    public void btnAddEmpOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADD_EMPLOYEE,context);
    }

    public void btnAddSupplierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER,context);
    }

    public void btnAddSponsorOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SPONSOR,context);
    }

    public void btnAddMedicineOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MEDICINE,context);
    }

    public void btnAddItemOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ITEM,context);
    }

    public void btnLogout(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PLACE_ORDER,pane);
    }

    public void btnDashOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }
}
