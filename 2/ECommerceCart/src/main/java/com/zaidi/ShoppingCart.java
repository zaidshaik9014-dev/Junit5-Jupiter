package com.zaidi;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getItemCount() {
        return products.size();
    }

    public double getTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

}