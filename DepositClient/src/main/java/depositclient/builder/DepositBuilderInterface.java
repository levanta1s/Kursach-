package depositclient.builder;

import depositclient.entity.Deposit;

public interface DepositBuilderInterface {
    DepositBuilderInterface buildNumber(int depositNumber);
    DepositBuilderInterface buildInitialMoney(int initialMoney);
    DepositBuilderInterface buildDateOfOpening(String dateOfOpening);
    DepositBuilderInterface buildPlannedAmountOfMoney(int plannedAmountOfMoney);
    DepositBuilderInterface buildTypeOfDeposit(int typeOfDeposit);
    DepositBuilderInterface buildContractNumber(int contractNumber);
    DepositBuilderInterface buildClientId(int clientID);
    Deposit build();
}
