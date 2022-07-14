package com.qa.hobbyproj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Riders {

	// Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String riderName;

	private String teamName;

	private String sponsorName;

	// Default Constructor
	public Riders() {
		super();
	}

	// Constructor without ID
	public Riders(String riderName, String teamName, String sponsorName) {
		super();
		this.riderName = riderName;
		this.teamName = teamName;
		this.sponsorName = sponsorName;
	}

	// Everything Constructor
	public Riders(Integer id, String riderName, String teamName, String sponsorName) {
		super();
		this.id = id;
		this.riderName = riderName;
		this.teamName = teamName;
		this.sponsorName = sponsorName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

}
