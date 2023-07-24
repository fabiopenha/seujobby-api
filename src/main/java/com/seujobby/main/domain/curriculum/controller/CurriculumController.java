package com.seujobby.main.domain.curriculum.controller;

import com.seujobby.main.domain.curriculum.service.CurriculumService;
import com.seujobby.main.domain.dtos.CurriculumRequest;
import com.seujobby.main.domain.dtos.CurriculumResponse;
import com.seujobby.main.domain.dtos.CurriculumUpdatedRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/seujobby/curriculum")
public class CurriculumController {
    @Autowired
    private CurriculumService curriculumService;

    @PostMapping
    public ResponseEntity<CurriculumResponse> create(@RequestBody @Valid CurriculumRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(curriculumService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurriculumResponse> getOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(curriculumService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<Page<CurriculumResponse>> getAll(@PageableDefault(size = 10) Pageable pagination){
        return ResponseEntity.status(HttpStatus.OK).body(curriculumService.getAll(pagination));
    }

    @PatchMapping("{id}")
    public ResponseEntity<CurriculumResponse> update(@RequestBody CurriculumUpdatedRequest request, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(curriculumService.update(request, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(curriculumService.delete(id));
    }
}