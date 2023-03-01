package entity;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Currencies {
    private int id;
    private String valuteCode;
    private String nominal;
    private String name;
    private String value;
    private LocalDate currencyDate;

    public Currencies(int id, String valuteCode, String nominal, String name, String value, String day, String month, String year) throws ParseException {
        this.id = id;
        this.valuteCode = valuteCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        String stringDate = year + "-" + month + "-" + day;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //LocalDate date = formatter.parse(stringDate);
        this.currencyDate = date;
    }

    public Currencies(String valuteCode, String nominal, String name, String value, String day, String month, String year) throws ParseException {
        this.valuteCode = valuteCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        String stringDate = year + "-" + month + "-" + day;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        // Date date = (Date) formatter.parse(stringDate);
        this.currencyDate = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValuteCode() {
        return valuteCode;
    }

    public void setValuteCode(String valuteCode) {
        this.valuteCode = valuteCode;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getCurrencyDate() {
        return currencyDate;
    }

    public void setCurrencyDate(LocalDate currencyDate) {
        this.currencyDate = currencyDate;
    }
}
