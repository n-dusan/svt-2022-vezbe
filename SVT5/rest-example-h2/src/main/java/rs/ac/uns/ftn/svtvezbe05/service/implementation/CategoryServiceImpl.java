package rs.ac.uns.ftn.svtvezbe05.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe05.model.entity.Category;
import rs.ac.uns.ftn.svtvezbe05.repository.CategoryRepository;
import rs.ac.uns.ftn.svtvezbe05.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllByParent(Category parent){
        return categoryRepository.findAllByParent(parent);
    }

    @Override
    public Category findOne(Integer categoryId){
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        categoryRepository.deleteById(id);
    }

}
