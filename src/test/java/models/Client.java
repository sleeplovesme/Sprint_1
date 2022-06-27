package models;

public class Client {
    // поля
    private String name;
    private String surname;
    private String address;
    private String nameMetro;
    private String phoneNumber;
    private String orderDate;
    private String comment;
    // конструктор
    public Client(String newName, String newSurname, String newAddress, String newNameMetro,
           String newPhoneNumber, String newOrderDate,String newComment) {
        name = newName;
        surname = newSurname;
        address = newAddress;
        nameMetro = newNameMetro;
        phoneNumber = newPhoneNumber;
        orderDate = newOrderDate;
        comment = newComment;
    }
    // геттеры
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getAddress() {
        return address;
    }
    public String getNameMetro() {
        return nameMetro;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public String getComment() {
        return comment;
    }
}
