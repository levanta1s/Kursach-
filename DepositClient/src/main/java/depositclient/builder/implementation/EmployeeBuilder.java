package depositclient.builder.implementation;

import depositclient.entity.Employee;

public class EmployeeBuilder implements depositclient.builder.EmployeeBuilderInterface {
    private Employee employee;

    public EmployeeBuilder() {
        employee = new Employee();
    }

    @Override
    public EmployeeBuilder buildId(int id) {
        employee.setEmployeeID(id);
        return this;
    }

    @Override
    public EmployeeBuilder buildLogin(String login) {
        employee.setLogin(login);
        return this;
    }

    @Override
    public EmployeeBuilder buildPassword(String password) {
        employee.setPassword(password);
        return this;
    }

    @Override
    public EmployeeBuilder buildFullName(String fullName) {
        employee.setFullName(fullName);
        return this;
    }

    @Override
    public EmployeeBuilder buildContractNumber(int number) {
        employee.setContractNumber(number);
        return this;
    }

    @Override
    public EmployeeBuilder buildDateOfRecruitment(String date) {
        employee.setDateOfRecruitment(date);
        return this;
    }

    @Override
    public EmployeeBuilder buildPosition(int position) {
        employee.setPosition(position);
        return this;
    }

    @Override
    public Employee build() {
        return employee;
    }
}