package depositclient.entity;

public class Client {
    private int clientID;
    private String login;
    private String password;
    private String fullName;
    private String passport;
    private String phoneNumber;
    private String address;

    public Client(){

    }

    public Client(int clientID, String login, String password, String fullName, String passport, String phoneNumber, String address) {
        this.setClientID(clientID);
        this.setFullName(fullName);
        this.setLogin(login);
        this.setPassword(password);
        this.setPassport(passport);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(address);

    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClientID() {
        return this.clientID;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPassport() {
        return this.passport;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }
}
