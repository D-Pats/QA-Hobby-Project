package com.qa.hobbyproj.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobbyproj.entity.Riders;
import com.qa.hobbyproj.service.RidersService;

@CrossOrigin
@RestController
public class RidersController {

	@Autowired
	private RidersService service;

	@GetMapping("/getRiders")
	public List<Riders> getAll() {
		return this.service.getAll();
	}

//	@GetMapping("/getRidersById/{id}")
//	public Riders getByID(@PathVariable Integer id) {
//		return this.service.getById(id);
//	}

//	@GetMapping("/getRidersByTeamName/{teamName}")
//	public Riders getByTeamName(@PathVariable String teamName) {
//		return this.service.getByTeamName(teamName);
//	}

	@PostMapping("/createRiders")
	public ResponseEntity<Riders> create(@RequestBody Riders rider) {
		System.out.println("Created: " + rider);
		Riders created = this.service.create(rider);
		return new ResponseEntity<Riders>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/updateRiders/{id}")
	public Riders update(@PathVariable Integer id, @PathParam("riderName") String riderName,
			@PathParam("teamName") String teamName, @PathParam("sponsorName") String sponsorName) {
		return this.service.update(id, riderName, teamName, sponsorName);
	}

	@DeleteMapping("/removeRiders/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
