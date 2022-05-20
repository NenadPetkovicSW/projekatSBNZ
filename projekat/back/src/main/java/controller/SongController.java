package controller;

import domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.SongService;

@RestController
@RequestMapping("/api/song")
public class SongController {

	@Autowired
	private SongService songService;


	
}
