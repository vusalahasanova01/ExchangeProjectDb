package readByXml;

import daoImpl.CurrencyDaoImpl;
import entity.Currencies;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlUtility {

    static CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();

    public static void ReadXml(Double money, String currency, String day, String month, String year) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            String date = day + "." + month + "." + year;
            Document document = builder.parse("https://www.cbar.az/currencies/" + date + ".xml");
            read(document, money, currency, day, month, year);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void read(Document document, double azn, String currency, String day, String month, String year) throws Exception {

        String rootTag = document.getDocumentElement().getTagName();
        System.out.println("root tag: " + rootTag);

        NodeList nodeList = document.getElementsByTagName("Valute");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element el = (Element) nodeList.item(i);


            String code = el.getAttribute("Code");
            if (code.equals(currency)) {
                Currencies currencies;
                String nominal = el.getElementsByTagName("Nominal").item(0).getTextContent();
                String name = el.getElementsByTagName("Name").item(0).getTextContent();
                String value = el.getElementsByTagName("Value").item(0).getTextContent();
                double valueDouble = Double.parseDouble(value);
                System.out.println("nominal: " + nominal);
                System.out.println("name: " + name);
                System.out.println("value:" + value);
                System.out.println("answer:" + azn / valueDouble);
                currencies = new Currencies(code, nominal, name, value, day, month, year);
                currencyDao.addNewCurrency(currencies);
            }
        }

    }

}
