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
    
    @GetMapping(value = "/createPlayListAlfa/{userId}/{name}/{howLong}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayList> createPlayListAlfa(@PathVariable("userId") String userId, @PathVariable("name") String name, @PathVariable("howLong") String howLong) {

        return new ResponseEntity<PlayList>(playListService.createPlayListAlfa(Long.parseLong(userId), name, Integer.parseInt(howLong)), HttpStatus.OK);
    }
    
    @GetMapping(value = "/createPlayListBeta/{userId}/{name}/{howLong}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayList> createPlayListBeta(@PathVariable("userId") String userId, @PathVariable("name") String name, @PathVariable("howLong") String howLong) {

        return new ResponseEntity<PlayList>(playListService.createPlayListBeta(Long.parseLong(userId), name, Integer.parseInt(howLong)), HttpStatus.OK);
    }
    
    @GetMapping(value = "/createPlayListGama/{userId}/{name}/{howLong}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayList> createPlayListGama(@PathVariable("userId") String userId, @PathVariable("name") String name, @PathVariable("howLong") String howLong) {
    	Integer hl = Integer.parseInt(howLong);
    	Long ui = Long.parseLong(userId);
    	
        return new ResponseEntity<PlayList>(playListService.createPlayListGama(ui, name, hl), HttpStatus.OK);
    }
    
    
}
