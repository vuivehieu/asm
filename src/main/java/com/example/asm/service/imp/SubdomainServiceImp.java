package com.example.asm.service.imp;

import com.example.asm.dto.SubdomainDto;
import com.example.asm.mapper.SubdomainMapper;
import com.example.asm.repository.ISubdomainRepository;
import com.example.asm.service.ISubdomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubdomainServiceImp implements ISubdomainService {
    @Autowired
    ISubdomainRepository repository;
    @Autowired
    SubdomainMapper mapper;
    @Override
    public Page<SubdomainDto> findAllPage(Pageable pageable) {
        return this.repository.findAll(pageable).map(x->mapper.toDto(x));
    }

    @Override
    public Page<SubdomainDto> searchPage(Pageable pageable, String search) {
        return this.repository.searchAllBy(pageable,search).map(mapper::toDto);
    }
}
