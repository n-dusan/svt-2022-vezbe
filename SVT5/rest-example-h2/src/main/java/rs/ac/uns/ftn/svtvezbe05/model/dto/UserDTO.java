package rs.ac.uns.ftn.svtvezbe05.model.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private boolean receiveNews;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String password, String firstName, String lastName, String address, String email, boolean receiveNews) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.receiveNews = receiveNews;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isReceiveNews() {
        return receiveNews;
    }

    public void setReceiveNews(boolean receiveNews) {
        this.receiveNews = receiveNews;
    }
}
