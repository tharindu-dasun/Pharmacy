package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.model.MedicineModel;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Medicines;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class MedicineFormController {
    public JFXButton btnSearchMedi;
    public JFXButton btnSaveMedi;
    public JFXButton btnClearMedi;
    public TableView <Medicines>tblMedicine;
    public JFXButton btnBack;
    public JFXButton btnUpdateMedi;
    public JFXTextField txtMediId;
    public JFXTextField txtBrand;
    public JFXTextField txtMediName;
    public JFXTextField txtQty;
    public JFXTextField txtPrice;
    public JFXDatePicker txtEdate;
    public JFXDatePicker txtMdate;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colBrand;
    public TableColumn colPrice;
    public TableColumn colMdate;
    public TableColumn colEdate;
    public TableColumn colQty;
    public JFXTextField txtExdate;
    public JFXTextField txtManufactureDate;
    public JFXDatePicker dpExdate;
    public JFXDatePicker dpManuFdate;

    public void SearchMediOnAction(ActionEvent actionEvent) {
        String medi_code = txtMediId.getText();
        try {
            Medicines medicines = MedicineModel.search(medi_code);
            if (medicines != null) {
                txtMediName.setText(medicines.getName());
                txtBrand.setText(medicines.getBrand());
                String mDate = medicines.getM_Date();
                int m_year = Integer.parseInt(medicines.getM_Date().split("-")[0]);
                int m_month = Integer.parseInt(medicines.getM_Date().split("-")[1]);
                int m_date = Integer.parseInt(medicines.getM_Date().split("-")[2]);
                dpManuFdate.setValue(LocalDate.of(m_year, m_month, m_date));
                String eDate = medicines.getM_Date();
                int e_year = Integer.parseInt(medicines.getM_Date().split("-")[0]);
                int e_month = Integer.parseInt(medicines.getM_Date().split("-")[1]);
                int e_date = Integer.parseInt(medicines.getM_Date().split("-")[2]);
                dpExdate.setValue(LocalDate.of(e_year, e_month, e_date));
                txtQty.setText(Integer.toString(medicines.getQuantity()));
                txtPrice.setText(Integer.toString(medicines.getUnit_price()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Search Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void SaveMediOnAction(ActionEvent actionEvent) {
        String medi_code = txtMediId.getText();
        String name = txtMediName.getText();
        String brand = txtBrand.getText();
        String M_Date = dpManuFdate.getValue().toString();
        String Ex_Date = dpExdate.getValue().toString();
        int quantity = Integer.parseInt(txtQty.getText());
        int unit_price  = Integer.parseInt(txtPrice.getText());

        Medicines medicines = new Medicines(medi_code,name,brand,M_Date,Ex_Date,quantity,unit_price);
        try {
            boolean isAdd= MedicineModel.save(medicines);
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
        colId.setCellValueFactory(new PropertyValueFactory<>("medi_code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colMdate.setCellValueFactory(new PropertyValueFactory<>("M_Date"));
        colEdate.setCellValueFactory(new PropertyValueFactory<>("Ex_Date"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));

        try {
            setTblMedicines();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setTblMedicines() throws SQLException, ClassNotFoundException {
        tblMedicine.getItems().clear();
        ArrayList<Medicines> medicines = MedicineModel.getList();
        ObservableList<Medicines> observableArrayList = tblMedicine.getItems();
        for (Medicines m : medicines ) {
            observableArrayList.add( m );
            tblMedicine.setItems(observableArrayList);
        }
    }

    public void ClearMediOnAction(ActionEvent actionEvent) {
        txtMediId.setText("");
        txtMediName.setText("");
        txtBrand.setText("");
        dpManuFdate.setValue(null);
        dpExdate.setValue(null);
        txtQty.setText("");
        txtPrice.setText("");
    }

    public void backOnAction(ActionEvent actionEvent) {
    }

    public void UpdateMediOnAction(ActionEvent actionEvent) {
        String medi_code = txtMediId.getText();
        String name = txtMediName.getText();
        String brand = txtBrand.getText();
        String M_Date = dpManuFdate.getValue().toString();
        String Ex_Date = dpExdate.getValue().toString();
        int quantity = Integer.parseInt(txtQty.getText());
        int unit_price  = Integer.parseInt(txtPrice.getText());

        Medicines medicines = new Medicines(medi_code,name,brand,M_Date,Ex_Date,quantity,unit_price);
        try {
            boolean add = MedicineModel.update(medicines);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Update Success").show();
                setTblMedicines();
            } else {
                new Alert(Alert.AlertType.WARNING, "Update Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void tblMedicineOnAction(SortEvent<TableView> tableViewSortEvent) {

    }
}
