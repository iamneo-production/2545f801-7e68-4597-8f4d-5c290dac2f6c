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

import com.examly.dao.IMusic;
import com.examly.model.Music;

@RestController
public class AdminMusicController {
    @Autowired
	IMusic music;
    @GetMapping("admin/music")
	public String findAll() {
		music.findAll(); 
		return "Array of Music";
	}
    @DeleteMapping("admin/music/{musicId}")
	public String delete(@PathVariable("musicId")int musicId) {
		music.deleteById(musicId);
		return "Song deleted";
	}
    @PutMapping("admin/music/{musicId}")
	public String update(@RequestBody Music m,@PathVariable("musicId")int musicId) {
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
