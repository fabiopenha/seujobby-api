package com.seujobby.main.domain.curriculum.service;

import com.seujobby.main.domain.curriculum.Curriculum;
import com.seujobby.main.domain.curriculum.repository.CurriculumRepository;
import com.seujobby.main.domain.dtos.CurriculumRequest;
import com.seujobby.main.domain.dtos.CurriculumResponse;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void getOne(){

    }

    public void getAll(){

    }

    public void update(){

    }

    public void delete(){

    }
}
