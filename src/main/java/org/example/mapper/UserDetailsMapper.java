package org.example.mapper;

import org.example.model.dto.UserDetailsDTO;
import org.example.model.entity.UserDetails;

public class UserDetailsMapper extends AbstractMapper<UserDetails, UserDetailsDTO>{
    @Override
    public UserDetails toEntity(UserDetailsDTO userDetailsDTO) {
        return null;
    }
    @Override
    public UserDetailsDTO toDto(UserDetails userDetails) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(userDetails.getId());
        userDetailsDTO.setFirstname(userDetails.getFirstname());
        userDetailsDTO.setLastname(userDetails.getLastname());
        userDetailsDTO.setEmail(userDetails.getEmail());
        userDetailsDTO.setPhoneNumber(userDetails.getPhoneNumber());
        return userDetailsDTO;
    }
}
