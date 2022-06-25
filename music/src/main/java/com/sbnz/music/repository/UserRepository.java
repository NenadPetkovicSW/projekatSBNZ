package com.sbnz.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.music.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
