package depositclient.builder.implementation;

import depositclient.builder.DepositBuilderInterface;
import depositclient.entity.Deposit;

public class DepositBuilder implements DepositBuilderInterface {
    private Deposit deposit;

    public DepositBuilder() {
        deposit = new Deposit();
    }

    @Override
    public DepositBuilderInterface buildNumber(int depositNumber) {
        deposit.setDepositNumber(depositNumber);
        return this;
    }

    @Override
    public DepositBuilderInterface buildInitialMoney(int initialMoney) {
        deposit.setInitialMoney(initialMoney);
        return this;
    }

    @Override
    public DepositBuilderInterface buildDateOfOpening(String dateOfOpening) {
        deposit.setDateOfOpening(dateOfOpening);
        return this;
    }

    @Override
    public DepositBuilderInterface buildPlannedAmountOfMoney(int plannedAmountOfMoney) {
        deposit.setPlannedMoney(plannedAmountOfMoney);
        return this;
    }

    @Override
    public DepositBuilderInterface buildTypeOfDeposit(int typeOfDeposit) {
        deposit.setTypeOfDeposit(typeOfDeposit);
        return this;
    }

    @Override
    public DepositBuilderInterface buildContractNumber(int contractNumber) {
        deposit.setContractNumber(contractNumber);
        return this;
    }

    @Override
    public DepositBuilderInterface buildClientId(int clientID) {
        deposit.setClientId(clientID);
        return this;
    }

    @Override
    public Deposit build() {
        return deposit;
    }
}
