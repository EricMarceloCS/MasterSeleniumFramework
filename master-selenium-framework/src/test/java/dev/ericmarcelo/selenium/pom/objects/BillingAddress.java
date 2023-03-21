package dev.ericmarcelo.selenium.pom.objects;

public class BillingAddress {
    private String firstName;
    private String lastName;
    private String country;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String email;
    private String username;
    private String password;

    public String getCountry() {
        return country;
    }

    public BillingAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getState() {
        return state;
    }

    public BillingAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public BillingAddress setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public BillingAddress setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public BillingAddress setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public BillingAddress setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
