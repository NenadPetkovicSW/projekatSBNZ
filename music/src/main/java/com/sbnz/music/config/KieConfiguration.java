package com.sbnz.music.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sbnz.music.domain.PlayList;
import com.sbnz.music.domain.Song;
import com.sbnz.music.domain.User;
import com.sbnz.music.repository.PlayListRepository;
import com.sbnz.music.repository.SongRepository;
import com.sbnz.music.repository.UserRepository;

@Configuration
public class KieConfiguration {
    private final SongRepository songRepository;
    private final UserRepository userRepository;
    private final PlayListRepository playListRepository;

    @Autowired
    public KieConfiguration(SongRepository songRepository, UserRepository userRepository, PlayListRepository playListRepository) {
    	this.songRepository = songRepository;
    	this.userRepository = userRepository;
    	this.playListRepository = playListRepository;
    }

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.sbnz", "music-kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(10_000);
        return kContainer;
    }

    @Bean(name = "rulesSession")
    public KieSession kieSession() {
        KieSession kieSession = this.kieContainer().newKieSession("rulesSession");

        for (Song song : songRepository.findAll()) {
            kieSession.insert(song);
        }
        
        for (User user : userRepository.findAll()) {
            kieSession.insert(user);
        }
        
        for (PlayList playList : playListRepository.findAll()) {
            kieSession.insert(playList);
        }

        return kieSession;
    }

}
