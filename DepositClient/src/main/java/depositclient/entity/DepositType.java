package depositclient.entity;

public class DepositType {
    private int typeID;
    private String typeName;
    private int minMoney;
    private int maxMoney;
    private int period;
    private int capitalization;
    private int percent;

    public DepositType(){

    }

    public DepositType(int type, String name, int minMoney, int maxMoney, int period, int capitalization, int percent) {
        this.setTypeID(type);
        this.setTypeName(name);
        this.setMinMoney(minMoney);
        this.setMaxMoney(maxMoney);
        this.setPeriod(period);
        this.setCapitalization(capitalization);
        this.setPercent(percent);
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(int minMoney) {
        this.minMoney = minMoney;
    }

    public int getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(int capitalization) {
        this.capitalization = capitalization;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
