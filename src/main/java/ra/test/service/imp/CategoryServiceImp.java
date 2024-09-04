package ra.test.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.test.model.Category;
import ra.test.repository.imp.CategoryRepository;
import ra.test.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public boolean create(Category category) {
        return categoryRepository.create(category);
    }

    @Override
    public boolean update(Category category) {
        return categoryRepository.update(category);
    }

    @Override
    public boolean delete(int categoryId) {
        return categoryRepository.delete(categoryId);
    }
}
