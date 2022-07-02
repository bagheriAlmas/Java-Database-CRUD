package ir.almasapps.javadatabasesqlitecrud.Database.Model;

public class Contact {
    private int id;
    private String name;
    private String phone;
    private String email;
    private int image;

    public Contact() {
    }

    public Contact(String name, String phone, String email, int image) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public Contact(int id, String name, String phone, String email, int image) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
