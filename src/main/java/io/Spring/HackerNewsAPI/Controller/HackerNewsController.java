package io.Spring.HackerNewsAPI.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.Spring.HackerNewsAPI.Entity.Comment;
import io.Spring.HackerNewsAPI.Entity.Story;
import io.Spring.HackerNewsAPI.Entity.User;

@RestController
public class HackerNewsController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/beststories")
	@Cacheable(value="storyData", key="#root.methodName")
	public List<Story> getBestStories() {
		List<Integer> ids = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/beststories.json", List.class);
		
		return ids.stream().limit(10).map(
				id -> {
					Story story = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/item/"+id+".json", 
							Story.class);
					return story;
					}
		).collect(Collectors.toList());
	}
	
	@RequestMapping("/paststories")
	@Cacheable(value="storyData", key="#root.methodName")
	public List<Story> getPastStories() {
		List<Integer> ids = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/topstories.json", List.class);
		
		return ids.stream().map(
				id -> {
					Story story = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/item/"+id+".json", 
							Story.class);
					return story;
					}
		).collect(Collectors.toList());
	}
	
	@RequestMapping("/comments/{storyId}")
	@Cacheable(value="storyData", key="'comment'+#storyId")
	public List<Comment> getComments(@PathVariable Integer storyId){
		Story story = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/item/"+storyId+".json", Story.class);
		
		return story.getKids().stream().limit(10).map(
						kid -> {
							Comment comment = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/item/"+kid+".json", Comment.class);
							User user = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/user/"+comment.getBy()+".json", User.class);
							comment.setUser(user);
							return comment;
						}
						
		).collect(Collectors.toList());
	}
}
