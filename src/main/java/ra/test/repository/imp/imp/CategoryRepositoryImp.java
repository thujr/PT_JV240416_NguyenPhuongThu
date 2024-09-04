package ra.test.repository.imp.imp;

import org.springframework.stereotype.Repository;
import ra.test.model.Category;
import ra.test.repository.imp.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryRepositoryImp implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("from Category ", Category.class).getResultList();
    }

    @Override
    public Category findById(int categoryId) {
        return entityManager.createQuery("from Category c where c.categoryId=:id", Category.class)
                .setParameter("id", categoryId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean create(Category category) {
        try {
            entityManager.persist(category);
            return true;

        } catch (Exception ec) {
            ec.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        try {
            entityManager.merge(category);
            return true;
        } catch (Exception ec) {
            ec.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int categoryId) {
        try {
            Long count = (Long) entityManager.createQuery(
                            "select count(p) from Product p where p.category.categoryId=:categoryId")
                    .setParameter("categoryId", categoryId).getSingleResult();
            if (count > 0) {
                return false;
            }
            Category category = entityManager.find(Category.class, categoryId);
            if (category != null) {
                entityManager.remove(category);
                return true;
            } else {
                return false;
            }
        } catch (Exception ec) {
            ec.printStackTrace();
        }
        return false;
    }
}
