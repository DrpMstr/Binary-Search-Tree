package BSTBackground;
public class InfoNode {
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String city;
    protected String zipCode;
    protected String email;
    protected String phoneNumber;
    protected InfoNode left;
    protected InfoNode right;
    protected int key;

    public InfoNode(int key, String firstName, String lastName, String address, String city, String zipCode, String email, String phoneNumber) {
        this(key, firstName, lastName, address, city, zipCode, email, phoneNumber, null, null);
    }

    public InfoNode(int key, String firstName, String lastName, String address, String city, String zipCode, String email, String phoneNumber, InfoNode left, InfoNode right)  {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.left = left;
        this.right = right;

    }
}