package ru.garant21.msauth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.garant21.msauth.enteties.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserById(Long id);
    User findUserByUsernameAndPassword(String username, String password);
}
