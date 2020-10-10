package com.raj.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.raj.springapp.dao.UserRespository;
import com.raj.springapp.model.User;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRespository userRepository;

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<User> getUserList() {
    List<User> users = userRepository.findAll();
    return users;
  }

  @DeleteMapping(value = "/delete/user")
  public User removeUser(@RequestBody User user) {
    userRepository.delete(user);
    return user;
  }
}
