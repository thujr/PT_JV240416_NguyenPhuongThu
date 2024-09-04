package ra.test.service;

import ra.test.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int productId);
    boolean create(Product product);
    boolean update(Product product);
    boolean delete(int productId);
}
