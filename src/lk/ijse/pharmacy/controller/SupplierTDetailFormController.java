package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.model.*;
import lk.ijse.pharmacy.to.*;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class SupplierTDetailFormController {
    public AnchorPane Pane;
    public JFXButton btnBack;
    public Label txtOrderId;
    public TableView tblOrderCart;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQtyOnHand;
    public TableColumn colOrderQty;
    public TableColumn colAmount;
    public Label lblComName;
    public Label lblAgreement;
    public JFXComboBox cmbCode;
    public Label lblDescription;
    public Label lblUnitPrice;
    public Label lblQtyOnHand;
    public Label lblSupplierName;
    public JFXTextField txtSupId;
    public TextField txtQty;
    public JFXComboBox cmbCashId;
    public Label lblCashierName;
    public Label lblMDate;
    public Label lblExDate;
    public Label lblAddress;
    public Label lblNo;
    public Label lblNic;
    public Label lblRole;
    public JFXTextField txtTotalAmount;
    private String employee_id;

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {

    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
       Navigation.navigate(Routes.DASHBOARD,Pane);
    }

//    public void cmbItemOnAction(ActionEvent actionEvent) {
//    }

    public void txtQtyOnAction(ActionEvent actionEvent) {

    }

    public void cmbCashOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Object value = cmbCashId.getValue();
        if (value != null) {
            String cashId = value.toString();
            String e = cashId.split("")[0];
            if (e.equals("C")) {
                Employee employeeDetails = SupOrderModel.searchEmp(cashId);
                lblCashierName.setText(employeeDetails.getName());
                lblAddress.setText(employeeDetails.getAddress());
                lblRole.setText(employeeDetails.getRole());
                lblNic.setText(employeeDetails.getNic());
                lblNo.setText(Integer.toString(employeeDetails.getContact_no()));
            }else {
                ClearEmpData();
            }
        }
    }

    private void ClearEmpData() {
//        lblCashierName.setText("");
//        lblAddress.setText("");
//        lblNo.setText("");
//        lblNic.setText("");
//        lblRole.setText("");
//        cmbCashId.setValue(null);
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        loadItemCode();
        loadEmpList();
        //loadSpnList();
        txtOrderId.setText(SupOrderModel.getNewOrderID());

        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
//        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("QtyOnHand"));
        colOrderQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
    }

    private void loadItemCode() throws SQLException, ClassNotFoundException {

        ArrayList<String> itemIdList = SupOrderModel.getItemList();

        ObservableList observableList = FXCollections.observableArrayList();
        for (String s : itemIdList) {
            observableList.add(s);
            cmbCode.setItems(observableList);
        }
    }

    public void loadEmpList() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> itemIdList = EmployeeModel.getList();

        ObservableList observableList = FXCollections.observableArrayList();
        for (Employee s : itemIdList) {
            observableList.add(s.getEmployee_id());
            cmbCashId.setItems(observableList);
        }
    }

    public void cmbItemOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Object value = cmbCode.getValue();
        if (value != null) {
            String itemId = value.toString();
            String s = itemId.split("")[0];
            if (s.equals("I")) {
                Item itemDetails = SupOrderModel.search(itemId);
                lblDescription.setText(itemDetails.getDescription());
                lblUnitPrice.setText(Integer.toString(itemDetails.getUnit_price()));
                lblQtyOnHand.setText(Integer.toString(itemDetails.getQuantity()));
                lblMDate.setText(itemDetails.getM_Date());
                lblExDate.setText(itemDetails.getEx_Date());
            }
            if (s.equals("M")) {
                Medicines medicinesDetails = MedicineModel.search(itemId);
                lblDescription.setText(medicinesDetails.getName());
                lblUnitPrice.setText(Integer.toString(medicinesDetails.getUnit_price()));
                lblQtyOnHand.setText(Integer.toString(medicinesDetails.getQuantity()));
                lblMDate.setText(medicinesDetails.getM_Date());
                lblExDate.setText(medicinesDetails.getEx_Date());
            }
        }else {
            ClearItemData();
        }
    }

    private void ClearItemData() {
        txtQty.setText("");
        lblDescription.setText("");
        lblQtyOnHand.setText("");
        lblUnitPrice.setText("");
        cmbCode.setValue(null);
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String supplier_id = txtSupId.getText();
        try {
            Supplier supplier = SupplierModel.search(supplier_id);
            if (supplier != null) {
                lblSupplierName.setText(supplier.getName());
                lblComName.setText(supplier.getCompany());
                lblAgreement.setText(supplier.getAgreement());
            } else {
                new Alert(Alert.AlertType.WARNING, "Search Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
