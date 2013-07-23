package com.tt.social.twitter.collector.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Table(name = "XBORDER_CITY_DETAILS")
@Entity
public class XborderCityDetails extends XborderSocialData{

	@Id
	@Column(name = "XBORDER_CITY_ID")
	private int xborderCityId;
	
	@Column(name = "XBORDER_CITY_NAME")
	private String xborderCityName;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "XBORDER_PLACE_ID" , insertable=false,updatable=false)
	private List<XborderPlaceDetails> placeDetails;

	public List<XborderPlaceDetails> getPlaceDetails() {
		return placeDetails;
	}

	public void setPlaceDetails(List<XborderPlaceDetails> placeDetails) {
		this.placeDetails = placeDetails;
	}

	public int getXborderCityId() {
		return xborderCityId;
	}

	public void setXborderCityId(int xborderCityId) {
		this.xborderCityId = xborderCityId;
	}

	public String getXborderCityName() {
		return xborderCityName;
	}

	public void setXborderCityName(String xborderCityName) {
		this.xborderCityName = xborderCityName;
	}
}
