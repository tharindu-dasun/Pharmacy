package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Item;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public static boolean userCheck(String user_name , String password) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM user WHERE user_name = ? AND password = SHA(?)",user_name,password);
        if (rst.next()){
            return true;
        }
        return false;
    }
}
