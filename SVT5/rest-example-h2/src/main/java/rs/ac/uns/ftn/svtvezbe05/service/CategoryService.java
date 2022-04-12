package rs.ac.uns.ftn.svtvezbe05.service;

import rs.ac.uns.ftn.svtvezbe05.model.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllByParent(Category parent);

    Category findOne(Integer categoryId);

    List<Category> findAll();

    Category save(Category category);

    void remove(Integer id);

}
