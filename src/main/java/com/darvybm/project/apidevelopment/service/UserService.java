package com.darvybm.project.apidevelopment.service;

import com.darvybm.project.apidevelopment.dto.request.UserRequest;
import com.darvybm.project.apidevelopment.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<User> getAll();

    User getById(UUID id);

    User save(UserRequest userRequest);

    User update(UUID id, UserRequest userRequest);

    void deleteById(UUID id);
}