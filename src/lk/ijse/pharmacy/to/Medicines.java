package lk.ijse.pharmacy.to;

import java.sql.Date;

public class Medicines {
      private String medi_code;
      private String name;
      private String brand;
      private String M_Date;
      private String Ex_Date;
      private int quantity;
     private int unit_price;

    public Medicines(String medi_code, String name, String brand, String m_Date, String ex_Date, int quantity , int unit_price) {
        this.medi_code = medi_code;
        this.name = name;
        this.brand = brand;
        this.M_Date = m_Date;
        this.Ex_Date = ex_Date;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public Medicines() {

    }


    public String getMedi_code() {
        return medi_code;
    }

    public void setMedi_code(String medi_code) {
        this.medi_code = medi_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getM_Date() {
        return M_Date;
    }

    public void setM_Date(String m_Date) {
        M_Date = m_Date;
    }

    public String getEx_Date() {
        return Ex_Date;
    }

    public void setEx_Date(String ex_Date) {
        Ex_Date = ex_Date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }
}
