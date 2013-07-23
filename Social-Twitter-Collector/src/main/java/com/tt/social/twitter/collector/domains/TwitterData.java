package com.tt.social.twitter.collector.domains;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "TWITTER_TWEETS")
public class TwitterData extends XborderSocialData{
	
	public TwitterData(long tweetId, String text, long userId ) {
		this.tweetId = tweetId;
		this.text = text;
		this.userTwitterId = userId;
	}
	
    @Id
    @Column(name = "TWEET_ID")
    private long tweetId;
   
    @Column(name = "TWEET_TEXT")
    private String text;
    
    @Column(name = "TWEET_ISRETWEETED")
    private boolean isRetweeted;
    
    @Column(name = "TWEET_CREATED_AT")
    private Date createdAt;
    
    @Column(name = "TWEET_PLACE")
    private String place;
    
    @Column(name = "TWEET_USER_ID")
    private long userTwitterId;
    
    @Column(name = "TWITTER_XBORDER_PLACE_ID")
    private int xborderPlaceId;
    

	public int getXborderPlaceId() {
		return xborderPlaceId;
	}

	public void setXborderPlaceId(int xborderPlaceId) {
		this.xborderPlaceId = xborderPlaceId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isRetweeted() {
		return isRetweeted;
	}

	public void setRetweeted(boolean isReweeted) {
		this.isRetweeted = isReweeted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public long getUserTwitterId() {
		return userTwitterId;
	}

	public void setUserTwitterId(long userTwitterId) {
		this.userTwitterId = userTwitterId;
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}
}