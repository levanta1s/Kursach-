package tableModels;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import depositclient.entity.Contract;

public class ContractsTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<>();
    private List<Contract> clients;

    public ContractsTableModel(List<Contract> clients) {
        this.clients = clients;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Номер контракта";
            case 1:
                return "Дата подписания";
            case 2:
                return "ID клиента";
            case 3:
                return "ID сотрудника";
        }
        return "";
    }

    public int getRowCount() {
        return clients.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Contract client = clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.getContractNumber();
            case 1:
                return client.getDateOfSigning();
            case 2:
                return client.getClientID();
            case 3:
                return client.getEmployeeID();
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
