package org.example.main;

import org.example.model.entity.User;
import org.example.service.impl.UserServiceImpl;

import javax.persistence.PersistenceException;

public class Main {
    public static void main(String[] args) {

      try {
          UserServiceImpl userService = new UserServiceImpl();
          userService.loadAllUsers();
          userService.findUserById(123l);

      }catch (ExceptionInInitializerError |PersistenceException e){
          System.out.println(e.getMessage());
      }
    }
}