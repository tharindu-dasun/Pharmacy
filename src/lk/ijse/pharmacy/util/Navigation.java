package lk.ijse.pharmacy.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {
            case CUSTOMER:
                window.setTitle("Customer Manage");
                initUI("CustomerForm.fxml");
                break;

            case PLACE_ORDER:
                window.setTitle("Place Order");
                initUI("PlaceOrderForm.fxml");
                break;

            case ADD_EMPLOYEE:
                window.setTitle("EMPLOYEE FORM");
                initUI("EmployeeForm.fxml");
                break;

            case ADDCUSTOMER:
                window.setTitle("ADD CUSTOMER");
                initUI("CustomerForm.fxml");
                break;

            case SUPPLIER:
                window.setTitle("SUPPLIER FORM");
                initUI("SupplierForm.fxml");
                break;

            case SPONSOR:
                window.setTitle("SPONSOR FORM");
                initUI("SponsorForm.fxml");
                break;

            case MEDICINE:
                window.setTitle("MEDICINE FORM");
                initUI("MedicineForm.fxml");
                break;

            case ITEM:
                window.setTitle("ITEM FORM");
                initUI("ItemForm.fxml");
                break;

            case DASHBOARD:
                window.setTitle("DASHBOARD FORM");
                initUI("DashboardForm.fxml");
                break;

            case LOGIN:
                window.setTitle("LOGIN FORM");
                initUI("LoginForm.fxml");
                break;

            case ADMIN:
                window.setTitle("ADMIN FORM");
                initUI("AdminForm.fxml");
                break;

            case CASHIER:
                window.setTitle("CREATE CASHIER FORM");
                initUI("CreateCashierForm.fxml");
                break;

            case PASSWORD:
                window.setTitle("CHANGE PASSWORD FORM");
                initUI("ChangePasswordForm.fxml");
                break;

            case SUPPLIER_ORDER:
                window.setTitle("LOARD SUPPLIERTD FORM");
                initUI("SupplierTDetailForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/pharmacy/view/" + location)));
    }
}
