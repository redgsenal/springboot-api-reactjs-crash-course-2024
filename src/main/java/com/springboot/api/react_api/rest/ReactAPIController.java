package com.springboot.api.react_api.rest;


import com.springboot.api.react_api.domain.Job;
import com.springboot.api.react_api.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReactAPIController {

    private JobService jobService;

    public ReactAPIController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> list(@RequestParam(name = "limit", required = false) Integer limit) {
        List<Job> jobs = new ArrayList<>();
        jobService.list().forEach(jobs::add);
        return (limit == null || limit == 0) ? jobs : jobs.subList(0, limit);
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/jobs/{jobId}")
    public Job findById(@PathVariable Long jobId) {
        Job job = jobService.findById(jobId);
        if (job == null) {
            throw new RuntimeException("job id not found - " + jobId);
        }
        return job;
    }

    @PostMapping("/jobs")
    public void updateJob(@RequestBody Job jobToUpdate) {
        jobService.save(jobToUpdate);
    }

    @PutMapping("/jobs/{jobId}")
    public void updateJob(@PathVariable Long jobId, @RequestBody Job jobToUpdate) {
        Job job = findById(jobId);
        if (job == null) {
            return;
        }
        jobService.save(jobToUpdate);
    }

    @DeleteMapping("/jobs/{jobId}")
    public void deleteJob(@PathVariable Long jobId) {
        jobService.delete(jobId);
    }
}
