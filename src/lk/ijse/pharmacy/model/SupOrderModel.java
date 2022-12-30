package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.CusOrder;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Item;
import lk.ijse.pharmacy.to.SupOrder;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupOrderModel {
    public static boolean save(SupOrder supOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO sup_order_details VALUES(?, ?, ?, ?, ?)",
                supOrder.getOrder_id(),
                supOrder.getCode(),
                supOrder.getEmployee_id(),
                supOrder.getUnitPrice(),
                supOrder.getQuantity()
        );
    }

    public static String getNewOrderID() throws SQLException, ClassNotFoundException {
        ResultSet lastOrderID = CrudUtil.execute("select order_id from sup_order_details order by order_id desc limit 1 ");
        if (lastOrderID.next()) {
            return "O" + String.format("%03d", Integer.parseInt(lastOrderID.getString(1).split("O")[1]) + 1);
        }
        return "S001";
    }

    public static boolean save_orderGoods(String order_id, String supplier_id, String date) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO sup_order_goods VALUES(? , ? , ? )",
                order_id,
                supplier_id,
                date
        );
    }

    public static ArrayList<String> getItemList() throws SQLException, ClassNotFoundException {

        ArrayList<String> itemIdList = new ArrayList<>();
        ResultSet rstItem = CrudUtil.execute("SELECT item_code  FROM item");
        ResultSet rstMedi = CrudUtil.execute("SELECT medi_code  FROM medicines");
        while (rstItem.next()) {
            itemIdList.add(rstItem.getString(1));
        }
        while (rstMedi.next()) {
            itemIdList.add(rstMedi.getString(1));
        }
        return itemIdList;
    }

    public static Item search(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.execute("SELECT * FROM item WHERE item_code = ?", id);
        if (rst.next()) {
            return new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getInt(6), rst.getInt(7));
        }
        return new Item();

    }

    public static Employee searchEmp(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.execute("SELECT * FROM employee WHERE employee_id = ?", id);
        if (rst.next()) {
            return new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6));
        }
        return new Employee();

    }
}
