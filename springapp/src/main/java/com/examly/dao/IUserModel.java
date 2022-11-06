package com.examly.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.model.UserModel;

public interface IUserModel extends JpaRepository<UserModel, Integer>{

}