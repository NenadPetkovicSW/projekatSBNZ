package sbnz.music.controller;

import sbnz.music.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbnz.music.service.UserService;

@RestController
@RequestMapping("/api/song")
public class UserController {

	@Autowired
	private UserService userService;


	
}
