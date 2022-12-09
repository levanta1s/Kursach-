package tableModels;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import depositclient.entity.DepositType;

public class DepositTypesTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<>();
    private List<DepositType> deposittypes;

    public DepositTypesTableModel(List<DepositType> deposittypes) {
        this.deposittypes = deposittypes;
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
                return "ID типа";
            case 1:
                return "Название";
            case 2:
                return "Минимальная сумма";
            case 3:
                return "Максимальная сумма";
            case 4:
                return "Период";
            case 5:
                return "Капитализация";
            case 6:
                return "Ставка процента";
        }
        return "";
    }

    public int getRowCount() {
        return deposittypes.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        DepositType depType = deposittypes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return depType.getTypeID();
            case 1:
                return depType.getTypeName();
            case 2:
                return depType.getMinMoney();
            case 3:
                return depType.getMaxMoney();
            case 4:
                return depType.getPeriod();
            case 5:
                return depType.getCapitalization();
            case 6:
                return depType.getPercent();
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
