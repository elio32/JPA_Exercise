package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.model.dto.UserDTO;
import org.example.model.entity.User;
import org.example.repository.impl.UserRepositoryImpl;
import org.example.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
        this.userMapper = new UserMapper();
    }


    @Override
    public List<UserDTO> loadAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<UserDTO> deleteUser(User user) {
        return userRepository.delete(user).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findUserById(Long id) {
        return userRepository.findById(id).stream().map(userMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<UserDTO> saveNewUser(User user) {
        return userRepository.save(user).stream().map(userMapper::toDto).collect(Collectors.toList());

    }


    @Override
    public List<UserDTO> findUserByUsername(String username) {
        return userRepository.findByUsername(username).stream().map(userMapper::toDto).collect(Collectors.toList());

    }
}
