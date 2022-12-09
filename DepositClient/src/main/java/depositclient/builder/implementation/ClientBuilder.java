package depositclient.builder.implementation;

import depositclient.builder.ClientBuilderInterface;
import depositclient.entity.Client;

public class ClientBuilder implements ClientBuilderInterface {
    private Client client;

    public ClientBuilder() {
        client = new Client();
    }

    @Override
    public ClientBuilderInterface buildClientId(int clientID) {
        client.setClientID(clientID);
        return this;
    }

    @Override
    public ClientBuilderInterface buildLogin(String login) {
        client.setLogin(login);
        return this;
    }

    @Override
    public ClientBuilderInterface buildPassword(String password) {
        client.setPassword(password);
        return this;
    }

    @Override
    public ClientBuilderInterface buildFullName(String fullName) {
        client.setFullName(fullName);
        return this;
    }

    @Override
    public ClientBuilderInterface buildPassport(String passport) {
        client.setPassport(passport);
        return this;
    }

    @Override
    public ClientBuilderInterface buildPhoneNumber(String phoneNumber) {
        client.setPhoneNumber(phoneNumber);
        return this;
    }

    @Override
    public ClientBuilderInterface buildAddress(String address) {
        client.setAddress(address);
        return this;
    }

    @Override
    public Client build() {
        return client;
    }
}
