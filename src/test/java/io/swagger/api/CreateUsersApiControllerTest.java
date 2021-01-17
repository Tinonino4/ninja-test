package io.swagger.api;

import io.swagger.model.User;
import io.swagger.repository.IUserRepository;
import io.swagger.service.AddressService;
import io.swagger.service.IUserService;
import io.swagger.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({@Sql( scripts = "classpath:sql/data.sql", executionPhase = BEFORE_TEST_METHOD)})
@ActiveProfiles("test")
public class CreateUsersApiControllerTest {

  @Autowired
  private IUserRepository userRepository;

  @Inject
  private UserService userService;

  @Inject
  private AddressService addressService;

  private User user;

  @Test
  public void givenUser_whenSaveUser_thenReturnUser() {
    // given
    user = createUser();
    // when
    User userSaved = userService.saveUser(user);
    // then
    assertThat(userSaved.getName()).isEqualTo(user.getName());
  }

  @Test
  public void givenUserWithoutName_whenSaveUser_thenThrowException() {
    // given
    user = createUser();
    user.setName(null);
    Exception exception = null;
    // when
    try {
      User userSaved = userService.saveUser(user);
    } catch (Exception e) {
      exception = e;
    }
    // then
    assertThat(exception.getClass()).isEqualTo(DataIntegrityViolationException.class);
  }

  private User createUser() {
    User user =new User();
    user.setName("Maria");
    user.setEmail("Maria@test.com");
    user.setBirthdate("1985-03-07");
    user.setAddress(null);
    return user;
  }
}