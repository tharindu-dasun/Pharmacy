package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.pharmacy.model.SupplierModel;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;


public class SupplierFormController {
    public JFXButton btnSaveSupplier;
    public JFXButton btnClearSupplier;
    public JFXButton btnSearchSupplier;
    public TableView tblSupplier;
    public JFXButton btnBack;
    public JFXButton btnUpdateSupplier;
    //public JFXComboBox cmbAgreement;
    public JFXTextField txtSupId;
    public JFXTextField txtSupComName;
    public JFXTextField txtSupName;
    public JFXTextField txtSupEmail;
    public JFXTextField txtNo;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colComName;
    public TableColumn colAgreement;
    public TableColumn colEmail;
    public TableColumn colNo;
    //private String[] agreementList;

    public void SaveSupplierOnAction(ActionEvent actionEvent) {
        String supplier_id = txtSupId.getText();
        String name = txtSupName.getText();
        String company = txtSupComName.getText();
        int contact_no = Integer.parseInt(txtNo.getText());
        String Email = txtSupEmail.getText();
        String Agreement = cmbAgreement.getValue().toString();

        Supplier supplier = new Supplier(supplier_id, name, company, contact_no, Email, Agreement) {
            @Override
            public Object get() {
                return null;
            }
        };
        try {
            boolean add= SupplierModel.save(supplier);
            if (add){
                new Alert(Alert.AlertType.INFORMATION,"Added Success").show();
                setTblSupplier();
            }else {
                new Alert(Alert.AlertType.WARNING,"Added Fail").show();
            }        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setTblSupplier() throws SQLException, ClassNotFoundException {
        tblSupplier.getItems().clear();
        ArrayList<Supplier> suppliers = SupplierModel.getList();
        ObservableList<Supplier> observableArrayList = tblSupplier.getItems();
        for (Supplier s:suppliers) {
            observableArrayList.add(s);
            tblSupplier.setItems(observableArrayList);
        }
    }

    public void ClearSupplierOnAction(ActionEvent actionEvent) {
        txtSupId.setText("");
        txtSupName.setText("");
        txtSupComName.setText("");
        txtNo.setText("");
        txtSupEmail.setText("");
        cmbAgreement.setValue("");
    }

    public void SearchSupplierOnAction(ActionEvent actionEvent) {
        String supplier_id = txtSupId.getText();
        try {
            Supplier supplier = SupplierModel.search(supplier_id);
            if (supplier != null) {
                txtSupName.setText(supplier.getName());
                txtSupComName.setText(supplier.getCompany());
                txtNo.setText(Integer.toString(supplier.getContact_no()));
                txtSupEmail.setText(supplier.getEmail());
                cmbAgreement.setValue(supplier.getAgreement());
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

    public void UpdateSupplierOnAction(ActionEvent actionEvent) {
        String supplier_id = txtSupId.getText();
        String name = txtSupName.getText();
        String company = txtSupComName.getText();
        int contact_no = Integer.parseInt(txtNo.getText());
        String Email = txtSupEmail.getText();
        String Agreement = cmbAgreement.getValue().toString();

        Supplier supplier = new Supplier(supplier_id, name, company, contact_no, Email, Agreement) {
            @Override
            public Object get() {
                return null;
            }
        };
        try {
            boolean add= SupplierModel.update(supplier);
            if (add){
                new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
                setTblSupplier();
            }else {
                new Alert(Alert.AlertType.WARNING,"Update Fail").show();
            }        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private ComboBox cmbAgreement;
    public void initialize(){
        LoadAgreement();

        colId.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colComName.setCellValueFactory(new PropertyValueFactory<>("company"));
        colNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colNo.setCellValueFactory(new PropertyValueFactory<>("Agreement"));
        try {
            setTblSupplier();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void LoadAgreement() {
        ArrayList<String> agreementList = new ArrayList<>();//EmployeeModel.loadRole();
        agreementList.add("3 Months");
        agreementList.add("6 Months");
        agreementList.add("Full Payment");
        ObservableList observableList = FXCollections.observableArrayList();
        for (String s : agreementList) {
            observableList.add(s);
            cmbAgreement.setItems(observableList);
        }
    }
}
