package depositclient.builder;

import depositclient.entity.DepositType;

public interface DepositTypeBuilderInterface {
    DepositTypeBuilderInterface buildId(int id);
    DepositTypeBuilderInterface buildName(String typeName);
    DepositTypeBuilderInterface buildMinMoney(int minMoney);
    DepositTypeBuilderInterface buildMaxMoney(int maxMoney);
    DepositTypeBuilderInterface buildPeriod(int period);
    DepositTypeBuilderInterface buildCapitalization(int capitalization);
    DepositTypeBuilderInterface buildPercent(int percent);
    DepositType build();
}
