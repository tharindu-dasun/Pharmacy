package lk.ijse.pharmacy.to;

import java.util.Date;

public class Item {
    private String item_code;
    private String description;
    private String brand;
  //  private String M_date;
    private String M_Date;
    private String Ex_Date;
    private int quantity;

    public Item(String item_code, String description, String brand, String m_date, String ex_Date, int quantity, int unit_price) {
        this.item_code = item_code;
        this.description = description;
        this.brand = brand;
        this.M_Date = m_date;
        this.Ex_Date = ex_Date;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    private int unit_price;

    public Item() {

    }


    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setM_Date(String m_date) {
        M_Date = m_date;
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
