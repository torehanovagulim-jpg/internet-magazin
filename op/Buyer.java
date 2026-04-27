public class Buyer {
    private String name;
    private String phone;
    private String city;
    private String address;

    public Buyer(String name, String phone, String city, String address) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.address = address;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public String getAddress() { return address; }
}
