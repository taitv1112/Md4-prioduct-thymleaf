package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

@Controller
public class ProductController {

    @GetMapping("/products")
    public ModelAndView showlist(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("products", ProductService.products);
        return modelAndView;
    }
    @GetMapping("/products/{id}")
    public ModelAndView detailProduct(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("detailProduct");
        modelAndView.addObject("product", ProductService.getProduct(id));
        return modelAndView;
    }
    @PostMapping("/products")
    public ModelAndView update(@ModelAttribute Product product, @RequestParam int id){
        ProductService.edit(ProductService.findIndexById(id),product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
}
