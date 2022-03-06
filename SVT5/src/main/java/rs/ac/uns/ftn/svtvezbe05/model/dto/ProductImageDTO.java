package rs.ac.uns.ftn.svtvezbe05.model.dto;

import java.io.Serializable;

public class ProductImageDTO implements Serializable {

    private Integer id;

    private String title;

    private int width;

    private int height;

    private String contentType;

    private byte[] imageDate;

    public ProductImageDTO() {
    }

    public ProductImageDTO(Integer id, String title, int width, int height, String contentType, byte[] imageDate) {
        this.id = id;
        this.title = title;
        this.width = width;
        this.height = height;
        this.contentType = contentType;
        this.imageDate = imageDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getImageDate() {
        return imageDate;
    }

    public void setImageDate(byte[] imageDate) {
        this.imageDate = imageDate;
    }
}
