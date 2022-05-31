package sbnz.music.controller;

import sbnz.music.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbnz.music.service.SongService;

@RestController
@RequestMapping("/api/song")
public class SongController {

	@Autowired
	private SongService songService;


	
}
