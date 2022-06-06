package com.sbnz.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.music.domain.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

}
