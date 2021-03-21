package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView getAll() {
        List<Category> categories = categoryService.findALl();
        ModelAndView modelAndView = new ModelAndView("category/listcate");
        modelAndView.addObject("category", categories);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        categoryService.remove(id);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("category/createcate");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView("category/createcate");
        categoryService.save(category);
        modelAndView.addObject("category",category);
        modelAndView.addObject("mess", "Thêm mới thành công danh mục" + category.getName());
        return modelAndView;
    }
    @PostMapping("/noright")
    public ModelAndView p403(){
        ModelAndView modelAndView =  new ModelAndView("noright");
        return modelAndView;
    }

}
