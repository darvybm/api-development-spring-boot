package com.darvybm.project.apidevelopment.controller.api.v1;

import com.darvybm.project.apidevelopment.dto.request.CategoryRequest;
import com.darvybm.project.apidevelopment.dto.request.UserRequest;
import com.darvybm.project.apidevelopment.dto.response.UserResponse;
import com.darvybm.project.apidevelopment.model.Category;
import com.darvybm.project.apidevelopment.model.User;
import com.darvybm.project.apidevelopment.service.impl.CategoryServiceImpl;
import com.darvybm.project.apidevelopment.service.impl.UserServiceImpl;
import com.darvybm.project.apidevelopment.utils.response.CustResponseBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final CustResponseBuilder custResponseBuilder;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAll();
        List<UserResponse> userResponses = Arrays.asList(modelMapper.map(users, UserResponse[].class));
        return custResponseBuilder.ok(userResponses);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getUserById(@PathVariable UUID uuid) {
        User user = userService.getById(uuid);
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return custResponseBuilder.ok(userResponse);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.save(userRequest);
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return custResponseBuilder.ok(userResponse, "User was successfully created");
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequest userRequest, @PathVariable UUID uuid) {
        User user = userService.update(uuid, userRequest);
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return custResponseBuilder.ok(userResponse, "User was successfully updated");
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID uuid) {
        userService.deleteById(uuid);
        return custResponseBuilder.ok(null, "User was successfully deleted");
    }
}
