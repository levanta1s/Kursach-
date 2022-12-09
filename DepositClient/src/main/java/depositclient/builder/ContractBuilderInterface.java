package depositclient.builder;

import depositclient.entity.Contract;

public interface ContractBuilderInterface {
    ContractBuilderInterface buildContractNumber(int contractNumber);
    ContractBuilderInterface buildDateOfSigning(String dateOfSigning);
    ContractBuilderInterface buildClientID(int clientID);
    ContractBuilderInterface buildEmployeeID(int employeeID);
    Contract build();
}
