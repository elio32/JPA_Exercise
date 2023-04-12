package org.example.main;

import org.example.model.dto.UserDTO;
import org.example.service.impl.UserServiceImpl;

import javax.persistence.PersistenceException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

      try {
          UserServiceImpl userService = new UserServiceImpl();
          List<UserDTO> users = userService.loadAllUsers();
          for (UserDTO user : users){
              System.out.println(user);
          }
      }catch (ExceptionInInitializerError |PersistenceException e){
          System.out.println(e.getMessage());
      }
    }
}