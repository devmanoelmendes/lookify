package com.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lookify.models.Song;
import com.lookify.services.SongService;

@RestController
public class SongAPI {
	private final SongService songService;
	
	public SongAPI(SongService songService) {
		this.songService = songService;
	}
	
	@GetMapping("/api/songs")
	public List<Song> index() {
		return songService.allSongs();
	}
	
	@PostMapping("/api/songs")
	public Song create(@RequestParam("title") String title, @RequestParam("artist") String artist, @RequestParam("rating") int rating) {
		Song song = new Song(title, artist, rating);
		return songService.createSong(song);
	}
	
	@GetMapping("/api/songs/{id}")
	public Song show(@PathVariable("id") Long id) {
		Song song = songService.findSong(id);
		return song;
	}
	
	@PutMapping("/api/songs/{id}")
	public Song update(@PathVariable("id") Long id, @RequestParam("title") String title, @RequestParam("artist") String artist, @RequestParam("rating") int rating) {
		Song song = songService.updateSong(id, title, artist, rating);
		return song;
	}
	
	@DeleteMapping("/api/songs/{id}")
	public void delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
	}
}
