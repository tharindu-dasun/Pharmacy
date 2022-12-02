package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFormController {
    public JFXButton btnSaveCus;
    public JFXButton btnClearCus;
    public JFXButton btnSearchCus;
    public TableView <Customer>tblCustomer;
    public JFXButton btnBack;
    public AnchorPane cusContext;
    public JFXTextField txtCusId;
    public JFXTextField txtCusAddress;
    public JFXTextField txtCusName;
    public JFXTextField txtNic;
    public JFXTextField txtContact;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colNic;
    public TableColumn colContact;
    public JFXButton btnSearchCus1;
    public JFXButton btnUpdateCus;

    public void SaveCusOnAction(ActionEvent actionEvent) {
        String customer_id = txtCusId.getText();
        String name = txtCusName.getText();
        String address = txtCusAddress.getText();
        String nic = txtNic.getText();
        int contact_no = Integer.parseInt(txtContact.getText());

        Customer customer=new Customer(customer_id,name,address,contact_no,nic);
        try {
            boolean isAdd=CustomerModel.save(customer);
            if (isAdd){
                new Alert(Alert.AlertType.CONFIRMATION,"Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        try {
            setTblCustomer();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setTblCustomer() throws SQLException, ClassNotFoundException {
      ArrayList<Customer> customers = CustomerModel.getList();
        ObservableList<Customer> observableArrayList = tblCustomer.getItems();
        for (Customer c:customers) {
            observableArrayList.add(c);
            tblCustomer.setItems(observableArrayList);
        }
    }

    public void ClearCusOnAction(ActionEvent actionEvent) {
        txtCusId.setText("");
        txtCusName.setText("");
        txtCusAddress.setText("");
        txtContact.setText("");
        txtNic.setText("");
    }

    public void SearchCusOnAction(ActionEvent actionEvent) {
        String customer_id = txtCusId.getText();
        try {
            Customer customer = CustomerModel.search(customer_id);
            if (customer != null) {
                txtCusName.setText(customer.getName());
                txtCusAddress.setText(customer.getAddress());
                txtContact.setText(Integer.toString(customer.getContact_no()));
                txtNic.setText(customer.getNic());
            } else {
                new Alert(Alert.AlertType.WARNING, "Search Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.BACK,cusContext);
    }

    public void UpdateCusOnAction(ActionEvent actionEvent) {
        String customer_id = txtCusId.getText();
        String name = txtCusName.getText();
        String address = txtCusAddress.getText();
        int contact_no = Integer.parseInt(txtContact.getText());
        String nic = txtNic.getText();

        Customer customer = new Customer(customer_id, name, address, contact_no, nic);
        try {
            boolean add = CustomerModel.update(customer);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Update Success").show();
                setTblCustomer();
            } else {
                new Alert(Alert.AlertType.WARNING, "Update Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
