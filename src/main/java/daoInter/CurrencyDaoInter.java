package daoInter;

import entity.Currencies;

public interface CurrencyDaoInter {
    Double getValueByCurrencyAndDate(Double azn, String currency, String date);

    boolean addNewCurrency(Currencies currencies);

}

