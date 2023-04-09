package org.acme.service;

import org.acme.entity.User;

import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface UserService {


    List<User> showAllUser();

    List<User> showUserById(Long id);

    boolean createUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException;

    boolean foundUser(User user);

    void updateUserById(User body, Long id) throws NoSuchAlgorithmException, InvalidKeySpecException;

    void deleteUserById(Long id);

}
