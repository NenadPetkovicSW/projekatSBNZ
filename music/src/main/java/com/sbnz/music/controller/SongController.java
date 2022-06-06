package com.sbnz.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
