package com.sbnz.music.domain;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	@Column(name= "username", nullable = false)
	private String username;
	@Column(name= "first_name", nullable = false)
	private String first_name;
	@Column(name= "last_name", nullable = false)
	private String last_name;
	@Column(name= "password", nullable = false)
	private String password;
	@Column(name= "age", nullable = false)
	private Integer age;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserType type;
	@Enumerated(EnumType.STRING)
	@Column(name= "age_group", nullable = true)
	private AgeGroup ageGroup;
	
    @ManyToMany
    @JoinTable(
            name = "users_songs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
	private List<Song> songs;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<PlayList> playlists = new ArrayList<>();

	public User(Long id, String username, String first_name, String last_name, String password, int age, UserType type,
			AgeGroup ageGroup, List<Song> songs) {
		super();
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.age = age;
		this.type = type;
		this.ageGroup = ageGroup;
		this.songs = songs;
	}

	public User(String username, String first_name, String last_name, String password, int age, UserType type,
			AgeGroup ageGroup, List<Song> songs) {
		super();
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.age = age;
		this.type = type;
		this.ageGroup = ageGroup;
		this.songs = songs;
	}

	public User() {
		super();
	}

	public User(Long id, String username, String first_name, String last_name, String password, int age, UserType type,
			AgeGroup ageGroup) {
		super();
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.age = age;
		this.type = type;
		this.ageGroup = ageGroup;
	}

	
	public List<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((ageGroup == null) ? 0 : ageGroup.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (ageGroup != other.ageGroup)
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		if (type != other.type)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + ", age=" + age + ", type=" + type + ", ageGroup=" + ageGroup + ", songs="
				+ songs + "]";
	}

	
}
