package com.examly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.model.LoginModel;

public interface ILoginModel extends JpaRepository<LoginModel, String>{

}