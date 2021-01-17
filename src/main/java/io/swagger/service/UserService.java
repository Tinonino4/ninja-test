package io.swagger.service;

import io.swagger.model.User;
import io.swagger.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
  @Autowired
  private IUserRepository userRepository;

  @Override
  public List<User> getUsers() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public User saveUser(User user) {
    return (User) userRepository.save(user);
  }

  @Override
  public User getUserById(Integer idUser) {
    return (User) userRepository.findUserById(idUser);
  }

  @Override
  public void delete(Integer idUser) {
    userRepository.delete(idUser);
  }
}
