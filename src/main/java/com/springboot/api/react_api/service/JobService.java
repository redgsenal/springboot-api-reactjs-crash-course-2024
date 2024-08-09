package com.springboot.api.react_api.service;

import com.springboot.api.react_api.domain.Job;
import com.springboot.api.react_api.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Iterable<Job> list() {
        return jobRepository.findAll();
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public Job findById(Long jobId) {
        Optional<Job> result = jobRepository.findById(jobId);
        return result.get();
    }


    public void save(List<Job> jobs) {
        jobRepository.saveAll(jobs);
    }

    public void delete(Long jobId) {
        jobRepository.deleteById(jobId);
    }
}
