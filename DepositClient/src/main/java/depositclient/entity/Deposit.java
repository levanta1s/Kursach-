package depositclient.entity;

public class Deposit {
    private int depositNumber;
    private int initialMoney;
    private String dateOfOpening;
    private int plannedFinalAmountOfMoney;
    private int typeOfDeposit;
    private int contractNumber;
    private int clientID;

    public Deposit(){

    }

    public Deposit(int num, int initialMoney, String date, int finalMoney, int type, int contractNum, int clientId) {
        this.setDepositNumber(num);
        this.setInitialMoney(initialMoney);
        this.setDateOfOpening(date);
        this.setPlannedMoney(finalMoney);
        this.setTypeOfDeposit(type);
        this.setContractNumber(contractNum);
        this.setClientId(clientId);
    }

    public void setDepositNumber(int number) {
        this.depositNumber = number;
    }

    public int getDepositNumber() {
        return this.depositNumber;
    }

    public void setInitialMoney(int initialMoney) {
        this.initialMoney = initialMoney;
    }

    public int getInitialAmountOfMoney() {
        return this.initialMoney;
    }

    public void setDateOfOpening(String date) {
        this.dateOfOpening = date;
    }

    public String getDateOfOpening() {
        return this.dateOfOpening;
    }

    public void setPlannedMoney(int plannedMoney) {
        this.plannedFinalAmountOfMoney = plannedMoney;
    }

    public int getFinalAmountOfMoney() {
        return this.plannedFinalAmountOfMoney;
    }

    public void setTypeOfDeposit(int type) {
        this.typeOfDeposit = type;
    }

    public int getTypeOfDeposit() {
        return this.typeOfDeposit;
    }

    public void setContractNumber(int number) {
        this.contractNumber = number;
    }

    public int getContractNumber() {
        return this.contractNumber;
    }

    public void setClientId(int id) {
        this.clientID = id;
    }

    public int getClientID() {
        return this.clientID;
    }

}
