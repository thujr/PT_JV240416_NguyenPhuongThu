package ra.test.repository.imp;

import ra.test.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Category findById(int categoryId);
    boolean create(Category category);
    boolean update(Category category);
    boolean delete(int categoryId);
}
