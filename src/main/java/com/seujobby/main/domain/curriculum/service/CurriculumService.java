package com.seujobby.main.domain.curriculum.service;

import com.seujobby.main.domain.curriculum.Curriculum;
import com.seujobby.main.domain.curriculum.repository.CurriculumRepository;
import com.seujobby.main.domain.dtos.CurriculumRequest;
import com.seujobby.main.domain.dtos.CurriculumResponse;
import com.seujobby.main.domain.dtos.CurriculumUpdatedRequest;
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
public class CurriculumService {

    @Autowired
    private CurriculumRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public CurriculumResponse create(CurriculumRequest request){
        Curriculum curriculum = modelMapper.map(request, Curriculum.class);
        Curriculum savedCurriculum = repository.save(curriculum);
        return modelMapper.map(savedCurriculum, CurriculumResponse.class);
    }

    public CurriculumResponse getOne(Long id){
        Curriculum curriculum = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currículo com ID " + id + " não encontrado."));
        return modelMapper.map(curriculum, CurriculumResponse.class);
    }

    public Page<CurriculumResponse> getAll(Pageable pagination){
        Page<Curriculum> curriculumPage = repository.findAllByActiveTrue(pagination);
        List<CurriculumResponse> curriculumResponseList = curriculumPage
                .stream()
                .map(curriculum -> modelMapper.map(curriculum, CurriculumResponse.class))
                .collect(Collectors.toList());

        return new PageImpl<>(curriculumResponseList, curriculumPage.getPageable(),
                curriculumPage.getTotalElements());
    }

    @Transactional
    public CurriculumResponse update(CurriculumUpdatedRequest request, Long id){
        Curriculum curriculum = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro na atualização"));

        Curriculum entity = modelMapper.map(request, Curriculum.class);
        entity.setId(curriculum.getId());
        Curriculum curriculumUpdated = repository.save(entity);
        return modelMapper.map(curriculumUpdated, CurriculumResponse.class);
    }
    @Transactional
    public String delete(Long id){
        Curriculum curriculum = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currículo não encontrado!"));

        repository.deleteById(curriculum.getId());
        return "candidato deletado com sucesso!";
    }
}
