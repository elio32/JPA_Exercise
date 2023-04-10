package org.example.mapper;

import org.example.model.dto.UserDTO;
import org.example.model.entity.User;

public class UserMapper extends AbstractMapper<User, UserDTO>{
    private final UserDetailsMapper userDetailsMapper;

    public UserMapper() {
        this.userDetailsMapper = new UserDetailsMapper();
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return null;
    }
    @Override
    public UserDTO toDto(User user) {
        if (user ==null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setUserDetailsDTO(userDetailsMapper.toDto(user.getUserDetails()));
        return userDTO;
    }
}
