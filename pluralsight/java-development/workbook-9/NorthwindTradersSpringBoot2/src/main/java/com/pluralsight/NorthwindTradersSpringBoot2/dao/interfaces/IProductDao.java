package com.pluralsight.NorthwindTradersSpringBoot2.dao.interfaces;



import com.pluralsight.NorthwindTradersSpringBoot2.models.Product;

import java.util.List;

public interface IProductDao {
    Product insert(Product product);

    List<Product> getAll();

    Product getById(int productId);

    void update(int productId, Product product);

    void delete(int productId);
}
