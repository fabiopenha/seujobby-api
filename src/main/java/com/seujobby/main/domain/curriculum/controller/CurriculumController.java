package com.seujobby.main.domain.curriculum.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/seujobby/curriculum")
public class CurriculumController {
    @PostMapping
    public void create(){

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
