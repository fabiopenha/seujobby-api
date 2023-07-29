package com.seujobby.main.domain.job.controller;

import com.seujobby.main.domain.dtos.JobRequest;
import com.seujobby.main.domain.dtos.JobResponse;
import com.seujobby.main.domain.dtos.JobUpdatedRequest;
import com.seujobby.main.domain.job.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/seujobby/job")
public class JobController {

    @Autowired
    JobService jobService;
    @PostMapping
    public ResponseEntity<JobResponse> create(@RequestBody @Valid JobRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.create(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<JobResponse> getOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<Page<JobResponse>> getAll(
            @PageableDefault(size = 10, sort = {"createdAt"},
                    direction = Sort.Direction.DESC) Pageable pagination){
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getAll(pagination));
    }

    @PatchMapping("{id}")
    public ResponseEntity<JobResponse> update(@RequestBody JobUpdatedRequest request, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(jobService.update(request, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(jobService.delete(id));
    }
}
