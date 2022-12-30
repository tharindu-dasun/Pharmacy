package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Item;
import lk.ijse.pharmacy.to.Medicines;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static boolean save(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO item VALUES(?, ?, ?, ?, ?, ?, ?)",
                item.getItem_code(),
                item.getDescription(),
                item.getBrand(),
                item.getM_Date(),
                item.getEx_Date(),
                item.getQuantity(),
                item.getUnit_price()
        );
    }
    public static ArrayList<Item> getList() throws SQLException, ClassNotFoundException {
        ArrayList<Item> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM item");
        while (rst.next()) {
            Item item  = new Item(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getInt(7));
            arrayList.add(item);
        }
        return arrayList;
    }

    public static boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("UPDATE item SET description = ? , brand = ? , M_Date = ? , Ex_Date = ? , quantity = ? , unit_price = ? WHERE item_code = ?",
                        item.getDescription(),
                        item.getBrand(),
                        item.getM_Date(),
                        item.getEx_Date(),
                        item.getQuantity(),
                        item.getUnit_price(),
                        item.getItem_code()
                );
    }

    public static Item search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM item WHERE item_code = ?",id);
        if (rst.next()){
            return new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getInt(6) , rst.getInt(7));
        }
        return new Item();
    }
}
