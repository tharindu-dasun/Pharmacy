package lk.ijse.pharmacy.controller;

import java.time.LocalDate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.model.CusOrderModel;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.ItemModel;
import lk.ijse.pharmacy.model.MedicineModel;
import lk.ijse.pharmacy.to.*;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PlaceOrderFormController {
    public JFXButton btnBack;
    public AnchorPane pane;
    public TextField txtQty;
    public JFXComboBox cmbItemCode;
    public Label lblDescription;
    public Label lblDescription1;
    public TextField txtSpnId;
    public Label txtOrderId;
    public Label txtDate;
    public Label txtTime;
    public Label txtCashierId;
    public Label lblUnitPrice;
    public Label lblQtyOnHand;
    public TableView<OrderTable> tblOrderCart;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colMdate;
    public TableColumn colExDate;
    public TableColumn colTotal;
    public JFXTextField txtCusId;
    public JFXComboBox cmbCode;
    public JFXTextField txtCashierIdd;
    public Label lblMDate;
    public Label lblExDate;
    public JFXTextField txtCustomerName;
    public JFXTextField txtTotalAmount;
    public JFXTextField txtNetAmount;
    public JFXComboBox cmbCusId;
    public JFXComboBox cmbSpnId;
    public JFXComboBox cmbCashId;

    private double total = 0.00;


    public void initialize() throws SQLException, ClassNotFoundException {
        loadItemCode();
        txtOrderId.setText(CusOrderModel.getNewOrderID());

        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("QtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colMdate.setCellValueFactory(new PropertyValueFactory<>("M_date"));
        colExDate.setCellValueFactory(new PropertyValueFactory<>("Ex_date"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
//
//        try {
//            setTblItem();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }

    public void cmbItemOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Object value = cmbCode.getValue();
        if (value != null) {
            String itemId = value.toString();
            String s = itemId.split("")[0];
            if (s.equals("I")) {
                Item itemDetails = CusOrderModel.search(itemId);
                lblDescription.setText(itemDetails.getDescription());
                lblUnitPrice.setText(Integer.toString(itemDetails.getUnit_price()));
                lblQtyOnHand.setText(Integer.toString(itemDetails.getQuantity()));
                lblMDate.setText(itemDetails.getM_date());
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

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String order_id = txtOrderId.getText();
        String sponsor_id = "SP002";//txtSpnId.getText();
        String employee_id = "E003";//txtCashierIdd.getText();
        String customer_id = "C001";//txtCusId.getText();
        String date = LocalDate.now().toString();

        ObservableList<OrderTable> items = tblOrderCart.getItems();
        for (OrderTable O : items) {
            String code = O.getCode();
            int unit_price =O.getUnitPrice();
            int quantity = O.getQtyOnHand();

            CusOrder cusOrder = new CusOrder(order_id, code, sponsor_id, employee_id, customer_id, date, unit_price, quantity);
            try {
                boolean isAdd = CusOrderModel.save(cusOrder);
                if (isAdd) {
                   // new Alert(Alert.AlertType.CONFIRMATION, "Added");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        CusOrderModel.save_orderGoods(order_id, customer_id, date);
    }

    private void loadItemCode() throws SQLException, ClassNotFoundException {

        ArrayList<String> itemIdList = CusOrderModel.getItemList();

        ObservableList observableList = FXCollections.observableArrayList();
        for (String s : itemIdList) {
            observableList.add(s);
            cmbCode.setItems(observableList);
        }
    }


//    private void setTblOrderCart() throws SQLException,ClassNotFoundException {
//        tblOrderCart.getItems().clear();
//        ArrayList<CusOrder> cusOrders = null;
//        try {
//            cusOrders = CusOrderModel.getList();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        ObservableList<CusOrder> observableArrayList = tblOrderCart.getItems();
//        for (CusOrder c : cusOrders) {
//            observableArrayList.add(c);
//            tblOrderCart.setItems(observableArrayList);
//        }
//    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String customer_id = txtCusId.getText();
        try {
            Customer customer = CustomerModel.search(customer_id);
            if (customer != null) {
                txtCustomerName.setText(customer.getName());
            } else {
                new Alert(Alert.AlertType.WARNING, "Search Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void NewCusOnAction(ActionEvent actionEvent) {
    }

    public void txtQtyOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ArrayList<OrderTable> items = new ArrayList<>();
        OrderTable orderTableRow = new OrderTable();
        orderTableRow.setCode(cmbCode.getValue().toString());
        orderTableRow.setDescription(lblDescription.getText());
        orderTableRow.setQtyOnHand(Integer.parseInt(txtQty.getText()));
        orderTableRow.setUnitPrice(Integer.parseInt(lblUnitPrice.getText()));
        orderTableRow.setM_date(lblMDate.getText());
        orderTableRow.setEx_date(lblExDate.getText());
        int rowTotal = Integer.parseInt(txtQty.getText()) * Integer.parseInt(lblUnitPrice.getText());
        orderTableRow.setTotal(rowTotal);
        total += rowTotal;
        txtTotalAmount.setText(Double.toString(total));
        Double discout = 0.05;
        txtNetAmount.setText(Double.toString(total*(1-discout)));
        items.add(orderTableRow);
        ObservableList<OrderTable> observableArrayList = tblOrderCart.getItems();
        for (OrderTable i : items) {
            observableArrayList.add(i);
            tblOrderCart.setItems(observableArrayList);
        }
        ClearItemData();
    }

    public void AddOnAction(ActionEvent actionEvent) {
    }

    private void ClearItemData() {
        txtQty.setText("");
        lblDescription.setText("");
        lblQtyOnHand.setText("");
        lblUnitPrice.setText("");
        cmbCode.setValue(null);
    }

    public void cmbCusOnAction(ActionEvent actionEvent) {

    }

    public void cmbCashOnAction(ActionEvent actionEvent) {
    }

    public void cmbSpnOnAction(ActionEvent actionEvent) {
    }
}
