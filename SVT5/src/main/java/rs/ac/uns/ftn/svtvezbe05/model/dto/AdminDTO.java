package rs.ac.uns.ftn.svtvezbe05.model.dto;

import java.io.Serializable;

public class AdminDTO implements Serializable {

    private Integer id;

    private String username;

    private String password;

    public AdminDTO() {
    }

    public AdminDTO(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
