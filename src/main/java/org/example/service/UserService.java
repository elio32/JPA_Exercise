package org.example.service;

import org.example.model.dto.UserDTO;
import org.example.model.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> loadAllUsers();
    List<UserDTO> deleteUser(User user);
    List<UserDTO> findUserById(Long id);
    List<UserDTO> saveNewUser(User user);
    List<UserDTO> findUserByUsername(String username);
}
