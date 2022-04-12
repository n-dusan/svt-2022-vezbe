package rs.ac.uns.ftn.svtvezbe05.service;

import rs.ac.uns.ftn.svtvezbe05.model.entity.Product;

import java.util.List;

public interface ProductService {

    Product findOne(Integer productId);

    List<Product> findAll();

    Product save(Product product);

    void remove(Integer id);

}
