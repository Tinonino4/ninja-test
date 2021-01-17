package io.swagger.api;

import io.swagger.model.User;
import io.swagger.repository.IUserRepository;
import io.swagger.service.AddressService;
import io.swagger.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({@Sql( scripts = "classpath:sql/data.sql", executionPhase = BEFORE_TEST_METHOD)})
@ActiveProfiles("test")
public class GetusersByIdApiControllerTest {

  @Autowired
  private IUserRepository userRepository;

  @Inject
  private UserService userService;

  @Inject
  private AddressService addressService;

//  private User user;

  @Test
  public void givenIdUser_whenFindUserById_thenReturnUser() {
    // given
    Integer id = 1;
    // when
    User user = userService.getUserById(id);
    // then
    assertThat(user.getId()).isEqualTo(id);
  }

  @Test
  public void givenIdUser_whenFindUserById_thenReturnNull() {
    // given
    Integer id = 100;
    // when
    User user = userService.getUserById(id);
    // then
    assertThat(user).isEqualTo(null);
  }

  @Test
  public void givenInvalidIdUser_whenFindUserById_thenReturnNull() {
    // given
    Integer invalidId = 0;
    // when
    User user = userService.getUserById(invalidId);
    // then
    assertThat(user).isEqualTo(null);
  }
}