package easantos.api.service.impl;

import easantos.api.model.User;
import easantos.api.repository.UserRepository;
import easantos.api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchFieldError::new) ;
    }

    @Override
    public User create(User userToCreate) throws IllegalAccessException {
        if(userToCreate.getId() != null  && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalAccessException("This User Id alredy exists.");
        }
        return userRepository.save(userToCreate);
    }
}
