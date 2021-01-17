package io.swagger.service;

import io.swagger.model.User;

import java.util.List;

public interface IUserService {
  public List<User> getUsers();
  public User saveUser(User user);
  public User getUserById(Integer idUser);
  void delete(Integer idUser);
}
