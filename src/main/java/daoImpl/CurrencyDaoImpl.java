package daoImpl;

import daoInter.AbstractDao;
import daoInter.CurrencyDaoInter;
import entity.Currencies;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class CurrencyDaoImpl extends AbstractDao implements CurrencyDaoInter {
    @Override
    public Double getValueByCurrencyAndDate(Double azn, String currency, String date) {
        Double valueDouble;

        try (PreparedStatement st = connection().prepareStatement("SELECT"
                + " value,"
                + " nominal,"
                + " name"
                + " FROM"
                + " task_exchange_rate.currencies"
                + " where valute_code=? AND currency_date=?")) {
            st.setString(1, currency);
            st.setString(2, date);
            st.execute();
            ResultSet rs = st.getResultSet();


            while (rs.next()) {
                String stringValue = rs.getString("value");
                String name = rs.getString("name");
                String nominal = rs.getString("nominal");
                valueDouble = Double.parseDouble(stringValue);
                System.out.println("nominal: " + nominal);
                System.out.println("name: " + name);
                return azn / valueDouble;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean addNewCurrency(Currencies currencies) {

        try (PreparedStatement st = connection().prepareStatement("insert into task_exchange_rate.currencies(" +
                " valute_code," +
                " nominal," +
                " name," +
                " value," +
                " currency_date) " +
                " values (?,?,?,?,?)")) {
            st.setString(1, currencies.getValuteCode());
            st.setString(2, currencies.getNominal());
            st.setString(3, currencies.getName());
            st.setString(4, currencies.getValue());
            st.setDate(5, Date.valueOf(currencies.getCurrencyDate()));
            return st.execute();



        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

}
