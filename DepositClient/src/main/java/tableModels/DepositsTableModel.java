package tableModels;

import depositclient.entity.Deposit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class DepositsTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<>();
    private List<Deposit> deposits;

    public DepositsTableModel(List<Deposit> deposits) {
        this.deposits = deposits;
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
                return "Номер вклада";
            case 1:
                return "Начальная сумма";
            case 2:
                return "Дата открытия";
            case 3:
                return "Конечная сумма";
            case 4:
                return "Номер типа вклада";
            case 5:
                return "Номер контракта";
            case 6:
                return "ID клиента";

        }
        return "";
    }

    public int getRowCount() {
        return deposits.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Deposit client = deposits.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.getDepositNumber();
            case 1:
                return client.getInitialAmountOfMoney();
            case 2:
                return client.getDateOfOpening();
            case 3:
                return client.getFinalAmountOfMoney();
            case 4:
                return client.getTypeOfDeposit();
            case 5:
                return client.getContractNumber();
            case 6:
                return client.getClientID();
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
