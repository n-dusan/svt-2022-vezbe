package rs.ac.uns.ftn.svtvezbe05.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe05.model.entity.Product;
import rs.ac.uns.ftn.svtvezbe05.repository.ProductRepository;
import rs.ac.uns.ftn.svtvezbe05.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findOne(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }
}
