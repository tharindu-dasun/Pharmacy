package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Sponsor;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SponsorModel {

    public static ArrayList<String> loadType() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT DISTINCT Type FROM  sponsor ");
        ArrayList<String> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(rst.getString("Type"));
        }
        return arrayList;
    }

    public static boolean save(Sponsor sponsor) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("INSERT INTO  sponsor VALUES (?, ?, ?, ? , ? ,?)",
                        sponsor.getSponsor_id(),
                        sponsor.getName(),
                        sponsor.getContact_no(),
                        sponsor.getEmail(),
                        sponsor.getDiscount_percentage(),
                        sponsor.getType()
                );
    }

    public static boolean update(Sponsor sponsor) throws SQLException, ClassNotFoundException {
        return CrudUtil.
                execute("UPDATE sponsor SET name = ? , contact_no = ? , Email = ? , discount_percentage = ? , Type = ? , WHERE sponsor_id = ?",
                        sponsor.getName(),
                        sponsor.getContact_no(),
                        sponsor.getEmail(),
                        sponsor.getDiscount_percentage(),
                        sponsor.getType(),
                        sponsor.getSponsor_id()
                );
    }

    public static ArrayList<Sponsor> getList() throws SQLException, ClassNotFoundException {
        ArrayList<Sponsor> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM sponsor");
        while (rst.next()) {
            Sponsor sponsor = new Sponsor(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6)) {

                @Override
                public Object get() {
                    return null;
                }
            };
            arrayList.add(sponsor);
        }
        return arrayList;
    }

    public static Sponsor search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM sponsor WHERE sponsor_id = ?", id);
        if (rst.next()) {
            return new Sponsor(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6)) {
                @Override
                public Object get() {
                    return null;
                }
            };
        }
        return new Sponsor() {
            @Override
            public Object get() {
                return null;
            }
        };
    }
}

