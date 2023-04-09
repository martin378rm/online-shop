package org.acme.service;


import io.vertx.core.json.JsonObject;
import org.acme.entity.User;
import org.acme.repository.UserRepository;
import org.acme.repository.UserRepositoryImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepositoryImpl userRepository;


    @Override
    public List<User> showAllUser() {
        return userRepository.getAll();
    }

    @Override
    public List<User> showUserById(Long id) {
        User user = User.findById(id);
        if (Objects.nonNull(user)){
            return Collections.singletonList(user);
        }
        return User.listAll();
    }

    @Override
    public boolean createUser(User body) throws NoSuchAlgorithmException, InvalidKeySpecException {

        JsonObject message = new JsonObject();

        if (body.getNama() == null) {
            return false;
        } else if (body.getEmail() == null){
            return false;
        } else if (body.getUsername() == null) {
            return false;
        } else if (body.getPassword() == null){
//
            return false;
        } else if (body.getAlamat() == null){
//
            return false;
        } else if (body.getNoTelepon() == null) {
//
            return false;
        }
        userRepository.add(body);
        return true;
    }

    @Override
    public boolean foundUser(User user) {
        return false;
    }


    @Override
    public void updateUserById(User body, Long id) throws NoSuchAlgorithmException, InvalidKeySpecException {
        userRepository.update(body,id);
    }

    @Override
    public void deleteUserById(Long id) {
        if (userRepository.delete(id)){
            User.deleteById(id);
        }
    }
}
