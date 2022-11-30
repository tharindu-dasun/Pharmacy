package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Supplier;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SupplierModel {
    public static ArrayList<String> loadAgreement() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT DISTINCT agreement FROM  supplier ");
        ArrayList<String> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(rst.getString("agreement"));
        }
        return arrayList;
    }

    public static boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("INSERT INTO  supplier VALUES (?, ?, ?, ? , ? ,?)",
                        supplier.getSupplier_id(),
                        supplier.getName(),
                        supplier.getCompany(),
                        supplier.getContact_no(),
                        supplier.getEmail(),
                        supplier.getAgreement()
                );
    }

    public static boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("UPDATE supplier SET name = ? , company = ? , contact_no = ? , Email = ? , Agreement = ? WHERE supplier_id = ?",
                        supplier.getName(),
                        supplier.getCompany(),
                        supplier.getContact_no(),
                        supplier.getEmail(),
                        supplier.getAgreement(),
                        supplier.getSupplier_id()
                );
    }

    public static ArrayList<Supplier> getList() throws SQLException, ClassNotFoundException {
        ArrayList<Supplier> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM supplier");
        while (rst.next()) {
            Supplier supplier = new Supplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6)) {
                @Override
                public Object get() {
                    return null;
                }
            };
            arrayList.add(supplier);
        }
        return arrayList;
    }

    public static Supplier search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM supplier WHERE supplier_id = ?",id);
        if (rst.next()){
            return new Supplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6)) {
                @Override
                public Object get() {
                    return null;
                }
            };
        }
        return new Supplier() {
            @Override
            public Object get() {
                return null;
            }
        };
    }
}
