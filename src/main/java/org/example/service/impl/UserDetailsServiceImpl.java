package org.example.service.impl;

import org.example.mapper.UserDetailsMapper;
import org.example.model.dto.UserDetailsDTO;
import org.example.model.entity.UserDetails;
import org.example.repository.impl.UserDetailsRepositoryImpl;
import org.example.service.UserDetailsService;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepositoryImpl userDetailsRepository;
    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsServiceImpl() {
        this.userDetailsMapper = new UserDetailsMapper();
        this.userDetailsRepository = new UserDetailsRepositoryImpl();
    }

    @Override
    public List<UserDetailsDTO> loadAllUsersDetails() {
        return userDetailsRepository.findAll().stream().map(userDetailsMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<UserDetailsDTO> deleteUserDetails(UserDetails userDetails) {
        return userDetailsRepository.delete(userDetails).stream().map(userDetailsMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<UserDetailsDTO> findUserDetailsById(Long id) {
        return userDetailsRepository.findById(id).stream().map(userDetailsMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<UserDetailsDTO> saveNewUserDetails(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails).stream().map(userDetailsMapper::toDto).collect(Collectors.toList());

    }
}
