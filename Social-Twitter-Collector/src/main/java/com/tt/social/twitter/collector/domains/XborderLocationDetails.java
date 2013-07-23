package com.tt.social.twitter.collector.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "XBORDER_LOCATION_DETAILS")
@Entity
@NamedQueries({
@NamedQuery(
	    name="QUERY_ALL_LOCATIONS",
	    query="select x from XborderLocationDetails x"
	)
})
public class XborderLocationDetails extends XborderSocialData{

	@Id
	@Column(name = "XBORDER_LOC_ID")
	private String xborderLocId;
	
	@Column(name = "XBORDER_LOC_KEYWORDS")
	private String locationKeywords;
	
	@Column(name = "XBORDER_COUNTRY_ID")
	private int xborderCountryId;
	
	@Column(name = "XBORDER_CITY_ID")
	private int xborderCityId;
	
	@Column(name = "XBORDER_PLACE_ID")
	private int xborderPlaceId;

	public String getXborderLocId() {
		return xborderLocId;
	}

	public void setXborderLocId(String xborderLocId) {
		this.xborderLocId = xborderLocId;
	}

	public String getLocationKeywords() {
		return locationKeywords;
	}

	public void setLocationKeywords(String locationKeywords) {
		this.locationKeywords = locationKeywords;
	}

	public int getXborderCountryId() {
		return xborderCountryId;
	}

	public void setXborderCountryId(int xborderCountryId) {
		this.xborderCountryId = xborderCountryId;
	}

	public int getXborderCityId() {
		return xborderCityId;
	}

	public void setXborderCityId(int xborderCityId) {
		this.xborderCityId = xborderCityId;
	}

	public int getXborderPlaceId() {
		return xborderPlaceId;
	}

	public void setXborderPlaceId(int xborderPlaceId) {
		this.xborderPlaceId = xborderPlaceId;
	}
	
}
