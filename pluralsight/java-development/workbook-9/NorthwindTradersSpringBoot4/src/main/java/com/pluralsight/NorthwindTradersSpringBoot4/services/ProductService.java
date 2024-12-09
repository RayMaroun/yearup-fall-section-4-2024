package com.pluralsight.NorthwindTradersSpringBoot4.services;


import com.pluralsight.NorthwindTradersSpringBoot4.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersSpringBoot4.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private final IProductDao productDao;

    @Autowired
    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(Product product) {
        return productDao.insert(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public Product getProductById(int productId) {
        return productDao.getById(productId);
    }

    public void updateProduct(int productId, Product product) {
        productDao.update(productId, product);
    }

    public void deleteProduct(int productId) {
        productDao.delete(productId);
    }
}
