package easantos.api.service;

import easantos.api.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate) throws IllegalAccessException;
}
