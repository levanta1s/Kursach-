package depositclient.builder.implementation;

import depositclient.builder.DepositTypeBuilderInterface;
import depositclient.entity.DepositType;

public class DepositTypeBuilder implements DepositTypeBuilderInterface {
    private DepositType depositType;

    public DepositTypeBuilder() {
        depositType = new DepositType();
    }

    @Override
    public DepositTypeBuilderInterface buildId(int id) {
        depositType.setTypeID(id);
        return this;
    }

    @Override
    public DepositTypeBuilderInterface buildName(String typeName) {
        depositType.setTypeName(typeName);
        return this;
    }

    @Override
    public DepositTypeBuilderInterface buildMinMoney(int minMoney) {
        depositType.setMinMoney(minMoney);
        return this;
    }

    @Override
    public DepositTypeBuilderInterface buildMaxMoney(int maxMoney) {
        depositType.setMaxMoney(maxMoney);
        return this;
    }

    @Override
    public DepositTypeBuilderInterface buildPeriod(int period) {
        depositType.setPeriod(period);
        return this;
    }

    @Override
    public DepositTypeBuilderInterface buildCapitalization(int capitalization) {
        depositType.setCapitalization(capitalization);
        return this;
    }

    @Override
    public DepositTypeBuilderInterface buildPercent(int percent) {
        depositType.setPercent(percent);
        return this;
    }

    @Override
    public DepositType build() {
        return depositType;
    }
}
