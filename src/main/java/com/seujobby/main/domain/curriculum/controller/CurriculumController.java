package com.seujobby.main.domain.curriculum.controller;

import com.seujobby.main.domain.curriculum.service.CurriculumService;
import com.seujobby.main.domain.dtos.CurriculumRequest;
import com.seujobby.main.domain.dtos.CurriculumResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void getOne(){

    }

    @GetMapping
    public void getAll(){

    }

    @PatchMapping
    public void update(){

    }

    @DeleteMapping
    public void delete(){

    }
}
