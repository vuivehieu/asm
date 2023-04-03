package com.example.asm.service.imp;

import com.example.asm.dto.DomainDto;
import com.example.asm.mapper.DomainMapper;
import com.example.asm.repository.IDomainRepository;
import com.example.asm.service.IDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DomainServiceImp implements IDomainService {
    @Autowired
    IDomainRepository domainRepository;
    @Autowired
    DomainMapper mapper;
    @Override
    public Page<DomainDto> findAllPage(Pageable pageable) {
        return this.domainRepository.findAll(pageable).map(x->mapper.toDto(x));
    }

    @Override
    public Page<DomainDto> searchPage(Pageable pageable, String search) {
        return this.domainRepository.searchAllBy(pageable,search).map(mapper::toDto);
    }
}
