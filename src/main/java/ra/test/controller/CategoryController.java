package ra.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.test.model.Category;
import ra.test.service.CategoryService;

import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping("/categoryController")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public String listCategory(Model model) {
        model.addAttribute("listCategory", categoryService.findAll());
        return "category";
    }

    @GetMapping("/initCreate")
    public String initUpdateCategory(Model model) {
        Category categoryNew = new Category();
        model.addAttribute("categoryNew", categoryNew);
        return "newCategory";
    }

    @PostMapping("/create")
    public String createCategory(Category categoryNew) {
        boolean result = categoryService.create(categoryNew);
        if (result) {
            return "redirect:/categoryController/findAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
    public String initUpdateCategory( int categoryId, Model model) {
        Category categoryUpdate = categoryService.findById(categoryId);
        model.addAttribute("categoryUpdate", categoryUpdate);
        return "updateCategory";
    }

    @PostMapping("/update")
    public String updateCategory(Category categoryUpdate) {
        boolean result = categoryService.create(categoryUpdate);
        if (result) {
            return "redirect:/categoryController/findAll";
        }
        return "error";
    }

    @GetMapping("/delete")
    public String deleteCategory(int categoryId) {
        categoryService.delete(categoryId);
        return "redirect:/categoryController/findAll";
    }
}
