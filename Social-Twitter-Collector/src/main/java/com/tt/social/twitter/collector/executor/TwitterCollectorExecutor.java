package com.tt.social.twitter.collector.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tt.social.twitter.collector.dao.ITwitterDataDao;
import com.tt.social.twitter.collector.domains.TwitterData;

@Controller
@RequestMapping("/social/twitter")
public class TwitterCollectorExecutor {
	
	@Autowired
	private ITwitterDataDao twitterDataDao;

	@RequestMapping(value="collector", method = RequestMethod.GET)
	public ModelAndView getShopInJSON() {
		/*//TwitterData data = new TwitterData();
		data.setTweetId(78686876);
		data.setText("My First Try");
		//twitterDataDao.save(data);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Root", twitterDataDao.getTwitterData());*/
		return null;
	}
	
}
