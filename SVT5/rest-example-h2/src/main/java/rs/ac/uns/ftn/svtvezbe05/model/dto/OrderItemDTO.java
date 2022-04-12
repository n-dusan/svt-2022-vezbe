package rs.ac.uns.ftn.svtvezbe05.model.dto;

import java.io.Serializable;

public class OrderItemDTO implements Serializable {

    private Integer id;

    private int quantity;

    private ProductDTO productDTO;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Integer id, int quantity, ProductDTO productDTO) {
        this.id = id;
        this.quantity = quantity;
        this.productDTO = productDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
