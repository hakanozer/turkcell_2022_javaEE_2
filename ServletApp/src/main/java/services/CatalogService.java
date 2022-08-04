package services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import props.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogService {

    public List<Catalog> allCatalog() {
        List<Catalog> ls = new ArrayList<>();
        try {
            String url = "https://www.w3schools.com/xml/plant_catalog.xml";
            String xmlData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document document = Jsoup.parse(xmlData, Parser.xmlParser());
            Elements elements = document.getElementsByTag("PLANT");
            for (Element item : elements) {
                String COMMON = item.getElementsByTag("COMMON").text();
                String BOTANICAL = item.getElementsByTag("BOTANICAL").text();
                String ZONE = item.getElementsByTag("ZONE").text();
                String LIGHT = item.getElementsByTag("LIGHT").text();
                String PRICE = item.getElementsByTag("PRICE").text();

                Catalog catalog = new Catalog( COMMON,BOTANICAL, ZONE, LIGHT, PRICE );
                ls.add(catalog);
            }
        }catch (Exception ex) {
            System.err.println("allCatalog Error : " + ex);
        }

        return ls;
    }

}
