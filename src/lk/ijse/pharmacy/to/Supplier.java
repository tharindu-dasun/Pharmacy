package lk.ijse.pharmacy.to;

public abstract class Supplier {
    private String supplier_id;
    private String name;
    private String company;
    private int contact_no;
    private String Email;
    private String Agreement;

    public Supplier(String supplier_id, String name, String company, int contact_no, String email, String agreement) {
        this.supplier_id = supplier_id;
        this.name = name;
        this.company = company;
        this.contact_no = contact_no;
        Email = email;
        Agreement = agreement;
    }

    public Supplier() {
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAgreement() {
        return Agreement;
    }

    public void setAgreement(String agreement) {
        this.Agreement = Agreement;
    }

    public abstract Object get();
}
