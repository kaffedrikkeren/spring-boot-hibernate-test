package ormtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ormtest.services.ProductServiceImpl;
import java.util.List;

/**
 * Created by amo on 12.04.18.
 */
public class ProductController {

  @Autowired
  private ProductServiceImpl productService;

  @RequestMapping(value = "/products", method = RequestMethod.GET)
  public ResponseEntity> products() {

    List products = productService.getProducts();
    return new ResponseEntity>(products, HttpStatus.OK);
  }


}
