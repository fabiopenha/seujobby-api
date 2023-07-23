package com.seujobby.main.domain.company.controller;

import com.seujobby.main.domain.company.service.CompanyService;
import com.seujobby.main.domain.dtos.CompanyRequest;
import com.seujobby.main.domain.dtos.CompanyResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/seujobby/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @PostMapping
    public ResponseEntity<CompanyResponse> create(@RequestBody @Valid CompanyRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getOne(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.OK).body(companyService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> getAll(@PageableDefault(size = 10,  sort= {"corporateName"}) Pageable pagination){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAll(pagination));
    }

    @PatchMapping("{id}")
    public ResponseEntity<CompanyResponse> update(@RequestBody CompanyRequest request, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.update(request, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.delete(id));
    }
}