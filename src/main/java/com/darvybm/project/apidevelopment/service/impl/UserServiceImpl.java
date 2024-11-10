package com.darvybm.project.apidevelopment.service.impl;

import com.darvybm.project.apidevelopment.model.User;
import com.darvybm.project.apidevelopment.repository.UserRepository;
import com.darvybm.project.apidevelopment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public Optional<User> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(UUID id, User user) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}