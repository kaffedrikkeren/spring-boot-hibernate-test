package ormtest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ormtest.dao.ProductDao;

import java.util.List;

/**
 * Created by amo on 12.04.18.
 */
@Service
public class ProductServiceImpl {

  @Autowired
  private ProductDao productDao;

  public List getProducts() {
    return productDao.getProducts();
  }

}
