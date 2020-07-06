package com.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lookify.models.Song;
import com.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		
		else {
			return null;
		}
	}
	
	public Song updateSong(Long id, String title, String artist, int rating) {
		Optional<Song> optionalSong = songRepository.findById(id);
		
		if (optionalSong.isPresent()) {
			Song song = optionalSong.get();
			song.setTitle(title);
			song.setArtist(artist);
			song.setRating(rating);
			return songRepository.save(song);
		}
		
		else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	public List<Song> findArtist(String artist) {
		return songRepository.findByArtistContaining(artist);
	}
	
	public List<Song> findTopTenByRating() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
}
