package lk.ijse.pharmacy.to;

public class Employee {
    private String employee_id;
    private String name;
    private String address;
    private int contact_no;
    private String nic;
    private String role;

    public Employee(String employee_id, String name, String address, int contact_no, String nic, String role) {
        this.setEmployee_id(employee_id);
        this.setName(name);
        this.setAddress(address);
        this.setContact_no(contact_no);
        this.setNic(nic);
        this.setRole(role);
    }

    public Employee() {
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
