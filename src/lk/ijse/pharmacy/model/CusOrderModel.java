package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.*;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CusOrderModel {
    public static boolean save(CusOrder cusOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO order_details VALUES(?, ?, ?, ?, ?, ?)",
                cusOrder.getOrder_id(),
                cusOrder.getCode(),
                cusOrder.getSponsor_id(),
                cusOrder.getEmployee_id(),
                cusOrder.getUnit_price(),
                cusOrder.getQuantity()
        );
    }

    public static String getNewOrderID() throws SQLException, ClassNotFoundException {
        ResultSet lastOrderID = CrudUtil.execute("select order_id from order_details order by order_id desc limit 1 ");
        if (lastOrderID.next()) {
            return "O" + String.format("%03d", Integer.parseInt(lastOrderID.getString(1).split("O")[1]) + 1);
        }
        return "O001";
    }

    public static boolean save_orderGoods(String order_id, String customer_id, String date) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO order_goods VALUES(? , ? , ? )",
                order_id,
                customer_id,
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


//    public static ArrayList<CusOrder> getList() throws SQLException, ClassNotFoundException {
//
//        ArrayList<CusOrder> arrayList = new ArrayList<>();
//        ResultSet rst = CrudUtil.execute("SELECT * FROM order_details");
//        while (rst.next()) {
//            CusOrder cusOrder = new CusOrder(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)  , rst.getInt(6) , rst.getInt(7));
//            arrayList.add(cusOrder);
//        }
//        return arrayList;
//    }
}
