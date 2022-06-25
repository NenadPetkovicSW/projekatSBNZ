package com.sbnz.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.music.domain.User;
import com.sbnz.music.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }
    
    @PutMapping(value = "/like/{userId}/{songId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("userId") String userId, @PathVariable("songId") String songId)
    {
    	User user = userService.likeSong(Long.parseLong(userId),Long.parseLong(songId));
    	
    	if(user==null)
    		return new ResponseEntity<User>(user, HttpStatus.ALREADY_REPORTED);
    		
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
