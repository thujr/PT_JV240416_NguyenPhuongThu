package ra.test.repository.imp;

import ra.test.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int productId);
    boolean create(Product product);
    boolean update(Product product);
    boolean delete(int productId);
}
