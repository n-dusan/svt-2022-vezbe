package rs.ac.uns.ftn.svtvezbe05.model.dto;

import rs.ac.uns.ftn.svtvezbe05.model.entity.Category;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private Integer id;

    private String name;

    private String description;

    private CategoryDTO parent;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name, String description, CategoryDTO parent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parent = parent;
    }

    public CategoryDTO(Category category) {
        this(category.getId(), category.getName(), category.getDescription(),
                (category.getParent() != null && category.getParent().getId() != null) ? new CategoryDTO(category.getParent()) : new CategoryDTO());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO getParent() {
        return parent;
    }

    public void setParent(CategoryDTO parent) {
        this.parent = parent;
    }
}
