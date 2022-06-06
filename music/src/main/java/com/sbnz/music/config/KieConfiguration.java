package com.sbnz.music.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sbnz.music.domain.Song;
import com.sbnz.music.repository.SongRepository;

@Configuration
public class KieConfiguration {
    private final SongRepository songRepository;

    @Autowired
    public KieConfiguration(SongRepository songRepository) {
        this.songRepository = songRepository;

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

        return kieSession;
    }

}
