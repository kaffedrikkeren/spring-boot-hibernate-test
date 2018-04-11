package models;

import java.util.List;

public interface ProductDao {

    long save(Product product);
    Product get(long id);
    List<Product> list();
    void update(long id, Product product);
    void delete(long id);

}
