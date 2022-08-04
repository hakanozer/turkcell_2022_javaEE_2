package services;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import props.Bilgiler;
import props.ProductData;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Bilgiler> allProduct() {
        List<Bilgiler> ls = new ArrayList<>();
        try {
            String url = "https://www.jsonbulut.com/json/product.php?ref=d1becef32825e5c8b0fc1b096230400b&start=0";
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().body().text();

            Gson gson = new Gson();
            ProductData pro = gson.fromJson( stData, ProductData.class );
            ls = pro.getProducts().get(0).getBilgiler();

        }catch (Exception ex) {
            System.err.println("allProduct error : " + ex);
        }
        return ls;
    }

}
