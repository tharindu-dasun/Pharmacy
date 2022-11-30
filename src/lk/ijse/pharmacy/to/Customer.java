package lk.ijse.pharmacy.to;

public class Customer {
    private String customer_id;
    private String name;
    private String address;
    private int contact_no;

    public Customer(String customer_id, String name, String address, int contact_no, String nic) {
        this.setCustomer_id(customer_id);
        this.setName(name);
        this.setAddress(address);
        this.setContact_no(contact_no);
        this.setNic(nic);
    }

    public Customer() {
    }

    private String nic;


    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
