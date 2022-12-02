package lk.ijse.pharmacy.to;

public class CusOrder {
    private String order_id;

    private String sponsor_id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String employee_id;
    private String customer_id;
    private int unit_price;
    private String date;

    public CusOrder(String order_id, String item_code, String sponsor_id, String employee_id, String customer_id, String date, int unit_price, int quantity) {
        this.order_id = order_id;
        this.code = item_code;
        this.sponsor_id = sponsor_id;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.date = date;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    public CusOrder() {

    }
    private int quantity;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
