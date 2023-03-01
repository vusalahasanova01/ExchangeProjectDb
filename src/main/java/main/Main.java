package main;

import util.ScannerUtil;

public class Main {
    public static void main(String[] args) {

        String dayOfDate = ScannerUtil.acceptString("Enter day: ");
        String monthOfDate = ScannerUtil.acceptString("Enter month: ");
        String yearOfDate = ScannerUtil.acceptString("Enter year: ");

        double money = ScannerUtil.acceptDouble("Enter value for exchange: ");
        String currency = ScannerUtil.acceptString("Enter currency: ").toUpperCase();
        ScannerUtil.checkData(money, currency, dayOfDate, monthOfDate, yearOfDate);
    }

}
