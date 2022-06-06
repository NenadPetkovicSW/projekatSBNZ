package com.sbnz.music.service;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbnz.music.domain.Song;
import com.sbnz.music.repository.SongRepository;

@Service
public class SongService {
    @Qualifier("rulesSession")
    private final KieSession rulesSession;

    private final SongRepository songRepository;

    @Autowired
    public SongService(KieSession rulesSession, SongRepository songRepository) {
        this.rulesSession = rulesSession;
        this.songRepository = songRepository;
    }

    public List<Song> getSongs() {
        Song song = new Song(Long.valueOf(3), "Artist 3", "Song 3");

        rulesSession.insert(song);
        rulesSession.fireAllRules();

        songRepository.save(song);

        return songRepository.findAll();
    }

}
