package com.example.jspapp.controller;

import com.example.jspapp.entity.Product;
import com.example.jspapp.entity.ProductCategory;
import com.example.jspapp.mapper.ProductCategoryMapper;
import com.example.jspapp.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/homepage/products")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;


    @PostMapping //! For admin only
    public String saveProduct(@RequestBody Product product) {
        productMapper.save(product);
        return "homepage";
    }

    @GetMapping
    public ModelAndView getAllProducts() {
        ModelAndView mav = new ModelAndView("homepage");
        mav.addObject("allProducts", productMapper.getAllProducts());
        return mav;
    }

    @DeleteMapping("/{id}") //! For admin only
    public String deleteProductById(@PathVariable Long id) {
        productMapper.deleteProductById(id);
        return "homepage";
    }

    @PutMapping("/{id}") //! For admin only
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setProductID(id);
        productMapper.update(product);
        return "homepage";
    }

    @PostMapping("/search")
    public ModelAndView searchProducts(@RequestParam(value = "category", required = false) String category,
                                       @RequestParam(value = "productName", required = false) String name){
        ModelAndView mav = new ModelAndView("homepage");

        List<Product> filteredProducts;

        if(category != null && !category.isEmpty()) {
            ProductCategory productCategory = productCategoryMapper.getCategoryByName(category);
            Long categoryId = productCategory != null ? productCategory.getCategoryID() : null;

            filteredProducts = name != null && !name.isEmpty() ?
                    productMapper.getProductsByNameAndCategory(name, categoryId) :
                    productMapper.getProductsByCategory(categoryId);
        } else {
            filteredProducts = name != null && !name.isEmpty() ?
                    productMapper.getProductByName(name) :
                    productMapper.getAllProducts();
        }

        mav.addObject("filteredProducts", filteredProducts);
        return mav;
    }

}
