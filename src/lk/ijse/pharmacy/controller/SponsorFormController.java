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
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.model.SponsorModel;
import lk.ijse.pharmacy.model.SupplierModel;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Sponsor;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SponsorFormController {
    public JFXButton btnSaveSponsor;
    public JFXButton btnClearSponsor;
    public JFXButton btnSearchSponsor;
    public TableView tblSponsor;
    public JFXButton btnBack;
    public JFXButton btnUpdateSponsor;
    public JFXTextField txtSpnId;
    public JFXTextField txtSpnName;
    public JFXTextField txtSpnEmail;
    public JFXTextField txtSpnNo;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colType;
    public TableColumn colDis;
    public TableColumn colEmail;
    public TableColumn colNo;
    //
    // public JFXComboBox cmbSpnType;
    public JFXTextField txtSpnDis;

    public void SaveSponsorOnAction(ActionEvent actionEvent) {
        String sponsor_id = txtSpnId.getText();
        String name = txtSpnName.getText();
        int contact_no = Integer.parseInt(txtSpnNo.getText());
        String Email = txtSpnEmail.getText();
        String discount_percentage  = txtSpnDis.getText();
        String Type = cmbSpnType.getValue().toString();

        Sponsor sponsor = new Sponsor(sponsor_id, name, contact_no, Email, discount_percentage, Type) {
            @Override
            public Object get() {
                return null;
            }
        };
        try {
            boolean add= SponsorModel.save(sponsor);
            if (add){
                new Alert(Alert.AlertType.INFORMATION,"Added Success").show();
                setTblSponsor();
            }else {
                new Alert(Alert.AlertType.WARNING,"Added Fail").show();
            }        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setTblSponsor() throws SQLException, ClassNotFoundException {
        tblSponsor.getItems().clear();
        ArrayList<Sponsor> sponsors = SponsorModel.getList();
        ObservableList<Sponsor> observableArrayList = tblSponsor.getItems();
        for (Sponsor s:sponsors) {
            observableArrayList.add(s);
            tblSponsor.setItems(observableArrayList);
        }
    }

    @FXML
    private ComboBox cmbSpnType;
    //public JFXComboBox cmbSpnType;
    public void initialize(){
        LoadType();

        colId.setCellValueFactory(new PropertyValueFactory<>("sponsor_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colDis.setCellValueFactory(new PropertyValueFactory<>("discount_percentage"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        try {
            setTblSponsor();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void LoadType() {
        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("Doctor");
        typeList.add("Hospital");
        ObservableList observableList = FXCollections.observableArrayList();
        for (String s : typeList) {
            observableList.add(s);
            cmbSpnType.setItems(observableList);
        }
    }

    public void ClearSponsorOnAction(ActionEvent actionEvent) {
        txtSpnId.setText("");
        txtSpnName.setText("");
        txtSpnNo.setText("");
        txtSpnEmail.setText("");
        txtSpnDis.setText("");
        cmbSpnType.setValue("");
    }

    public void SearchSponsorOnAction(ActionEvent actionEvent) {
        String sponsor_id = txtSpnId.getText();
        try {
            Sponsor sponsor = SponsorModel.search(sponsor_id);
            if (sponsor != null) {
                txtSpnName.setText(sponsor.getName());
                //txtSpnNo.setText(sponsor.getC());
                txtSpnNo.setText(Integer.toString(sponsor.getContact_no()));
                txtSpnEmail.setText(sponsor.getEmail());
                txtSpnDis.setText(sponsor.getDiscount_percentage());
                cmbSpnType.setValue(sponsor.getType());
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

    public void UpdateSponsorOnAction(ActionEvent actionEvent) {
        String sponsor_id = txtSpnId.getText();
        String name = txtSpnName.getText();
        //String address = txtEmpAddress.getText();
        int contact_no = Integer.parseInt(txtSpnNo.getText());
        String Email = txtSpnEmail.getText();
        String discount_percentage = txtSpnDis.getText();
        String Type = cmbSpnType.getValue().toString();

        Sponsor sponsor = new Sponsor(sponsor_id, name, contact_no, Email, discount_percentage, Type) {
            @Override
            public Object get() {
                return null;
            }
        };
        try {
            boolean add = SponsorModel.update(sponsor);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Update Success").show();
                setTblSponsor();
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
