package com.sbnz.music.service;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.music.domain.Song;
import com.sbnz.music.domain.User;
import com.sbnz.music.repository.SongRepository;
import com.sbnz.music.repository.UserRepository;;

@Service
public class UserService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;

    private final UserRepository userRepository;
    private final SongRepository songRepository;

    @Autowired
    public UserService(KieSession rulesSession, UserRepository userRepository, SongRepository songRepository) {
        this.rulesSession = rulesSession;
        this.userRepository = userRepository;
        this.songRepository = songRepository;
    }

    public List<User> getUsers() {

        rulesSession.fireAllRules();

        return userRepository.findAll();
    }
    
    public User likeSong(Long userId, Long songId) {
    	
    	User user = userRepository.findById(userId).get();
    	List<Song> likedSongs = user.getSongs();
    	
    	Song newSong = songRepository.findById(songId).get();
    	
    	if(newSong == null)
    	{
    		return null;
    	}
    	
    	for(Song s : likedSongs)
    	{
    		if(s == newSong)
    		{
    			return null;
    		}
    	}
    	
    	likedSongs.add(newSong);
    	
    	user.setSongs(likedSongs);

    	rulesSession.insert(user);
        rulesSession.fireAllRules();
        
    	userRepository.save(user);
    	
		return user;
    }

}
