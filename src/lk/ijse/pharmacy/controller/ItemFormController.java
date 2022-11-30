package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.model.ItemModel;
import lk.ijse.pharmacy.model.MedicineModel;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Item;
import lk.ijse.pharmacy.to.Medicines;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItemFormController {
    public TableView tblItem;
    public JFXButton btnSaveItem;
    public JFXButton btnClearItem;
    public JFXButton btnSearchItem;
    public JFXButton btnBack;
    public JFXButton btnUpdateItem;
    public TableColumn ColId;
    public TableColumn colDes;
    public TableColumn colBrand;
    public TableColumn colMdate;
    public TableColumn colExDate;
    public TableColumn colQty;
    public TableColumn colPrice;
    public JFXTextField txtPrice;
    public JFXTextField txtQty;
    public JFXTextField txtDes;
    public JFXTextField txtBrand;
    public JFXTextField txtId;
    public JFXDatePicker dpMdate;
    public JFXDatePicker dpExdate;
    public TableColumn colId;
    public TableColumn colMDate;

    public void SaveItemOnAction(ActionEvent actionEvent) {
        String item_code = txtId.getText();
        String description = txtDes.getText();
        String brand = txtBrand.getText();
        String M_Date = dpMdate.getValue().toString();
        String Ex_Date = dpExdate.getValue().toString();
        int quantity = Integer.parseInt(txtQty.getText());
        int unit_price = Integer.parseInt(txtPrice.getText());

        Item item = new Item(item_code, description, brand, M_Date, Ex_Date, quantity , unit_price);
        try {
            boolean add = ItemModel.save(item);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Added Success").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Added Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setTblItem() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = ItemModel.getList();
        ObservableList<Item> observableArrayList = tblItem.getItems();
        for (Item i : items ) {
            observableArrayList.add( i );
            tblItem.setItems(observableArrayList);
        }
    }

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("description"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colMDate.setCellValueFactory(new PropertyValueFactory<>("M_Date"));
        colExDate.setCellValueFactory(new PropertyValueFactory<>("Ex_Date"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));

        try {
            setTblItem();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ClearItemOnAction(ActionEvent actionEvent) {
    }

    public void SearchItemOnAction(ActionEvent actionEvent) {
    }

    public void backOnAction(ActionEvent actionEvent) {
    }

    public void UpdateItemOnAction(ActionEvent actionEvent) {

    }
}
