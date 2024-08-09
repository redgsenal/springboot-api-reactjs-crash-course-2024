package com.springboot.api.react_api.repository;

import com.springboot.api.react_api.domain.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
}
