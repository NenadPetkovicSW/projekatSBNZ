package sbnz.music.service;

import java.util.ArrayList;
import java.util.List;

import sbnz.music.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.music.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	
	public List<Song> findAll() {
		return songRepository.findAll();
	}

	public Song save(Song song) {
		return songRepository.save(song);
	}
	
	public void remove(Long id) {
		songRepository.deleteById(id);
	}

}
