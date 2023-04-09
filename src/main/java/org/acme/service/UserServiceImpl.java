package org.acme.service;


import io.vertx.core.json.JsonObject;
import org.acme.entity.User;
import org.acme.repository.UserRepositoryImpl;
import org.acme.util.HashingPasswordGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepositoryImpl userRepository;

    @Inject
    HashingPasswordGenerator generatorPassword;


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

        if (body.getNama() == null) {
            return false;
        } else if (body.getEmail() == null){
            return false;
        } else if (body.getUsername() == null) {
            return false;
        } else if (body.getPassword() == null){
            return false;
        } else if (body.getAlamat() == null){
            return false;
        } else if (body.getNoTelepon() == null) {
            return false;
        }
        userRepository.add(body);
        return true;
    }

    @Override
    public boolean foundUser(User body) throws NoSuchAlgorithmException, InvalidKeySpecException, NullPointerException {
       User user = User.find("username",body.getUsername()).firstResult();

       String hash = user.getPassword();

       if (user != null){
           if (generatorPassword.validatePassword(body.getPassword(), hash)){
               return true;
           }
       }
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
