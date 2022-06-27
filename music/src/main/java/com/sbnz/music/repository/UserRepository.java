package com.sbnz.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbnz.music.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT s.genre FROM songs s WHERE s.song_id IN (SELECT us.song_id FROM users_songs us WHERE us.user_id = ?1) GROUP BY s.genre ORDER BY COUNT(s.song_id) DESC", nativeQuery = true)
	List<String> findLikedGenres(Long userId);
	
	@Query(value = "SELECT s.topic FROM songs s WHERE s.song_id IN (SELECT us.song_id FROM users_songs us WHERE us.user_id = ?1) GROUP BY s.topic ORDER BY COUNT(s.song_id) DESC", nativeQuery = true)
	List<String> findLikedTopics(Long userId);
	
	@Query(value = "SELECT * FROM users u WHERE u.username = ?1 AND u.password = ?2", nativeQuery = true)
	User login(String username, String password);
}
