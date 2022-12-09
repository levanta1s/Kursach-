package tableModels;

import depositclient.entity.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class EmployeesTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<>();
    private List<Employee> employees;

    public EmployeesTableModel(List<Employee> employees) {
        this.employees = employees;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 7;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Логин";
            case 2:
                return "Пароль";
            case 3:
                return "ФИО";
            case 4:
                return "Номер контракта";
            case 5:
                return "Дата найма";
            case 6:
                return "Позиция";

        }
        return "";
    }

    public int getRowCount() {
        return employees.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.getEmployeeID();
            case 1:
                return employee.getLogin();
            case 2:
                return employee.getPassword();
            case 3:
                return employee.getFullName();
            case 4:
                return employee.getContractNumber();
            case 5:
                return employee.getDateOfRecruitment();
            case 6:
                return employee.getPosition();
        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

}
