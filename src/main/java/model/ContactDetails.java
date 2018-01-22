package model;

public class ContactDetails {
    String name;
    String email;
    String country;
    String mobile;
    String address;

    public ContactDetails(String name, String email, String country, String mobile, String address) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.mobile = mobile;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }
}