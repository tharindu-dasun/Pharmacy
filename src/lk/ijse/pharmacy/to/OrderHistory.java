package lk.ijse.pharmacy.to;

public class OrderHistory {
     private String order_id;
     private String code;
     private String sponsor_id;
     private String employee_id;
     private int unit_price;
     private int quantity;

    public OrderHistory(String order_id, String code, String sponsor_id, String employee_id, int unit_price, int quantity) {
        this.order_id = order_id;
        this.code = code;
        this.sponsor_id = sponsor_id;
        this.employee_id = employee_id;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(String sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getUnitPrice() {
        return unit_price;
    }

    public void setUnitPrice(int unitPrice) {
        this.unit_price = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
