package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.util.RegExPatterns;

import java.lang.reflect.Array;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class EmployeeFormController {
    public JFXButton btnSaveEmployee;
    public JFXButton btnClearEmployee;
    public JFXButton btnSearchEmployee;
    public TableView tblEmployee;
    public JFXButton btnBack;
    public JFXButton btnUpdateEmployee;
    public JFXTextField txtEmpId;
    public JFXTextField txtEmpAddress;
    public JFXTextField txtEmpName;
    public JFXTextField txtEmpNic;
    public JFXTextField txtNo;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colRole;
    public TableColumn colNic;
    public TableColumn colNo;
    //public JFXComboBox cmbRole;

    public void SaveEmployeeOnAction(ActionEvent actionEvent) {
        String employee_id = txtEmpId.getText();
        String name = txtEmpName.getText();
        String address = txtEmpAddress.getText();
        int contact_no = Integer.parseInt(txtNo.getText());
        String nic = txtEmpNic.getText();
        String role = cmbRole.getValue().toString();

        Employee employee = new Employee(employee_id, name, address, contact_no, nic, role);
        try {
            boolean add = EmployeeModel.save(employee);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Added Success").show();
                setTblEmployee();
            } else {
                new Alert(Alert.AlertType.WARNING, "Added Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setTblEmployee() throws SQLException, ClassNotFoundException {
        tblEmployee.getItems().clear();
        ArrayList<Employee> employees = EmployeeModel.getList();
        ObservableList<Employee> observableArrayList = tblEmployee.getItems();
        for (Employee e : employees) {
            observableArrayList.add(e);
            tblEmployee.setItems(observableArrayList);
        }
    }

    public void ClearEmployeeOnAction(ActionEvent actionEvent) {
        txtEmpId.setText("");
        txtEmpName.setText("");
        txtEmpAddress.setText("");
        txtNo.setText("");
        txtEmpNic.setText("");
        cmbRole.setValue("");
    }

    public void SearchEmployeeOnAction(ActionEvent actionEvent) {
        String employee_id = txtEmpId.getText();
        try {
            Employee employee = EmployeeModel.search(employee_id);
            if (employee != null) {
                txtEmpName.setText(employee.getName());
                txtEmpAddress.setText(employee.getAddress());
                txtNo.setText(Integer.toString(employee.getContact_no()));
                txtEmpNic.setText(employee.getNic());
                cmbRole.setValue(employee.getRole());
            } else {
                new Alert(Alert.AlertType.WARNING, "Search Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void backOnAction(ActionEvent actionEvent) {
    }

    public void UpdateEmployeeOnAction(ActionEvent actionEvent) {
        String employee_id = txtEmpId.getText();
        String name = txtEmpName.getText();
        String address = txtEmpAddress.getText();
        int contact_no = Integer.parseInt(txtNo.getText());
        String nic = txtEmpNic.getText();
        String role = cmbRole.getValue().toString();

        Employee employee = new Employee(employee_id, name, address, contact_no, nic, role);
        try {
            boolean add = EmployeeModel.update(employee);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Update Success").show();
                setTblEmployee();
            } else {
                new Alert(Alert.AlertType.WARNING, "Update Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private ComboBox cmbRole;

    public void initialize() {
        LoadRole();

        colId.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        try {
            setTblEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void LoadRole() {

        ArrayList<String> roleList = new ArrayList<>();//EmployeeModel.loadRole();
        roleList.add("Admin");
        roleList.add("Cashier");
        roleList.add("Pharmasist");
        roleList.add("Security");
        roleList.add("Cleaner");
        ObservableList observableList = FXCollections.observableArrayList();
        for (String s : roleList) {
            observableList.add(s);
            cmbRole.setItems(observableList);
        }
    }

    public void validetId(KeyEvent keyEvent) {
        boolean matches = RegExPatterns.getIdPattern().matcher(txtEmpNic.getText()).matches();
        if (!matches){
//            txtSupEmail.getFocusColor(red);
            btnSaveEmployee.setDisable(true);
            btnUpdateEmployee.setDisable(true);
        }else {
            btnSaveEmployee.setDisable(false);
            btnUpdateEmployee.setDisable(false);
        }
    }

    public void validetNo(KeyEvent keyEvent) {
        boolean matches = RegExPatterns.getMobilePattern().matcher(txtNo.getText()).matches();
        if (!matches){
//            txtSupEmail.getFocusColor(red);
            btnSaveEmployee.setDisable(true);
            btnUpdateEmployee.setDisable(true);
        }else {
            btnSaveEmployee.setDisable(false);
            btnUpdateEmployee.setDisable(false);
        }
    }

    public void validEmpId(KeyEvent keyEvent) {
        boolean matches = RegExPatterns.getEmployeePattern().matcher(txtEmpId.getText()).matches();
        if (!matches){
//            txtSupEmail.getFocusColor(red);
            btnSaveEmployee.setDisable(true);
            btnUpdateEmployee.setDisable(true);
        }else {
            btnSaveEmployee.setDisable(false);
            btnUpdateEmployee.setDisable(false);
        }
    }
}
