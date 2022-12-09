package tableModels;

import depositclient.entity.Client;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ClientsTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<>();
    private List<Client> clients;

    public ClientsTableModel(List<Client> clients) {
        this.clients = clients;
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
                return "Паспорт";
            case 5:
                return "Телефон";
            case 6:
                return "Адрес";

        }
        return "";
    }

    public int getRowCount() {
        return clients.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.getClientID();
            case 1:
                return client.getLogin();
            case 2:
                return client.getPassword();
            case 3:
                return client.getFullName();
            case 4:
                return client.getPassport();
            case 5:
                return client.getPhoneNumber();
            case 6:
                return client.getAddress();
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
