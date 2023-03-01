package util;

import daoImpl.CurrencyDaoImpl;
import readByXml.XmlUtility;

import java.util.Scanner;

public class ScannerUtil {

    static CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();

    public static String acceptString(String question) {
        System.out.println(question);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Double acceptDouble(String question) {
        System.out.println(question);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }


    public static void checkData(Double money, String currency, String day, String month, String year) {
        String date = year + "-" + month + "-" + day;
        if (currencyDao.getValueByCurrencyAndDate(money, currency, date) != null) {
            Double value = currencyDao.getValueByCurrencyAndDate(money, currency, date);
            System.out.println(value);
        } else {
           // String dateForXml = day + "." + month + "." + year;
            XmlUtility.ReadXml(money, currency, day, month, year);
        }

    }

}
