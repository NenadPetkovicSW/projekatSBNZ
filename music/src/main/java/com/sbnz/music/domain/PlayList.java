package com.sbnz.music.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "playlist")
public class PlayList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "playlist_id")
	private Long id;
	@Column(name= "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private PlayListType type;
	@Column(name= "name", nullable = false)
	private String name;
	@Column(name= "len", nullable = false)
	private Integer len;
	@ManyToMany
    @JoinTable(
            name = "playlists_songs",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
	private List<Song> songs;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnoreProperties("playlist")
    private User user;
	public PlayList() {
		super();
	}
	public PlayList(Long id, PlayListType type, String name, int len, List<Song> songs, User user) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.len = len;
		this.songs = songs;
		this.user = user;
	}
	public PlayList(PlayListType type, String name, int len, List<Song> songs, User user) {
		super();
		this.type = type;
		this.name = name;
		this.len = len;
		this.songs = songs;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PlayListType getType() {
		return type;
	}
	public void setType(PlayListType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + len;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayList other = (PlayList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (len != other.len)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		if (type != other.type)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PlayList [id=" + id + ", type=" + type + ", name=" + name + ", len=" + len + ", songs=" + songs
				+ ", user=" + user + "]";
	}
	
	
}
