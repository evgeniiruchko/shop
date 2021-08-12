package ru.garant21.msauth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.garant21.msauth.enteties.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
