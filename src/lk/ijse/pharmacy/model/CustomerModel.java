package lk.ijse.pharmacy.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO customer VALUES(?, ?, ?, ?, ?)",
                customer.getCustomer_id(),
                customer.getName(),
                customer.getAddress(),
                customer.getContact_no(),
                customer.getNic()
        );
    }
    public static ArrayList<Customer> getList() throws SQLException, ClassNotFoundException {

        ArrayList<Customer> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer");
        while (rst.next()) {
        Customer customer = new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5));
       arrayList.add(customer);
        }
        return arrayList;
        }

    public static boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("UPDATE customer SET name = ? , address = ? , contact_no = ? , nic = ?  WHERE customer_id = ?",
                        customer.getName(),
                        customer.getAddress(),
                        customer.getContact_no(),
                        customer.getNic(),
                        customer.getCustomer_id()
                );
    }

    public static Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer WHERE customer_id = ?",id);
        if (rst.next()){
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5));
        }
        return new Customer();
    }
    }

