package lk.ijse.pharmacy.to;

public abstract class Sponsor {
    private String sponsor_id;
    private String name;
    private int contact_no;
    private String Email;
    private String discount_percentage;
    private String Type;

    public Sponsor(String sponsor_id, String name, int contact_no, String email, String discount_percentage, String type) {
        this.setSponsor_id(sponsor_id);
        this.setName(name);
        this.setContact_no(contact_no);
        setEmail(email);
        this.setDiscount_percentage(discount_percentage);
        setType(type);
    }

    public Sponsor() {

    }

    public String getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(String sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(String discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public abstract Object get();
}
