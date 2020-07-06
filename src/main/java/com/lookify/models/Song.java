package com.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "lookify")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 200)
	private String title;
	
	@Size(min = 5, max = 200)
	private String artist;
	
	@Min(1)
	@Max(10)
	private Integer rating;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated;
	
	public Song() {
		
	}
	
	public Song(String title, String artist, int rating) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@PrePersist
	protected void onCreate() {
		this.created = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated = new Date();
	}
}
