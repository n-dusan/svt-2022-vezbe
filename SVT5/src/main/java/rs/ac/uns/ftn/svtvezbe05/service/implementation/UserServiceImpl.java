package rs.ac.uns.ftn.svtvezbe05.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe05.model.entity.PurchaseOrder;
import rs.ac.uns.ftn.svtvezbe05.model.entity.User;
import rs.ac.uns.ftn.svtvezbe05.repository.UserRepository;
import rs.ac.uns.ftn.svtvezbe05.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user.getPassword().equals(password))
            return user;
        else
            return null;
    }

    @Override
    public void add(User user, PurchaseOrder order) {
        user = userRepository.findById(user.getId()).orElseThrow();
        user.getOrders().add(order);
        userRepository.save(user);
    }
    
}
