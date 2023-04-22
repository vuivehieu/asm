package com.example.asm.service.imp;

import com.example.asm.dto.CveDto;
import com.example.asm.dto.ResultVulsNMapDto;
import com.example.asm.mapper.CveMapper;
import com.example.asm.repository.ICveRepository;
import com.example.asm.service.ICveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CveServiceImp implements ICveService {
    @Autowired
    ICveRepository cveRepository;
    @Autowired
    CveMapper cveMapper;

    @Override
    public Page<CveDto> findAllPage(Pageable pageable) {
        return cveRepository.findAll(pageable).map(cve -> cveMapper.toDto(cve));
    }

    public Page<CveDto> findAllPageByDomainId(Pageable pageable, int domainId) {
        return cveRepository.findAllByDomainId(pageable, domainId).map(cve -> cveMapper.toDto(cve));
    }

    @Override
    public Page<CveDto> searchPage(Pageable pageable, String search) {
        return cveRepository.searchAllBy(pageable, search).map(cve -> cveMapper.toDto(cve));
    }

    @Override
    public List<CveDto> findAll() {
       return cveRepository.findAll().stream().map(x -> cveMapper.toDto(x)).collect(Collectors.toList());
    }
}
