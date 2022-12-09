package depositclient.builder;

import depositclient.entity.Employee;

public interface EmployeeBuilderInterface {
    EmployeeBuilderInterface buildId(int id);
    EmployeeBuilderInterface buildLogin(String login);
    EmployeeBuilderInterface buildPassword(String password);
    EmployeeBuilderInterface buildFullName(String fullName);
    EmployeeBuilderInterface buildContractNumber(int number);
    EmployeeBuilderInterface buildDateOfRecruitment(String date);
    EmployeeBuilderInterface buildPosition(int position);
    Employee build();
}
