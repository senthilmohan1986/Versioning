package com.tt.social.twitter.collector.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "XBORDER_PLACE_DETAILS")
public class XborderPlaceDetails extends XborderSocialData{
	
	@Id
	@Column(name = "XBORDER_PLACE_ID")
	private int xborderPlaceId;
	
	@Column(name = "XBORDER_PLACE_NAME")
	private String xborderPlaceName;
	
	public int getXborderPlaceId() {
		return xborderPlaceId;
	}

	public void setXborderPlaceId(int xborderPlaceId) {
		this.xborderPlaceId = xborderPlaceId;
	}

	public String getXborderPlaceName() {
		return xborderPlaceName;
	}

	public void setXborderPlaceName(String xborderPlaceName) {
		this.xborderPlaceName = xborderPlaceName;
	}

}
