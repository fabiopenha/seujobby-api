package com.seujobby.main.domain.candidate.controller;

import com.seujobby.main.domain.candidate.service.CandidateService;
import com.seujobby.main.domain.dtos.CandidateRequest;
import com.seujobby.main.domain.dtos.CandidateResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/seujobby/candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;
    @PostMapping
    public ResponseEntity<CandidateResponse> create(@RequestBody @Valid CandidateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> getOne(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.OK).body(candidateService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<Page<CandidateResponse>> getAll(@PageableDefault(size = 10,  sort= {"name"}) Pageable pagination){
        return ResponseEntity.status(HttpStatus.OK).body(candidateService.getAll(pagination));
    }

    @PatchMapping("{id}")
    public ResponseEntity<CandidateResponse> update(@RequestBody CandidateRequest request, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(candidateService.update(request, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(candidateService.delete(id));
    }
}