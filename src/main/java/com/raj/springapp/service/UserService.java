package com.raj.springapp.service;

import java.util.List;

import com.raj.springapp.model.User;

public interface UserService {

  User saveUser(User user);

  List<User> getUserList();

  User removeUser(User user);
}
