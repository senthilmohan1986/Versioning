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

@Table(name = "XBORDER_COUNTRY_DETAILS")
@Entity
public class XborderCountryDetails extends XborderSocialData{

	@Id
	@Column(name = "XBORDER_COUNTRY_ID")
	private int xborderCountryId;
	
	@Column(name = "XBORDER_COUNTRY_NAME")
	private String xborderCountryName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "XBORDER_CITY_ID" , insertable=false,updatable=false)
	private List<XborderCityDetails> cityDetails;
	
	public List<XborderCityDetails> getCityDetails() {
		return cityDetails;
	}

	public void setCityDetails(List<XborderCityDetails> cityDetails) {
		this.cityDetails = cityDetails;
	}

	public int getXborderCountryId() {
		return xborderCountryId;
	}
	
	public void setXborderCountryId(int xborderCountryId) {
		this.xborderCountryId = xborderCountryId;
	}

	public String getXborderCountryName() {
		return xborderCountryName;
	}

	public void setXborderCountryName(String xborderCountryName) {
		this.xborderCountryName = xborderCountryName;
	}
}
