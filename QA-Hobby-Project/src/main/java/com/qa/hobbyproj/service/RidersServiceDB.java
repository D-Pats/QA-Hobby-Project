package com.qa.hobbyproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.hobbyproj.entity.Riders;
import com.qa.hobbyproj.repo.RidersRepo;

@Service
@Primary
public class RidersServiceDB implements RidersService {

	@Autowired
	private RidersRepo repo;

	@Override
	public Riders getById(Integer id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

	@Override
	public List<Riders> getAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

//	@Override
//	public Riders findByRiderName(String riderName) {
//		// TODO Auto-generated method stub
//		return this.repo.findByRiderNameIgnoreCase(riderName);
//	}
//
//	@Override
//	public Riders getByTeamName(String teamName) {
//		// TODO Auto-generated method stub
//		return this.repo.findByTeamNameIgnoreCase(teamName);
//	}

//	@Override
//	public Riders findBySponsorName(String sponsorName) {
//		// TODO Auto-generated method stub
//		return this.repo.findBySponsorNameIgnoreCase(sponsorName);
//	}

	@Override
	public Riders create(Riders rider) {
		// TODO Auto-generated method stub
		return this.repo.save(rider);
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
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
	}
}
