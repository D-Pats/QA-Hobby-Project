package com.qa.hobbyproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.hobbyproj.entity.Riders;

public interface RidersRepo extends JpaRepository<Riders, Integer> {

	Riders findByRiderNameIgnoreCase(String riderName);

	Riders findByTeamNameIgnoreCase(String teamName);

	Riders findBySponsorNameIgnoreCase(String sponsorName);

}
