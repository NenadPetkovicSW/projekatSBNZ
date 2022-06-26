package com.sbnz.music.service;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.music.domain.AgeGroup;
import com.sbnz.music.domain.PlayList;
import com.sbnz.music.domain.PlayListType;
import com.sbnz.music.domain.Song;
import com.sbnz.music.domain.User;
import com.sbnz.music.repository.PlayListRepository;;

@Service
public class PlayListService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;

    private final PlayListRepository playListRepository;
    private final UserService userService;
    private final SongService songService;
    
    @Autowired
    public PlayListService(KieSession rulesSession, PlayListRepository playListRepository, UserService userService, SongService songService) {
        this.rulesSession = rulesSession;
        this.playListRepository = playListRepository;
        this.userService = userService;
        this.songService = songService;
    }
    

    public List<PlayList> getPlayLists() {

        rulesSession.fireAllRules();

        return playListRepository.findAll();
    }
    
	public PlayList createPlayListAlfa(Long userId, String name, int howLong) {
	    	
	    	User user = userService.getUser(userId);
	    	List<Song> songs = songService.findAlfaPlaylist(userId, getAgeRestriction(user.getAgeGroup()));
	    	
	    	if(howLong < songs.size())
			{
				 int fromIndex = howLong;
			     int toIndex = songs.size()-1;
			     songs.subList(fromIndex, toIndex+1).clear();
			}
	    	
	    	Integer len = 0;
	    	
	    	for(Song s : songs)
	    	{
	    		len = len + s.getLen();
	    	}
	    	
	    	PlayList playList = new PlayList(PlayListType.ALFA,name,len,songs,user); 
	    	
	    	this.playListRepository.save(playList);
	    	
	    	rulesSession.insert(playList);
	    	rulesSession.fireAllRules();
	        return playList;
	    }
	public PlayList createPlayListBeta(Long userId, String name, int howLong) {
		
		User user = userService.getUser(userId);
		List<Song> songs = songService.findBetaPlaylist(userId);
		
		if(howLong < songs.size())
		{
			 int fromIndex = howLong;
		     int toIndex = songs.size()-1;
		     songs.subList(fromIndex, toIndex+1).clear();
		}
		
		Integer len = 0;
    	
    	for(Song s : songs)
    	{
    		len = len + s.getLen();
    	}
    	
    	PlayList playList = new PlayList(PlayListType.BETA,name,len,songs,user); 
		
		this.playListRepository.save(playList);
		
		rulesSession.insert(playList);
		rulesSession.fireAllRules();
	    return playList;
	}
	public PlayList createPlayListGama(Long userId, String name, int howLong) {
		
		User user = userService.getUser(userId);
		List<Song> songs = songService.findGamaPlaylist(userId, getAgeRestriction(user.getAgeGroup()));
		System.out.print(songs);
		if(howLong < songs.size())
		{
			 int fromIndex = howLong;
		     int toIndex = songs.size()-1;
		     songs.subList(fromIndex, toIndex+1).clear();
		}
		
		Integer len = 0;
    	
    	for(Song s : songs)
    	{
    		len = len + s.getLen();
    	}
    	
    	PlayList playList = new PlayList(PlayListType.GAMA,name,len,songs,user); 
		
		this.playListRepository.save(playList);
		
		rulesSession.insert(playList);
		rulesSession.fireAllRules();
	    return playList;
	}
    
    private Double getAgeRestriction(AgeGroup ag) {
    	switch (ag) {
    	case TEEN:
			return 0.25;
    	case YOUNG_ADULT:
			return 0.50;
    	case ADULT:
			return 0.70;
    	case ELDER:
			return 1.0;
		default:
			return 1.0;
		}
    }
    
    public boolean containsSongId(final List<Song> list, final Long id){
        return list.stream().filter(o -> o.getId().equals(id)).findFirst().isPresent();
    }
    

}
