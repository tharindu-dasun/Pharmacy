package lk.ijse.pharmacy.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {
    public static ArrayList<String> loadRole() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT DISTINCT role FROM  employee ");
        ArrayList<String> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(rst.getString("role"));
        }
        return arrayList;
    }

    public static boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("INSERT INTO  employee VALUES (?, ?, ?, ? , ? ,?)",
                        employee.getEmployee_id(),
                        employee.getName(),
                        employee.getAddress(),
                        employee.getContact_no(),
                        employee.getNic(),
                        employee.getRole()
                );
    }

    public static boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("UPDATE employee SET name = ? , address = ? , contact_no = ? , nic = ? , role = ? WHERE employee_id = ?",
                        employee.getName(),
                        employee.getAddress(),
                        employee.getContact_no(),
                        employee.getNic(),
                        employee.getRole(),
                        employee.getEmployee_id()
                );
    }

    public static ArrayList<Employee> getList() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM employee");
        while (rst.next()) {
            Employee employee = new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6));
            arrayList.add(employee);
        }
        return arrayList;
    }

    public static Employee search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM employee WHERE employee_id = ?",id);
        if (rst.next()){
            return new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6));
        }
        return new Employee();
    }
}


//    public static ObservableList<Employee> getList() throws SQLException, ClassNotFoundException {
//        ObservableList<Employee> employees = FXCollections.observableArrayList();
//        ResultSet rst = CrudUtil.execute("SELECT * FROM employee");
//        while (rst.next()) {
//            employees.add(new Employee(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getInt(4),
//                    rst.getString(5),
//                    rst.getString(6)
//            ));
//        }
//        return employees;
//    }


