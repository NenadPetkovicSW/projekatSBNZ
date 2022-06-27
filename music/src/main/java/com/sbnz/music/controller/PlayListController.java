package com.sbnz.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.music.domain.PlayList;
import com.sbnz.music.service.PlayListService;

@RestController
@RequestMapping(value = "/api/playlist", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayListController {
    private final PlayListService playListService;

    @Autowired
    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PlayList>> getUsers() {

        return new ResponseEntity<List<PlayList>>(playListService.getPlayLists(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<PlayList> getUsers(@PathVariable("id") String id) {
    	PlayList pl = playListService.getPlayList(Long.parseLong(id));
    	
    	if(pl == null)
            return new ResponseEntity<PlayList>(pl, HttpStatus.NOT_ACCEPTABLE);
    	
        return new ResponseEntity<PlayList>(pl, HttpStatus.OK);
    }
    
    @GetMapping(value = "/createPlayListAlfa/{userId}/{name}/{howLong}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayList> createPlayListAlfa(@PathVariable("userId") String userId, @PathVariable("name") String name, @PathVariable("howLong") String howLong) {
    	PlayList pl = playListService.createPlayListAlfa(Long.parseLong(userId), name, Integer.parseInt(howLong));
    	
    	if(pl == null)
            return new ResponseEntity<PlayList>(pl, HttpStatus.NOT_ACCEPTABLE);
    	
        return new ResponseEntity<PlayList>(pl, HttpStatus.OK);
    }
    
    @GetMapping(value = "/createPlayListBeta/{userId}/{name}/{howLong}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayList> createPlayListBeta(@PathVariable("userId") String userId, @PathVariable("name") String name, @PathVariable("howLong") String howLong) {

    	PlayList pl = playListService.createPlayListBeta(Long.parseLong(userId), name, Integer.parseInt(howLong));
    	
    	if(pl == null)
            return new ResponseEntity<PlayList>(pl, HttpStatus.NOT_ACCEPTABLE);
    	
        return new ResponseEntity<PlayList>(pl, HttpStatus.OK);   
    }
    
    @GetMapping(value = "/createPlayListGama/{userId}/{name}/{howLong}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayList> createPlayListGama(@PathVariable("userId") String userId, @PathVariable("name") String name, @PathVariable("howLong") String howLong) {
    	PlayList pl = playListService.createPlayListGama(Long.parseLong(userId), name, Integer.parseInt(howLong));
    	
    	if(pl == null)
            return new ResponseEntity<PlayList>(pl, HttpStatus.NOT_ACCEPTABLE);
    	
        return new ResponseEntity<PlayList>(pl, HttpStatus.OK);
    }
    
    @GetMapping(value = "/getUsersPlay/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlayList>> getUsersPlay(@PathVariable("userId") String userId) {
    	List<PlayList> pl = playListService.getPlayListsOfUser(Long.parseLong(userId));
    	
    	if(pl == null)
            return new ResponseEntity<List<PlayList>>(pl, HttpStatus.NOT_ACCEPTABLE);
    	
        return new ResponseEntity<List<PlayList>>(pl, HttpStatus.OK);
    }
    
    
}
