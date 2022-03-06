package rs.ac.uns.ftn.svtvezbe06.service;

import rs.ac.uns.ftn.svtvezbe06.model.dto.UserDTO;
import rs.ac.uns.ftn.svtvezbe06.model.entity.User;

public interface UserService {

    User findByUsername(String username);

    User createUser(UserDTO userDTO);
}
