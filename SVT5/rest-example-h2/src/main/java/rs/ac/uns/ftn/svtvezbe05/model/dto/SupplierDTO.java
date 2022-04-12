package rs.ac.uns.ftn.svtvezbe05.model.dto;

import rs.ac.uns.ftn.svtvezbe05.model.entity.Supplier;

public class SupplierDTO {

    private Integer id;

    private String name;

    private String address;

    public SupplierDTO() {
    }

    public SupplierDTO(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public SupplierDTO(Supplier supplier) {
        this(supplier.getId(), supplier.getName(), supplier.getAddress());
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
