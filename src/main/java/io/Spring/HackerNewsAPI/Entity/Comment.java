package io.Spring.HackerNewsAPI.Entity;

import java.time.Instant;
import java.util.List;

public class Comment {

	private String by;
	private Integer id;
	private List<Integer> kids;
	private Integer parent;
	private String text;
	private String time;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
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
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(long time) {
		Instant t = Instant.ofEpochSecond(time);
		this.time = t.toString();
	}
	
	
	
}
/*{
	  "by" : "norvig",
	  "id" : 2921983,
	  "kids" : [ 2922097, 2922429, 2924562, 2922709, 2922573, 2922140, 2922141 ],
	  "parent" : 2921506,
	  "text" : "Aw shucks, guys ... you make me blush with your compliments.<p>Tell you what, Ill make a deal: I'll keep writing if you keep reading. K?",
	  "time" : 1314211127,
	  "type" : "comment"
	}*/