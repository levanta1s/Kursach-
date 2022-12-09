package depositclient.entity;

public class Contract {
    private int contractNumber;
    private String dateOfSigning;
    private int clientID;
    private int employeeID;

    public Contract(){

    }

    public Contract(int number, String date, int client, int employee) {
        this.setClientID(client);
        this.setContractNumber(number);
        this.setDateOfSigning(date);
        this.setEmployeeID(employee);
    }


    public void setContractNumber(int number) {
        this.contractNumber = number;
    }

    public void setDateOfSigning(String date) {
        this.dateOfSigning = date;
    }

    public void setClientID(int cid) {
        this.clientID = cid;
    }

    public void setEmployeeID(int eid) {
        this.employeeID = eid;
    }

    public int getContractNumber() {
        return this.contractNumber;
    }

    public String getDateOfSigning() {
        return this.dateOfSigning;
    }

    public int getClientID() {
        return this.clientID;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }
}
