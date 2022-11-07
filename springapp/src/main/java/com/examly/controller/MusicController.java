package com.examly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.dao.ILikeModel;
import com.examly.model.LikeModel;
import com.examly.dao.ILogin;
import com.examly.model.Login;
import com.examly.dao.IUser;
import com.examly.model.User;
import com.examly.dao.IMusic;
import com.examly.model.Music;

@RestController
public class MusicController {
    @Autowired
	IMusic music;
    @GetMapping("music")
	public String findAll() {
		music.findAll(); 
		return "Array of Music";
	}
    @GetMapping("music/{musicId}")
	public String search(@PathVariable("musicId")int musicId) {
		music.findById(musicId);
        return "Music Details";
	}
}
