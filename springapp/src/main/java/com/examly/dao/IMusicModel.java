package com.examly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.model.MusicModel;

public interface IMusicModel extends JpaRepository<MusicModel, String>{

}
