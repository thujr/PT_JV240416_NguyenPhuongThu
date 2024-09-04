package ra.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.test.model.Product;
import ra.test.service.CategoryService;
import ra.test.service.ProductService;

@Controller
@RequestMapping("productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public String listProduct(Model model) {
        model.addAttribute("listProduct", productService.findAll());
        return "product";

    }

    @GetMapping("/initCreate")
    public String initCreateProduct(Model model) {
        model.addAttribute("productNew", new Product());
        model.addAttribute("listCategories", categoryService.findAll());
        return "newProduct";

    }

    @PostMapping("/create")
    public String createProduct(Product product) {
        boolean result = productService.create(product);
        if (result) {
            return "redirect:/productController/findAll";
        }
        return "error";
    }

    @GetMapping("/intiUpdate")
    public String initUpdateProduct(int productId, Model model) {
        Product productUpdate = productService.findById(productId);
        model.addAttribute("productUpdate", productUpdate);
        model.addAttribute("listCategories", categoryService.findAll());
        return "updateProduct";
    }

    @PostMapping("/update")
    public String updateProduct(Product productUpdate) {
        boolean result = productService.update(productUpdate);
        if (result) {
            return "redirect:/productController/findAll";
        }
        return "error";
    }
    @GetMapping("/delete")
    public String deleteProduct(int productId){
        boolean result= productService.delete(productId);
        if (result){
            return "redirect:/productController/findAll";
        }
        return "error";
    }
}


