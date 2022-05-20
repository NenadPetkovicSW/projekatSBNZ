package domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne
	@JoinColumn(name = "user_id", unique = true)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Song() {
		super();
	}

	public Song(Long id, String artist_name, String track_name, String release_date, String genre, int len, String topic) {
		this.id = id;
		this.artist_name = artist_name;
		this.track_name = track_name;
		this.release_date = release_date;
		this.genre = genre;
		this.len = len;
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Song{" +
				"id=" + id +
				", artist_name='" + artist_name + '\'' +
				", track_name='" + track_name + '\'' +
				", release_date='" + release_date + '\'' +
				", genre='" + genre + '\'' +
				", len=" + len +
				", topic='" + topic + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Song song = (Song) o;
		return len == song.len && Objects.equals(id, song.id) && Objects.equals(artist_name, song.artist_name) && Objects.equals(track_name, song.track_name) && Objects.equals(release_date, song.release_date) && Objects.equals(genre, song.genre) && Objects.equals(topic, song.topic);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, artist_name, track_name, release_date, genre, len, topic);
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
}
