package ra.test.service;

import ra.test.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int categoryId);
    boolean create(Category category);
    boolean update(Category category);
    boolean delete(int categoryId);
}
