package com.springboot.api.react_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.api.react_api.domain.Job;
import com.springboot.api.react_api.service.JobService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ReactApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(JobService jobService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Job>> typeReference = new TypeReference<List<Job>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/jobs.json");
			try {
				List<Job> jobs = mapper.readValue(inputStream,typeReference);
				jobService.save(jobs);
				System.out.println("Jobs Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
