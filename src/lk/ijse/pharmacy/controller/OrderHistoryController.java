package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pharmacy.model.CusOrderModel;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.OrderHistoryModel;
import lk.ijse.pharmacy.model.SupplierModel;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.OrderHistory;
import lk.ijse.pharmacy.to.OrderTable;
import lk.ijse.pharmacy.to.Supplier;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderHistoryController {
    public JFXButton btnBack;
    public JFXButton reportOrderHistory;
    public TableColumn ColId;
    public TableColumn ColItemCode;
    public TableColumn ColEmpId;
    public TableColumn ColSpnId;
    public TableColumn ColUnitPrice;
    public TableColumn ColQty;
    public TableView tblCusOrder;



    public void backOnAction(ActionEvent actionEvent) {
    }

    public void orderHistoryOnAction(ActionEvent actionEvent) {

    }

    private void setTblCusOrder() throws SQLException, ClassNotFoundException {
        ArrayList<OrderHistory> orderHistories = OrderHistoryModel.getList();
        ObservableList<OrderHistory> observableArrayList = tblCusOrder.getItems();
        for (OrderHistory c:orderHistories) {
            observableArrayList.add(c);
            tblCusOrder.setItems(observableArrayList);
        }
    }

    public void initialize(){
        ColId.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        ColItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        ColEmpId.setCellValueFactory(new PropertyValueFactory<>("sponsor_id"));
        ColSpnId.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        ColUnitPrice.setCellValueFactory(new PropertyValueFactory<>("Unit Price"));
        ColQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        try {
            setTblCusOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
