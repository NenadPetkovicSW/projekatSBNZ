package com.sbnz.music.domain;

import javax.persistence.*;

import java.util.Objects;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_name", nullable = false)
    private String artist_name;

    @Column(name = "track_name", nullable = false)
    private String track_name;

    public Song() {
        super();
    }

    public Song(Long id, String artist_name, String track_name) {
        this.id = id;
        this.artist_name = artist_name;
        this.track_name = track_name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist_name, track_name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }
}
