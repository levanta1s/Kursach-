package depositclient.builder;

import depositclient.entity.Client;

public interface ClientBuilderInterface {
    ClientBuilderInterface buildClientId(int clientID);
    ClientBuilderInterface buildLogin(String login);
    ClientBuilderInterface buildPassword(String password);
    ClientBuilderInterface buildFullName(String fullName);
    ClientBuilderInterface buildPassport(String passport);
    ClientBuilderInterface buildPhoneNumber(String phoneNumber);
    ClientBuilderInterface buildAddress(String address);
    Client build();
}
