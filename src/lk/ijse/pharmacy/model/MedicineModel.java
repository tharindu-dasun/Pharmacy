package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Medicines;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineModel {

    public static boolean save(Medicines medicines) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO medicines VALUES(?, ?, ?, ?, ?, ?, ?)",
                medicines.getMedi_code(),
                medicines.getName(),
                medicines.getBrand(),
                medicines.getM_Date(),
                medicines.getEx_Date(),
                medicines.getQuantity(),
                medicines.getUnit_price()
        );
    }
    public static ArrayList<Medicines> getList() throws SQLException, ClassNotFoundException {
        ArrayList<Medicines> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM medicines");
        while (rst.next()) {
            Medicines medicines  = new Medicines(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getInt(7));
            arrayList.add(medicines);
        }
        return arrayList;
    }

    public static boolean update(Medicines medicines) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("UPDATE medicines SET name = ? , brand = ? , M_Date = ? , Ex_Date = ? , quantity = ? , unit_price = ? WHERE medi_code = ?",
                        medicines.getName(),
                        medicines.getBrand(),
                        medicines.getM_Date(),
                        medicines.getEx_Date(),
                        medicines.getQuantity(),
                        medicines.getUnit_price(),
                        medicines.getMedi_code()
                );
    }

    public static Medicines search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM medicines WHERE medi_code = ?",id);
        if (rst.next()){
            return new Medicines(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getInt(6) , rst.getInt(7));
        }
        return new Medicines();
    }
}
