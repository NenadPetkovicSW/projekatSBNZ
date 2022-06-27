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

import com.sbnz.music.domain.Song;
import com.sbnz.music.service.SongService;

@RestController
@RequestMapping(value = "/api/song", produces = MediaType.APPLICATION_JSON_VALUE)
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Song>> getSongs() {

        return new ResponseEntity<List<Song>>(songService.getSongs(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/search/{name}/{userId}")
    public ResponseEntity<List<Song>> search(@PathVariable("name") String name, @PathVariable("userId") String userId) {

        return new ResponseEntity<List<Song>>(songService.search(name, Long.parseLong(userId)), HttpStatus.OK);
    }
    
    @GetMapping(value = "/likedSongs/{userId}")
    public ResponseEntity<List<Song>> getLikedSongs(@PathVariable("userId") String userId) {

        return new ResponseEntity<List<Song>>(songService.getLikedSongs(Long.parseLong(userId)), HttpStatus.OK);
    }

}
