package com.sbnz.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.music.domain.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {

}
