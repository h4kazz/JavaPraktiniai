package lt.techin.taskmanager.controller;

import jakarta.validation.Valid;
import lt.techin.taskmanager.dto.user.CreateUserRequest;
import lt.techin.taskmanager.dto.user.UpdateUserRequest;
import lt.techin.taskmanager.dto.user.UserMapper;
import lt.techin.taskmanager.dto.user.UserResponse;
import lt.techin.taskmanager.model.user.User;
import lt.techin.taskmanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        this.userMapper = new UserMapper();
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest request) {
        User user = userMapper.toUser(request);
        User createdUser = userService.create(user);
        UserResponse response = userMapper.toResponse(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        List<User> users = userService.getAll();
        return userMapper.toResponseList(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(userMapper.toResponse(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id
            , @RequestBody UpdateUserRequest request) {
        User user = userMapper.toUser(request, id);
        User updatedUser = userService.update(id, user);

        return ResponseEntity.ok(userMapper.toResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
