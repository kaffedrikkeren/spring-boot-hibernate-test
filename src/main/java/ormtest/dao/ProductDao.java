package ormtest.dao;

import ormtest.models.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

}
