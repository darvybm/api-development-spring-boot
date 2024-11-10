package com.darvybm.project.apidevelopment.service;

import com.darvybm.project.apidevelopment.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<User> getAll();

    Optional<User> getById(UUID id);

    User save(User user);

    User update(UUID id, User user);

    void deleteById(UUID id);
}