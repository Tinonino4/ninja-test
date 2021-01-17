package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.User;
import io.swagger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-15T17:30:41.911Z")

@Controller
public class DeleteUsersByIdApiController implements DeleteUsersByIdApi {

    private static final Logger log = LoggerFactory.getLogger(DeleteUsersByIdApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    public DeleteUsersByIdApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteUsersByIdUserIdDelete(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                // Invalid id
                if (userId <= 0)
                    return new ResponseEntity("Invalid user id",HttpStatus.BAD_REQUEST);
                User userFound = userService.getUserById(userId);
                //User not found
                if (userFound == null)
                    return new ResponseEntity("User not found",HttpStatus.NOT_FOUND);
                // Delete User
                 userService.delete(userId);
                return new ResponseEntity("OK",HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

}
