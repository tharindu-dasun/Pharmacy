package lk.ijse.pharmacy.to;

public class SupOrder {
    private String code;
    private String description;
    private int unitPrice;
    private int quantity;
    private int total;
    private String order_id;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String employee_id;
    private String supplier_id;
    private String date;

    public SupOrder(String code, String description, int unitPrice, int quantity, int total , String order_id , String employee_id , String supplier_id , String date) {

        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.total = total;
        this.order_id = order_id;
        this.employee_id = employee_id;
        this.supplier_id = supplier_id;
        this.date = date;
    }

    public SupOrder(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
