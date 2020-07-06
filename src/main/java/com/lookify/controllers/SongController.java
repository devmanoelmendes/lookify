package com.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lookify.models.Song;
import com.lookify.services.SongService;

@Controller			
public class SongController {
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "Home";
	}
	
	@GetMapping("/songs")
	public String index(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "Index";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("artist") String artist, Model model) {
		List<Song> songs = songService.findArtist(artist);		
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "Artist";
	}
	
	@GetMapping("/search/top")
	public String showTop(Model model) {
		List<Song> songs = songService.findTopTenByRating();
		model.addAttribute("songs", songs);
		return "ShowTop";
	}
	
	@GetMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "Show";
	}
	
	@GetMapping("/songs/new")
	public String New(@ModelAttribute("song") Song song) {		
		return "New";
	}
	
	@PostMapping("/songs")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {		
		if (result.hasErrors()) {
			return "redirect:/songs/new";
		}
		
		else {
			songService.createSong(song);
			return "redirect:/songs";
		}
	}
	
	@RequestMapping("/songs/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/songs";
	}
}
