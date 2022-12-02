package lk.ijse.pharmacy.to;

public class OrderTable {
    private String code;
    private String description;
    private int QtyOnHand;
    private int unitPrice;
    private String M_date;
    private String Ex_date;
    private int total;

    public OrderTable(String code, String description, int qtyOnHand, int unitPrice, String m_date, String ex_date, int total) {
        this.code = code;
        this.description = description;
        QtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        M_date = m_date;
        Ex_date = ex_date;
        this.total = total;
    }



    public OrderTable(){

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

    public int getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getM_date() {
        return M_date;
    }

    public void setM_date(String m_date) {
        M_date = m_date;
    }

    public String getEx_date() {
        return Ex_date;
    }

    public void setEx_date(String ex_date) {
        Ex_date = ex_date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
