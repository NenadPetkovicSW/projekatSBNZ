package com.sbnz.music.service;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.music.domain.Song;
import com.sbnz.music.repository.SongRepository;

@Service
public class SongService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;

    private final SongRepository songRepository;

    @Autowired
    public SongService(KieSession rulesSession, SongRepository songRepository) {
        this.rulesSession = rulesSession;
        this.songRepository = songRepository;
    }

    public List<Song> getSongs() {

      return songRepository.findAll();
  
    }
    
    public List<Song> findByTopicIs(String topic) {

        return songRepository.findByTopicIs(topic);
    
      }
    
    public List<Song> search(String name,Long userId) {

        return songRepository.search(name, userId);
    
      }
    
    public List<Song> getLikedSongs(Long userId) {

        return songRepository.getLikedSongs(userId);
    
      }
    
    public List<Song> findByGenreIs(String genre) {


        return songRepository.findByGenreIs(genre);
    }
    
    public List<Song> findByAgeBetween(Double startAge, Double endAge) {


        return songRepository.findByAgeBetween(startAge, endAge);
    }
    
    public List<Song> findAlfaPlaylist(Long userId, Double age) {

        return songRepository.findAlfaPlaylist(userId, age);
    
      }
    
    public List<Song> findBetaPlaylist(Long userId) {

        return songRepository.findBetaPlaylist(userId);
    
      }
    
    public List<Song> findGamaPlaylist(Long userId, Double age) {

        return songRepository.findGamaPlaylist(userId, age);
    
      }
    
  
    
    
}
