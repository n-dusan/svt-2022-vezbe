package rs.ac.uns.ftn.svtvezbe05.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.svtvezbe05.model.dto.CategoryDTO;
import rs.ac.uns.ftn.svtvezbe05.model.entity.Category;
import rs.ac.uns.ftn.svtvezbe05.service.CategoryService;

@RestController
@RequestMapping(value = "api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<Category> categories = categoryService.findAll();

        // Convert categories to DTOs
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        for (Category c : categories) {
            categoriesDTO.add(new CategoryDTO(c));
        }

        return new ResponseEntity<>(categoriesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") Integer id) {
        Category category = categoryService.findOne(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CategoryDTO(category), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        if (categoryDTO.getParent() != null && categoryDTO.getParent().getId() != null) {
            Category parentCategory = categoryService.findOne(categoryDTO.getParent().getId());
            category.setParent(parentCategory);
        }

        category = categoryService.save(category);
        return new ResponseEntity<>(new CategoryDTO(category), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Integer id) {
        // A category must exist
        Category category = categoryService.findOne(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        if (categoryDTO.getParent() != null && categoryDTO.getParent().getId() != null) {
            Category parentCategory = categoryService.findOne(categoryDTO.getParent().getId());
            category.setParent(parentCategory);
        }

        category = categoryService.save(category);
        return new ResponseEntity<>(new CategoryDTO(category), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        Category category = categoryService.findOne(id);
        if (category != null) {
            categoryService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
