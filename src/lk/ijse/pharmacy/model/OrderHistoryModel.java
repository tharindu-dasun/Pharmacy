package lk.ijse.pharmacy.model;

import javafx.collections.ObservableList;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.OrderHistory;
import lk.ijse.pharmacy.to.Supplier;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderHistoryModel {
    public static ArrayList<OrderHistory> getList() throws SQLException, ClassNotFoundException {

        ArrayList<OrderHistory> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM order_details");
        while (rst.next()) {
            OrderHistory orderHistory = new OrderHistory(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5) , rst.getInt(6));
            arrayList.add(orderHistory);
        }
        return arrayList;
    }
}
