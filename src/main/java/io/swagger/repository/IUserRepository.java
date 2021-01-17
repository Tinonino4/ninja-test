package io.swagger.repository;

import io.swagger.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
  User findUserById(Integer idUser);
}
