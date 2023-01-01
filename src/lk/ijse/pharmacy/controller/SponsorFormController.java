package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.model.SponsorModel;
import lk.ijse.pharmacy.model.SupplierModel;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Sponsor;
import lk.ijse.pharmacy.to.Supplier;
import lk.ijse.pharmacy.util.RegExPatterns;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.matches;

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
//    LinkedHashMap<TextField,Pattern>map = new LinkedHashMap<>();

//    public static String validateEmail (String email){
//
//        return email;
//    }
//        if (email == null || email.isEmpty()){
//            return "Invalid Email";
//        }
//        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
//        Pattern pattern = Pattern.compile(emailRegex);
//        if (pattern.matcher(email).matches()) {
//            return "Valied";
//        }else{
//            return "Invalid";
//        }


    public void SaveSponsorOnAction(ActionEvent actionEvent) {

   //     Pattern idPattern=Pattern.compile("\"[SP]+[0-9]{1,}\"");
        String sponsor_id = txtSpnId.getText();
        String name = txtSpnName.getText();
        int contact_no = Integer.parseInt(txtSpnNo.getText());
        String Email = String.valueOf(txtSpnEmail.getText());
        String discount_percentage = txtSpnDis.getText();
        String Type = cmbSpnType.getValue().toString();

//        if (matches()) {
        Sponsor sponsor = new Sponsor(sponsor_id, name, contact_no, Email, discount_percentage, Type) {
            @Override
            public Object get() {
                return null;
            }
        };

        try {
            boolean add = SponsorModel.save(sponsor);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Added Success").show();
                setTblSponsor();
            } else {
                new Alert(Alert.AlertType.WARNING, "Added Fail").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean matches() {

        return false;
    }


    public void UpdateSponsorOnAction(ActionEvent actionEvent) {
        String sponsor_id = txtSpnId.getText();
        String name = txtSpnName.getText();
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

    private void setTblSponsor() throws SQLException, ClassNotFoundException {
        tblSponsor.getItems().clear();
        ArrayList<Sponsor> sponsors = SponsorModel.getList();
        ObservableList<Sponsor> observableArrayList = tblSponsor.getItems();
        for (Sponsor s : sponsors) {
            observableArrayList.add(s);
            tblSponsor.setItems(observableArrayList);
        }
    }

    @FXML
    private ComboBox cmbSpnType;

    //public JFXComboBox cmbSpnType;
    public void initialize() {
        LoadType();

        colId.setCellValueFactory(new PropertyValueFactory<>("sponsor_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colDis.setCellValueFactory(new PropertyValueFactory<>("discount_percentage"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));

//        Pattern idPattern=Pattern.compile("\"[SP]+[0-9]{1,}\"");
//        if (!Objects.equals(txtSpnId, idPattern)){
//            new Alert(Alert.AlertType.WARNING, "ID WARADI").show();
//        }
//        map.put(txtSpnId,idPattern);


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

    public void spnIdOnAction(ActionEvent actionEvent) {

    }
    public void validetEmail(KeyEvent keyEvent) {
        boolean matches = RegExPatterns.getEmailPattern().matcher(txtSpnEmail.getText()).matches();
        if (!matches){
//            txtSupEmail.getFocusColor(red);
            btnSaveSponsor.setDisable(true);
            btnUpdateSponsor.setDisable(true);
        }else {
            btnSaveSponsor.setDisable(false);
            btnUpdateSponsor.setDisable(false);
        }
    }

    public void validetNo(KeyEvent keyEvent) {
        boolean matches = RegExPatterns.getMobilePattern().matcher(txtSpnNo.getText()).matches();
        if (!matches){
//            txtSupEmail.getFocusColor(red);
            btnSaveSponsor.setDisable(true);
            btnUpdateSponsor.setDisable(true);
        }else {
            btnSaveSponsor.setDisable(false);
            btnUpdateSponsor.setDisable(false);
        }
    }

    public void validSpnId(KeyEvent keyEvent) {
        boolean matches = RegExPatterns.getSponsorPattern().matcher(txtSpnId.getText()).matches();
        if (!matches){
//            txtSupEmail.getFocusColor(red);
            btnSaveSponsor.setDisable(true);
            btnUpdateSponsor.setDisable(true);
        }else {
            btnSaveSponsor.setDisable(false);
            btnUpdateSponsor.setDisable(false);
        }
    }
}
