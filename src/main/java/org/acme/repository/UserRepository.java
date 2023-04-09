package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;


public interface UserRepository extends PanacheRepository {

    List<User> getAll();

    void add(User user) throws NoSuchAlgorithmException, InvalidKeySpecException;

    boolean delete(Long id);

    boolean update(User body, Long id) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
