package rs.ac.uns.ftn.svtvezbe05.model.dto;

import java.io.Serializable;
import java.util.Date;

public class PurchaseOrderDTO implements Serializable {

    private Integer id;

    private Date date;

    private UserDTO user;

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(Integer id, Date date, UserDTO user) {
        this.id = id;
        this.date = date;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
