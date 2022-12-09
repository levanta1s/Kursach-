package depositclient.builder.implementation;

import depositclient.builder.ContractBuilderInterface;
import depositclient.entity.Contract;

public class ContractBuilder implements ContractBuilderInterface {
    private Contract contract;

    public ContractBuilder() {
        contract = new Contract();
    }

    @Override
    public ContractBuilderInterface buildContractNumber(int contractNumber) {
        contract.setContractNumber(contractNumber);
        return this;
    }

    @Override
    public ContractBuilderInterface buildDateOfSigning(String dateOfSigning) {
        contract.setDateOfSigning(dateOfSigning);
        return this;
    }

    @Override
    public ContractBuilderInterface buildClientID(int clientID) {
        contract.setClientID(clientID);
        return this;
    }

    @Override
    public ContractBuilderInterface buildEmployeeID(int employeeID) {
        contract.setEmployeeID(employeeID);
        return this;
    }

    @Override
    public Contract build() {
        return contract;
    }
}
