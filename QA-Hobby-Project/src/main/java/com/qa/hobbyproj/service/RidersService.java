package com.qa.hobbyproj.service;

import java.util.List;

import com.qa.hobbyproj.entity.Riders;

public interface RidersService {

	Riders getById(Integer id);

	List<Riders> getAll();

//	Riders findByRiderName(String riderName);
//
//	Riders getByTeamName(String teamName);
//
//	Riders findBySponsorName(String sponsorName);

	Riders create(Riders rider);

	Riders update(Integer id, String riderName, String teamName, String sponsorName);

	void delete(Integer id);
}
