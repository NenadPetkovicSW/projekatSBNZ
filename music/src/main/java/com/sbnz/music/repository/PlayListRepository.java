package com.sbnz.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbnz.music.domain.PlayList;
import com.sbnz.music.domain.Song;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
	@Query(value = "SELECT * FROM playlist pl WHERE pl.user_id = ?1", nativeQuery = true)
	List<PlayList> findAllByUserId(Long userID);
}
