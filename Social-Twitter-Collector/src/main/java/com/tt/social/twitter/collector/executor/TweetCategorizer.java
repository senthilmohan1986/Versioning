package com.tt.social.twitter.collector.executor;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import twitter4j.Status;

import com.tt.social.twitter.collector.dao.ITwitterDataDao;
import com.tt.social.twitter.collector.dao.ITwitterUserDetailsDao;
import com.tt.social.twitter.collector.domains.TwitterData;
import com.tt.social.twitter.collector.domains.TwitterUserDetails;
import com.tt.social.twitter.collector.domains.XborderLocationDetails;

@Configurable
public class TweetCategorizer implements Runnable{
	
	private List<XborderLocationDetails> locationDetails;
	private Status status;
	
	@Autowired
	private ITwitterDataDao<TwitterData> twitterDataDao;
	
	@Autowired
	private ITwitterUserDetailsDao<TwitterUserDetails> userDetailsDao;
	
	public TweetCategorizer(List<XborderLocationDetails> locationDetails, Status status) {
		this.locationDetails = locationDetails;
		this.status = status;
	}

	public void run() {
		processTweet();
	}
	
	private void processTweet() {
		Iterator<XborderLocationDetails> iteratorLoc = locationDetails.iterator();
		while (iteratorLoc.hasNext()) {
			XborderLocationDetails xborderLocationDetails = (XborderLocationDetails) iteratorLoc.next();
			if (status.getText().contains(xborderLocationDetails.getLocationKeywords())) {
				saveTweet(xborderLocationDetails.getXborderPlaceId());
			}
		}
	}
	
	private void saveTweet(int placeId) {
		TwitterData twitterData = frameTwitterData(placeId);
		twitterDataDao.save(twitterData);
		TwitterUserDetails userDetails = frameTwitterUserDetails();
		userDetailsDao.save(userDetails);
	}
	
	private TwitterData frameTwitterData(int placeId) {
		TwitterData data = new TwitterData(status.getId(), status.getText(), status.getUser().getId());
		data.setPlace(status.getPlace().getName());
		data.setCreatedAt(status.getCreatedAt());
		data.setRetweeted(status.isRetweet());
		data.setXborderPlaceId(placeId);
		return data;
	}
	
	private TwitterUserDetails frameTwitterUserDetails() {
		twitter4j.User user = status.getUser();
		TwitterUserDetails userDetails = new TwitterUserDetails(user.getId(), user.getName(), user.getLocation());
		userDetails.setFollowersCount(user.getFollowersCount());
		userDetails.setFriendsCount(user.getFriendsCount());
		userDetails.setLangCode(user.getLang());
		userDetails.setProfileImageUrl(user.getProfileImageURL());
		userDetails.setProtected(user.isProtected());
		userDetails.setTimeZone(user.getTimeZone());
		return userDetails;
	}
}
