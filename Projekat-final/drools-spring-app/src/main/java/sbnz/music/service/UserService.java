package sbnz.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.music.domain.User;
import sbnz.music.repository.SongRepository;
import sbnz.music.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void remove(Long id) {
		userRepository.deleteById(id);
	}

}
