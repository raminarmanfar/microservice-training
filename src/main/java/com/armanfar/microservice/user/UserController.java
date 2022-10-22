package com.armanfar.microservice.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.armanfar.microservice.exception.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException(id);

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        userDaoService.deleteById(id);
    }
}
