package depositclient.entity;

public class Employee {
    private int employeeID;
    private String employeeLogin;
    private String employeePassword;
    private String employeeFullName;
    private int contractNumber;
    private String dateOfRecruitment;
    private int position;

    public Employee(){

    }

    public Employee(int employeeID, String employeeLogin, String employeePassword,
                    String employeeFullName, int contractNumber, String dateOfRecruitment, int position) {
        this.setEmployeeID(employeeID);
        this.setFullName(employeeFullName);
        this.setLogin(employeeLogin);
        this.setPassword(employeePassword);
        this.setContractNumber(contractNumber);
        this.setDateOfRecruitment(dateOfRecruitment);
        this.setPosition(position);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getLogin() {
        return employeeLogin;
    }

    public void setLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public String getPassword() {
        return employeePassword;
    }

    public void setPassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getFullName() {
        return employeeFullName;
    }

    public void setFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getDateOfRecruitment() {
        return dateOfRecruitment;
    }

    public void setDateOfRecruitment(String dateOfRecruitment) {
        this.dateOfRecruitment = dateOfRecruitment;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
