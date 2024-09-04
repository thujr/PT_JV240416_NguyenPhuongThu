package ra.test.repository.imp.imp;

import org.springframework.stereotype.Repository;
import ra.test.model.Product;
import ra.test.repository.imp.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product ", Product.class).getResultList();
    }

    @Override
    public Product findById(int productId) {
        return entityManager.createQuery("from Product p where p.productId=:id", Product.class)
                .setParameter("id", productId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean create(Product product) {
        try {
            entityManager.persist(product);
            return true;
        } catch (Exception ec) {
            ec.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        try {
            entityManager.merge(product);
            return true;
        } catch (Exception ec) {
            ec.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int productId) {
        Product pro = entityManager.find(Product.class, productId);
        if (pro != null) {
            entityManager.remove(pro);
            return true;
        }
        return false;
    }
}
