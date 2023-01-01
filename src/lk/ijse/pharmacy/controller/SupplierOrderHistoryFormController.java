package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SupplierOrderHistoryFormController {
    public JFXButton reportOrderHistory;
    public TableView tblSupOrder;
    public TableColumn ColId;
    public TableColumn ColItemCode;
    public TableColumn ColMediCode;
    public TableColumn ColEmpId;
    public TableColumn ColUnitPrice;
    public TableColumn ColQty;

    public void orderHistoryOnAction(ActionEvent actionEvent) {
    }
}
