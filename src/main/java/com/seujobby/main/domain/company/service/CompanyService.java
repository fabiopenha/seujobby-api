package com.seujobby.main.domain.company.service;

import com.seujobby.main.domain.company.Company;
import com.seujobby.main.domain.company.repository.CompanyRepository;
import com.seujobby.main.domain.dtos.CompanyRequest;
import com.seujobby.main.domain.dtos.CompanyResponse;
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
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public CompanyResponse create(CompanyRequest request){

        Boolean emailExist = repository.existsByResponsibleEmail(request.getResponsibleEmail());

        if(emailExist) {
            throw new RuntimeException("Email já existe");
        }
        Company company = modelMapper.map(request, Company.class);
        Company savedCompany = repository.save(company);
        return modelMapper.map(savedCompany, CompanyResponse.class);
    }
    public CompanyResponse getOne(Long id){
        Company company = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa com ID " + id + " não encontrada."));
        return modelMapper.map(company, CompanyResponse.class);
    }

    public Page<CompanyResponse> getAll(Pageable pagination){
        Page<Company> companyPage = repository.findAllByActiveTrue(pagination);
        List<CompanyResponse> candidatesResponseList = companyPage
                .stream()
                .map(company -> modelMapper.map(company, CompanyResponse.class))
                .collect(Collectors.toList());

        return new PageImpl<>(candidatesResponseList, companyPage.getPageable(),
                companyPage.getTotalElements());
    }
    @Transactional
    public CompanyResponse update(CompanyRequest request, Long id){
        Company company = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro na atualização"));

        Company entity = modelMapper.map(request, Company.class);
        entity.setId(id);
        Company companyUpdated = repository.save(entity);
        return modelMapper.map(companyUpdated, CompanyResponse.class);
    }

    @Transactional
    public String delete(Long id){
        Company company = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("empresa não encontrada!"));

        repository.deleteById(company.getId());

        return "empresa deletada com sucesso!";

    }
}