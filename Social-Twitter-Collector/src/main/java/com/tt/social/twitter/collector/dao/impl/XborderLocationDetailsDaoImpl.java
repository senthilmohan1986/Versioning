package com.tt.social.twitter.collector.dao.impl;

import java.util.List;

import com.tt.social.twitter.collector.dao.IXborderLocationDetailsDao;
import com.tt.social.twitter.collector.domains.XborderLocationDetails;

public class XborderLocationDetailsDaoImpl extends BaseDaoImpl implements IXborderLocationDetailsDao{

	public List<XborderLocationDetails> getAllLocations() {
		List<XborderLocationDetails> locationDetails = createNamedAndTypedQuery(XborderLocationDetails.class, "QUERY_ALL_LOCATIONS").getResultList();
		return locationDetails;
	}

}
