package com.sbnz.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbnz.music.domain.Song;

public interface SongRepository extends JpaRepository<Song, Long> {
	final String qFindAlfaPlaylist = "SELECT * FROM songs s "
			+ "WHERE s.song_id NOT IN (SELECT us.song_id FROM users_songs us WHERE us.user_id = ?1) "
			+ "AND s.topic IN (SELECT s1.topic FROM songs s1 WHERE s1.song_id IN (SELECT us1.song_id FROM users_songs us1 WHERE us1.user_id = ?1) GROUP BY s1.topic ORDER BY COUNT(s1.song_id) DESC) "
			+ "AND s.genre IN (SELECT s2.genre FROM songs s2 WHERE s2.song_id IN (SELECT us2.song_id FROM users_songs us2 WHERE us2.user_id = ?1) GROUP BY s2.genre ORDER BY COUNT(s2.song_id) DESC) "
			+ "AND s.age < ?2";
	
	final String qFindBetaPlaylist = "SELECT * FROM songs s "
			+ "WHERE s.song_id NOT IN (SELECT us.song_id FROM users_songs us WHERE us.user_id = ?1) "
			+ "AND s.topic IN (SELECT s1.topic FROM songs s1 WHERE s1.song_id IN (SELECT us1.song_id FROM users_songs us1 WHERE us1.user_id = ?1) GROUP BY s1.topic ORDER BY COUNT(s1.song_id) DESC) "
			+ "AND s.genre IN (SELECT s2.genre FROM songs s2 WHERE s2.song_id IN (SELECT us2.song_id FROM users_songs us2 WHERE us2.user_id = ?1) GROUP BY s2.genre ORDER BY COUNT(s2.song_id) DESC)";
	
	final String qFindGamaPlaylist = "SELECT * FROM songs s "
			+ "WHERE s.song_id NOT IN (SELECT us.song_id FROM users_songs us WHERE us.user_id = ?1) "
			+ "OR s.topic IN (SELECT s1.topic FROM songs s1 WHERE s1.song_id IN (SELECT us1.song_id FROM users_songs us1 WHERE us1.user_id = ?1) GROUP BY s1.topic ORDER BY COUNT(s1.song_id) DESC) "
			+ "OR s.genre IN (SELECT s2.genre FROM songs s2 WHERE s2.song_id IN (SELECT us2.song_id FROM users_songs us2 WHERE us2.user_id = ?1) GROUP BY s2.genre ORDER BY COUNT(s2.song_id) DESC) "
			+ "OR s.age < ?2";
	
	@Query(value = qFindAlfaPlaylist, nativeQuery = true)
	List<Song> findAlfaPlaylist(Long userId, Double age);
	
	@Query(value = qFindBetaPlaylist, nativeQuery = true)
	List<Song> findBetaPlaylist(Long userId);
	
	@Query(value = qFindGamaPlaylist, nativeQuery = true)
	List<Song> findGamaPlaylist(Long userId, Double age);
	
	@Query(value = "SELECT * FROM songs s WHERE s.topic LIKE ?1", nativeQuery = true)
	List<Song> findByTopicIs(String topic);
	
	@Query(value = "SELECT * FROM songs s WHERE s.genre LIKE ?1", nativeQuery = true)
	List<Song> findByGenreIs(String genre);
	
	@Query(value = "SELECT * FROM songs s WHERE (s.track_name LIKE ?1% "
			+ "OR s.artist_name LIKE ?1%) "
			+ "AND s.song_id NOT IN (SELECT us.song_id FROM users_songs us WHERE us.user_id = ?2)", nativeQuery = true)
	List<Song> search(String name, Long userId);
	
	@Query(value = "SELECT * FROM songs s WHERE "
			+ "s.song_id IN (SELECT us.song_id FROM users_songs us WHERE us.user_id = ?1)", nativeQuery = true)
	List<Song> getLikedSongs(Long userId);
	
	List<Song> findByAgeBetween(Double startAge, Double endAge);
	
}
