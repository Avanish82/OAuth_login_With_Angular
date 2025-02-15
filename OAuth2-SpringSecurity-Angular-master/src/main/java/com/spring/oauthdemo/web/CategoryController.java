package com.spring.oauthdemo.web;

import com.spring.oauthdemo.model.Category;
import com.spring.oauthdemo.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/category")
public class CategoryController
{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(path = "/list")
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Category> findCategoryById(@PathVariable Long id)
    {
        return categoryRepository.findById(id);
    }

    @PostMapping(value = "/create")
    public Category createNewCategory(@RequestBody Category category)
    {
        return categoryRepository.saveAndFlush(category);
    }

    @PutMapping(value = "/update")
    public Category updateCategory(@RequestBody Category category)
    {
        return categoryRepository.saveAndFlush(category);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id){
    	categoryRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!.");
    }
}
