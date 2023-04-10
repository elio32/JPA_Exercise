package org.example.service;

import org.example.model.dto.UserDetailsDTO;
import org.example.model.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {
    List<UserDetailsDTO> loadAllUsersDetails();
    List<UserDetailsDTO> deleteUserDetails(UserDetails userDetails);
    List<UserDetailsDTO> findUserDetailsById(Long id);
    List<UserDetailsDTO> saveNewUserDetails(UserDetails userDetails);
}
