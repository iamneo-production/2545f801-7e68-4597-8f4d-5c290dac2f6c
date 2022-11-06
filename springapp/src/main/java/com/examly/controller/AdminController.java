package com.examly.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.examly.dao.IUserModel;
import com.examly.model.UserModel;
import com.examly.dao.IMusicModel;
import com.examly.model.MusicModel;
@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	IUserModel user;

	@Autowired
	IMusicModel music;

	@GetMapping("/")
	public String arrayOfUser(){
		user.findAll(); 
		return "Array of Users";
	}
	@PostMapping("add User")
	public String userAdd(@RequestBody UserModel u) {
		user.saveAndFlush(u);
		return "User added";
	}

	@DeleteMapping("delete/{id}")
	public String userDelete(@PathVariable("id") int id) {
		user.deleteById(id);
		return "User deleted";
	}
	@PutMapping("userEdit/{id}")
	public String changes(@RequestBody UserModel use, @PathVariable("id") int id) {
		user.findById(id).map(us -> {
			us.setEmail(use.getEmail());
			us.setPassword(use.getPassword());
			us.setUsername(use.getUsername());
			us.setMobileNumber(use.getMobileNumber());
			us.setActive(use.getActive());
			us.setRole(use.getRole());
			return user.save(us);

		});
		return "Save the Changes";
	}

	@GetMapping("music")
	public String arryOfMusic() {
		 music.findAll(); 
	return "Array of Music";
		
	}

	@DeleteMapping("music/{musicId}")
	public String delete(@PathVariable("musicId")String musicId) {
		music.deleteById(musicId);
		return "Song deleted";
	}

	@PutMapping("music/{musicId}")
	public String update(@RequestBody MusicModel m,@PathVariable("musicId")String musicId) {
		music.findById(musicId).map(mu->{
			mu.setMusicName(m.getMusicName());
			mu.setMusicUrl(m.getMusicUrl());
			mu.setMusicPosterUrl(m.getMusicPosterUrl());
			mu.setMusicAlbum(m.getMusicAlbum());
			mu.setMusicArtist(m.getMusicArtist());
			mu.setLikes(m.getLikes());
			return music.save(mu);
		});
		
		return "Save the Changes";
	}

}
