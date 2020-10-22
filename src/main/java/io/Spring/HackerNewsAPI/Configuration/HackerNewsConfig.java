package io.Spring.HackerNewsAPI.Configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import net.sf.ehcache.config.CacheConfiguration;


@Configuration
@EnableCaching
public class HackerNewsConfig extends CachingConfigurerSupport{

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager(){
		CacheConfiguration storyData = new CacheConfiguration();
		storyData.setName("storyData"); 
		storyData.setMemoryStoreEvictionPolicy("LRU"); //using Least Recently used Caching Strategy
		storyData.setMaxEntriesLocalHeap(1000); 
		storyData.setTimeToLiveSeconds(15*60); //Setting the TTL to 15 Minutes
		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(storyData); 
		return net.sf.ehcache.CacheManager.newInstance(config);
	}
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}
}
