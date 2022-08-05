package com.works.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "productBean")
@RequestScoped
public class ProductBean {

    public List<Product> result() {
        List<Product> ls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product p = new Product();
            p.setPrice(i * 5);
            p.setTitle("Title-"+i);
            ls.add(p);
        }
        return ls;
    }

}
