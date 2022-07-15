package com.qa.hobbyproj.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobbyproj.entity.Riders;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:Riders-schema.sql",
		"classpath:Riders-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class RidersControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Riders testRider = new Riders("FakeName2", "FakeTeam2", "FakeSponsor2");
		String testRiderAsJSON = this.mapper.writeValueAsString(testRider);
		RequestBuilder req = post("/createRiders").content(testRiderAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
		Riders createRider = new Riders(2, "FakeName2", "FakeTeam2", "FakeSponsor2");
		String createdRiderAsJSON = this.mapper.writeValueAsString(createRider);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRiderAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testRead() throws Exception {
		List<Riders> riders = List.of(new Riders(1, "FakeName", "FakeTeam", "FakeSponsor"));
		this.mvc.perform(get("/getRiders")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(riders)));
	}

	@Test
	void testUpdate() throws Exception {
		Riders updated = new Riders(1, "FakeNameUpdated", "FakeTeamUpdated", "FakeSponsorUpdated");
		this.mvc.perform(patch(
				"/updateRiders/1?riderName=FakeNameUpdated&teamName=FakeTeamUpdated&sponsorName=FakeSponsorUpdated"))
				.andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeRiders/1")).andExpect(status().isNoContent());
	}

//	@Test
//	void testReadById() throws Exception {
//		List<Riders> riders = List.of(new Riders(1, "FakeName", "FakeTeam", "FakeSponsor"));
//		this.mvc.perform(get("/getRidersById/1")).andExpect(status().isOk())
//				.andExpect(content().json(this.mapper.writeValueAsString(riders.get(0))));
//	}
}
