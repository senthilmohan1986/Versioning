package com.tt.social.twitter.collector.dao.impl;

import org.springframework.beans.factory.annotation.Configurable;

import com.tt.social.twitter.collector.dao.ITwitterDataDao;
import com.tt.social.twitter.collector.domains.TwitterData;

@Configurable
public class TwitterDataDaoImpl<DO extends TwitterData> extends BaseDaoImpl<TwitterData> implements ITwitterDataDao<TwitterData> {
	
	/*@PersistenceContext(unitName="entityManagerFactory_social_data")
	public EntityManager em;

	public void save(TwitterData data) {
		em.persist(data);
	}
	
	public TwitterData getTwitterData(){
		long id = 123;
		TwitterData data = em.find(TwitterData.class, id);
		return data;
	}*/

}
