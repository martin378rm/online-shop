package org.acme.repository;

import org.acme.entity.User;
import org.acme.util.HashingPasswordGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    @Inject
    HashingPasswordGenerator hashingPasswordGenerator;


    @Override
    public List<User> getAll() {
        return User.listAll();
    }

    @Override
    public void add(User body) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User user = new User();

        if (Objects.nonNull(body.getNama())){
            user.setNama(body.getNama());
        }
        if (Objects.nonNull(body.getEmail())){
            user.setEmail(body.getEmail());
        }
        if (Objects.nonNull(body.getUsername())){
            user.setUsername(body.getUsername());
        }
        if (Objects.nonNull(body.getPassword())){
            user.setPassword(hashingPasswordGenerator.generateStrongPasswordHash(body.getPassword()));
        }
        if (Objects.nonNull(body.getAlamat())){
            user.setAlamat(body.getAlamat());
        }
        if (Objects.nonNull(body.getNoTelepon())){
            user.setNoTelepon(body.getNoTelepon());
        }

        user.persist();

    }

    @Override
    public boolean delete(Long id) {
        if (findById(id) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User body, Long id) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Optional<User> optionalUser = User.find("id",id).firstResultOptional();

        // jika data yang dicari ada
        if (optionalUser.isPresent()){

            // simpan data yang di cari pada oldUser
            User oldUser = optionalUser.get();

            // jika user mengirim parameter ubah data lama menjadi data yang baru
            if (Objects.nonNull(body.getNama())){
                oldUser.setNama(body.getNama());
            }
            if (Objects.nonNull(body.getEmail())){
                oldUser.setEmail(body.getEmail());
            }
            if (Objects.nonNull(body.getUsername())){
                oldUser.setUsername(body.getUsername());
            }
            if (Objects.nonNull(body.getPassword())){
                oldUser.setPassword(hashingPasswordGenerator.generateStrongPasswordHash(body.getPassword()));
            }
            if (Objects.nonNull(body.getAlamat())){
                oldUser.setAlamat(body.getAlamat());
            }
            if (Objects.nonNull(body.getNoTelepon())){
                oldUser.setNoTelepon(body.getNoTelepon());
            }

            oldUser.persist();

            if (isPersistent(oldUser)){
                return true;
            }
        }
        return false;
    }
}
