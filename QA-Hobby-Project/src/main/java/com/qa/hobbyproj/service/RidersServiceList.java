package com.qa.hobbyproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.hobbyproj.entity.Riders;

@Service
//@Primary
public class RidersServiceList implements RidersService {

	private List<Riders> riders = new ArrayList<>();

	@Override
	public Riders getById(Integer id) {
		// TODO Auto-generated method stub
		return this.riders.get(id);
	}

	@Override
	public List<Riders> getAll() {
		// TODO Auto-generated method stub
		return this.riders;
	}

	@Override
	public Riders findByRiderName(String riderName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Riders findByTeamName(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Riders findBySponsorName(String sponsorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Riders create(Riders rider) {
		// TODO Auto-generated method stub
		this.riders.add(rider);
		return this.riders.get(this.riders.size() - 1);
	}

	@Override
	public Riders update(Integer id, String riderName, String teamName, String sponsorName) {
		// TODO Auto-generated method stub
		Riders toUpdate = this.getById(id);
		if (riderName != null)
			toUpdate.setRiderName(riderName);
		if (teamName != null)
			toUpdate.setTeamName(teamName);
		if (sponsorName != null)
			toUpdate.setSponsorName(sponsorName);
		return toUpdate;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.riders.remove(id);
	}

}
