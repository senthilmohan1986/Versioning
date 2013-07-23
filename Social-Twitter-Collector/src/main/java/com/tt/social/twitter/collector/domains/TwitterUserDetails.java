package com.tt.social.twitter.collector.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "TWITTER_USER_DETAILS")
@Table
public class TwitterUserDetails extends XborderSocialData{
	
	public TwitterUserDetails(long id, String name, String location) {
	}
	
	@Id
	@Column(name = "TWITTER_USER_ID")
	private long id;
	
	@Column(name = "TWITTER_USER_NAME")
	private String name;
	
	@Column(name = "TWITTER_USER_PROFILE_IMAGE")
	private String profileImageUrl;
	
	@Column(name = "TWITTER_USER_LOCATION")
	private String location;
	
	@Column(name = "TWITTER_USER_ISPROTECTED")
	private boolean isProtected;
	
	@Column(name = "TWITTER_USER_FOLLOWER_COUNT")
	private long followersCount;
	
	@Column(name = "TWITTER_USER_FRIENDS_COUNT")
	private long friendsCount;
	
	@Column(name = "TWITTER_USER_TIME_ZONE")
	private String timeZone;
	
	@Column(name = "TWITTER_USER_LANG_CODE")
	private String langCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	public long getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(long followersCount) {
		this.followersCount = followersCount;
	}

	public long getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(long friendsCount) {
		this.friendsCount = friendsCount;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	
}
