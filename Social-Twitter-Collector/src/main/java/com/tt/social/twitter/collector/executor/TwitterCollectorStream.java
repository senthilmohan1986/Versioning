package com.tt.social.twitter.collector.executor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import com.tt.social.twitter.collector.dao.IXborderLocationDetailsDao;
import com.tt.social.twitter.collector.domains.XborderLocationDetails;
import com.tt.social.twitter.collector.utils.ThreadExecutor;

public class TwitterCollectorStream {
	
	private static final Log log = LogFactory.getLog(TwitterCollectorStream.class);

	private IXborderLocationDetailsDao locationDetailsDao;
	
	private List<XborderLocationDetails> locationDetails;
	
	private List<String> locationKeywords;
	
	public TwitterCollectorStream(IXborderLocationDetailsDao locationDetailsDao) {
		this.locationDetailsDao = locationDetailsDao;
		locationKeywords = new ArrayList<String>();
		getLocationSpecificKeywords();
		triggerStreaming();
	}

	private void getLocationSpecificKeywords() {
		locationDetails = locationDetailsDao.getAllLocations();
		Iterator<XborderLocationDetails> locIterator = locationDetails.iterator();
		while (locIterator.hasNext()) {
			XborderLocationDetails xborderLocationDetails = (XborderLocationDetails) locIterator.next();
			locationKeywords.add(xborderLocationDetails.getLocationKeywords());
		}
	}
	
	private void triggerStreaming() {
		StatusListener listener = new StatusListener(){
	        
			public void onStatus(Status status) {
	            log.info(status.getUser().getName() + " : " + status.getText());
	            ThreadExecutor.getInstance().execute(new TweetCategorizer(locationDetails, status));
	        }
	        
			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
				log.info("Stream - onDeletionNotice | Status-Id - " + statusDeletionNotice.getStatusId());
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				log.info("Stream - onTrackLimitationNotice | Limited status number - " +numberOfLimitedStatuses);
			}
	        
			public void onException(Exception ex) {
	            log.error("Streaming error - " + ex);
	        }
			
			public void onScrubGeo(long arg0, long arg1) {
				log.info("Stream - onScrubGeo");
			}
	
			public void onStallWarning(StallWarning arg0) {
				log.info("Stream - onStallWarning | stallWarning - " +arg0.getMessage());
			}
	    };

	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	    
	    twitterStream.addListener(listener);
	    FilterQuery query = new FilterQuery();
	    String[] keywords = locationKeywords.toArray(new String[locationKeywords.size()]);
	    query.track(keywords);
	    twitterStream.filter(query);
	}
	
}
