package io.Spring.HackerNewsAPI.Entity;

import java.time.Instant;
import java.util.List;

public class Story {

	private String by;
	private Integer id;
	private List<Integer> kids;
	private Integer score;
	private String time;
	private String title;
	private String type;
	private String url;
	
	public String getby() {
		return by;
	}
	public void setby(String by) {
		this.by = by;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Integer> getKids() {
		return kids;
	}
	public void setKids(List<Integer> kids) {
		this.kids = kids;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(long time) {
		Instant t = Instant.ofEpochSecond(time);
		this.time = t.toString();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
/*{
	  "by" : "dhouston",
	  "descendants" : 71,
	  "id" : 8863,
	  "kids" : [ 8952, 9224, 8917, 8884, 8887, 8943, 8869, 8958, 9005, 9671, 8940, 9067, 8908, 9055, 8865, 8881, 8872, 8873, 8955, 10403, 8903, 8928, 9125, 8998, 8901, 8902, 8907, 8894, 8878, 8870, 8980, 8934, 8876 ],
	  "score" : 111,
	  "time" : 1175714200,
	  "title" : "My YC app: Dropbox - Throw away your USB drive",
	  "type" : "story",
	  "url" : "http://www.getdropbox.com/u/2/screencast.html"
	}*/