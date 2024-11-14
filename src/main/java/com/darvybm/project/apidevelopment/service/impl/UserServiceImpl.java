package com.darvybm.project.apidevelopment.service.impl;

import com.darvybm.project.apidevelopment.dto.request.UserRequest;
import com.darvybm.project.apidevelopment.exception.BadRequestException;
import com.darvybm.project.apidevelopment.exception.ResourceNotFoundException;
import com.darvybm.project.apidevelopment.model.Category;
import com.darvybm.project.apidevelopment.model.User;
import com.darvybm.project.apidevelopment.repository.UserRepository;
import com.darvybm.project.apidevelopment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAllByDeletedFalse();  // Solo obtiene usuarios activos
    }

    @Override
    public User getById(UUID id) {
        return myFindById(id);
    }

    @Override
    public User save(UserRequest userRequest) {

        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new BadRequestException("Username already exists.", "The provided username is already in use.");
        }

        try {
            User user = modelMapper.map(userRequest, User.class);
            user.setId(UUID.randomUUID());
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            return userRepository.save(user);
        } catch (Exception e) {
            throw new BadRequestException("Error saving user", e.getMessage());
        }
    }

    @Override
    public User update(UUID id, UserRequest userRequest) {
        try {
            User user = myFindById(id);
            modelMapper.map(userRequest, user);
            user.setId(id);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new BadRequestException("Error updating user", e.getMessage());
        }
    }

    @Override
    public void deleteById(UUID id) {
        try {
            User user = myFindById(id);
            user.setDeleted(true);
            userRepository.save(user);
        } catch (Exception e) {
            throw new BadRequestException("Error deleting user", e.getMessage());
        }
    }

    private User myFindById(UUID id) {
        return userRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", id));
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}