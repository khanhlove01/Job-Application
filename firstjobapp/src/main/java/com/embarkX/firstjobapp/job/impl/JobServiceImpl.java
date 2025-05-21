package com.embarkX.firstjobapp.job.impl;

import com.embarkX.firstjobapp.job.Job;
import com.embarkX.firstjobapp.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job: jobs){
            if(job.getId().equals(id)) return job;
        }
        return null;
//        if (id >= 0 && id < jobs.size()) {
//            return jobs.get(Math.toIntExact(id));
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found with ID: " + id);
//        }
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }


}
