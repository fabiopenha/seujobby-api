package com.seujobby.main.domain.candidate.service;

import com.seujobby.main.domain.candidate.Candidate;
import com.seujobby.main.domain.candidate.repository.CandidateRepository;
import com.seujobby.main.domain.dtos.CandidateRequest;
import com.seujobby.main.domain.dtos.CandidateResponse;
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
public class CandidateService {

    @Autowired
    private CandidateRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public CandidateResponse create(CandidateRequest request){
        Candidate candidate = modelMapper.map(request, Candidate.class);
        Candidate savedCandidate = repository.save(candidate);
        return modelMapper.map(savedCandidate, CandidateResponse.class);
    }
    public CandidateResponse getOne(Long id){
        Candidate candidate = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato com ID " + id + " não encontrado."));
        return modelMapper.map(candidate, CandidateResponse.class);
    }

    public Page<CandidateResponse> getAll(Pageable pagination){
        Page<Candidate> candidatesPage = repository.findAllByActiveTrue(pagination);
        List<CandidateResponse> candidatesResponseList = candidatesPage
                .stream()
                .map(candidate -> modelMapper.map(candidate, CandidateResponse.class))
                .collect(Collectors.toList());

        return new PageImpl<>(candidatesResponseList, candidatesPage.getPageable(),
                candidatesPage.getTotalElements());
    }
    @Transactional
    public CandidateResponse update(CandidateRequest request, Long id){
        Candidate candidate = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro na atualização"));


        Candidate entity = modelMapper.map(request, Candidate.class);
        entity.setId(id);
        Candidate candidateUpdated = repository.save(entity);
        return modelMapper.map(candidateUpdated, CandidateResponse.class);
    }

    @Transactional
    public String delete(Long id){
        Candidate candidate = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado!"));

        repository.deleteById(candidate.getId());

        return "candidato deletado com sucesso!";

    }
}