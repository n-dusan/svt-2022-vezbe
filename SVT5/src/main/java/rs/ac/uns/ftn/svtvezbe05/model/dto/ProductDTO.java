package rs.ac.uns.ftn.svtvezbe05.model.dto;

import rs.ac.uns.ftn.svtvezbe05.model.entity.Product;

import java.math.BigDecimal;

public class ProductDTO {

    private Integer id;

    private String name;

    private String vendor;

    private String description;

    private BigDecimal price;

    private CategoryDTO category;

    private SupplierDTO supplier;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, String vendor, String description, BigDecimal price, CategoryDTO category, SupplierDTO supplier) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
        this.description = description;
        this.price = price;
        this.category = category;
        this.supplier = supplier;
    }

    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getVendor(),
                product.getDescription(), product.getPrice(), new CategoryDTO(product.getCategory()),
                new SupplierDTO(product.getSupplier()));
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public SupplierDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDTO supplier) {
        this.supplier = supplier;
    }
}
