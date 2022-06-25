package com.sbnz.music.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;


@Entity
@Table(name = "songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "song_id")
	private Long id;
	@Column(name= "artist_name", nullable = false)
	private String artist_name;
	@Column(name= "track_name", nullable = false)
	private String track_name;
	@Column(name= "release_date", nullable = false)
	private String release_date;
	@Column(name= "genre", nullable = false)
	private String genre;
	@Column(name= "len", nullable = false)
	private int len;
	@Column(name= "topic", nullable = false)
	private String topic;
	@Column(name= "age", nullable = false)
	private double age;

	@ManyToMany(mappedBy = "songs")
    @JsonIgnore
	private List<User> users;

	public Long getId() {
		return id;
	}

	public Song(Long id, String artist_name, String track_name, String release_date, String genre, int len,
			String topic, double age) {
		super();
		this.id = id;
		this.artist_name = artist_name;
		this.track_name = track_name;
		this.release_date = release_date;
		this.genre = genre;
		this.len = len;
		this.topic = topic;
		this.age = age;
	}

	public Song(Long id, String artist_name, String track_name, String release_date, String genre, int len,
			String topic, double age, List<User> users) {
		super();
		this.id = id;
		this.artist_name = artist_name;
		this.track_name = track_name;
		this.release_date = release_date;
		this.genre = genre;
		this.len = len;
		this.topic = topic;
		this.age = age;
		this.users = users;
	}

	public Song(String artist_name, String track_name, String release_date, String genre, int len, String topic,
			double age, List<User> users) {
		super();
		this.artist_name = artist_name;
		this.track_name = track_name;
		this.release_date = release_date;
		this.genre = genre;
		this.len = len;
		this.topic = topic;
		this.age = age;
		this.users = users;
	}

	public Song() {
		super();
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

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(age);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((artist_name == null) ? 0 : artist_name.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + len;
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + ((track_name == null) ? 0 : track_name.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Song other = (Song) obj;
		if (Double.doubleToLongBits(age) != Double.doubleToLongBits(other.age))
			return false;
		if (artist_name == null) {
			if (other.artist_name != null)
				return false;
		} else if (!artist_name.equals(other.artist_name))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (len != other.len)
			return false;
		if (release_date == null) {
			if (other.release_date != null)
				return false;
		} else if (!release_date.equals(other.release_date))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (track_name == null) {
			if (other.track_name != null)
				return false;
		} else if (!track_name.equals(other.track_name))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", artist_name=" + artist_name + ", track_name=" + track_name + ", release_date="
				+ release_date + ", genre=" + genre + ", len=" + len + ", topic=" + topic + ", age=" + age + ", users="
				+ users + "]";
	}
	
	
	
}

