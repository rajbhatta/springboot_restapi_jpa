package com.raj.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.springapp.model.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {}
