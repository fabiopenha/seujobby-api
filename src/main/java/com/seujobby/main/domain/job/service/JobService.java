package com.seujobby.main.domain.job.service;

import com.seujobby.main.domain.dtos.JobRequest;
import com.seujobby.main.domain.dtos.JobResponse;
import com.seujobby.main.domain.dtos.JobUpdatedRequest;
import com.seujobby.main.domain.job.Job;
import com.seujobby.main.domain.job.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public JobResponse create(JobRequest request){
        Job job = modelMapper.map(request, Job.class);
        job.setId(null);
        Job savedJob = repository.save(job);
        return modelMapper.map(savedJob, JobResponse.class);
    }

    public JobResponse getOne(Long id){
        Job job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        return modelMapper.map(job, JobResponse.class);
    }

    public Page<JobResponse> getAll(Pageable pagination){
        Page<Job> jobPage = repository.findAllByActiveTrue(pagination);
        List<JobResponse> jobResponseList = jobPage
                .stream()
                .map(job -> modelMapper.map(job, JobResponse.class))
                .collect(Collectors.toList());

        return new PageImpl<>(jobResponseList, jobPage.getPageable(), jobPage.getTotalElements());
    }

    public JobResponse update(JobUpdatedRequest request, Long id){
        Job job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        Job entity = modelMapper.map(request, Job.class);
        entity.setId(job.getId());
        Job jobUpdated = repository.save(entity);
        return modelMapper.map(jobUpdated, JobResponse.class);
    }

    public String delete(Long id){
        Job job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        repository.deleteById(job.getId());
        return "Vaga deletada com sucesso!";
    }
}
