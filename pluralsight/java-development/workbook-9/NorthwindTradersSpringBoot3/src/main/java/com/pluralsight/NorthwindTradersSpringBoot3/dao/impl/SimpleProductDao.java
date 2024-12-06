package com.pluralsight.NorthwindTradersSpringBoot3.dao.impl;



import com.pluralsight.NorthwindTradersSpringBoot3.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersSpringBoot3.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements IProductDao {
    private List<Product> products;

    public SimpleProductDao() {
        this.products = new ArrayList<>();
        // Add some initial products
        products.add(new Product(1, "Mountain Dew", 1, 1.50));
        products.add(new Product(2, "Cheddar", 4, 5.50));
        products.add(new Product(3, "Steak", 6, 20.50));
    }

    @Override
    public Product insert(Product product) {
        int maxId = 0;
        for (Product t : products) {
            if (t.getProductId() > maxId) {
                maxId = t.getProductId();
            }
        }
        product.setProductId(maxId + 1); // Increment max ID by 1
        products.add(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int productId, Product product) {
        int index = getProductIndex(productId);
        if (index != -1) {
            products.set(index, product);
        }
    }

    @Override
    public void delete(int productId) {
        int index = getProductIndex(productId);
        if (index != -1) {
            products.remove(index);
        }
    }

    private int getProductIndex(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }
}
