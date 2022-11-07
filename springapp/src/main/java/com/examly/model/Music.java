package com.examly.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    private int musicId;
	private String musicName;
	private String musicUrl;
	private String musicPosterUrl;
    private String musicAlbum;
	private String musicArtist;
    private String likes;
    public int getMusicId() {
        return musicId;
    }
    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }
    public String getMusicName() {
        return musicName;
    }
    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
    public String getMusicUrl() {
        return musicUrl;
    }
    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }
    public String getMusicPosterUrl() {
        return musicPosterUrl;
    }
    public void setMusicPosterUrl(String musicPosterUrl) {
        this.musicPosterUrl = musicPosterUrl;
    }
    public String getMusicAlbum() {
        return musicAlbum;
    }
    public void setMusicAlbum(String musicAlbum) {
        this.musicAlbum = musicAlbum;
    }
    public String getMusicArtist() {
        return musicArtist;
    }
    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }
    public String getLikes() {
        return likes;
    }
    public void setLikes(String likes) {
        this.likes = likes;
    }
    
}
