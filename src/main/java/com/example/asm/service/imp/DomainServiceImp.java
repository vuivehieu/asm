package com.example.asm.service.imp;

import com.example.asm.dto.DomainDto;
import com.example.asm.dto.SubdomainDto;
import com.example.asm.dto.SubdomainIpDto;
import com.example.asm.entity.SubdomainEntity;
import com.example.asm.entity.SubdomainIpEntity;
import com.example.asm.mapper.DomainMapper;
import com.example.asm.mapper.SubdomainIpMapper;
import com.example.asm.mapper.SubdomainMapper;
import com.example.asm.repository.*;
import com.example.asm.service.ExportExcelDomain;
import com.example.asm.service.IDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class DomainServiceImp implements IDomainService {
    @Autowired
    IDomainRepository domainRepository;
    @Autowired
    ICveRepository cveRepository;
    @Autowired
    IResultHttpxRepository resultHttpxRepository;
    @Autowired
    IResultNMapRepository resultNMapRepository;
    @Autowired
    IResultNucleiRepository resultNucleiRepository;
    @Autowired
    IResultVulsNMapRepository resultVulsNMapRepository;
    @Autowired
    ISubdomainIpRepository subdomainIpRepository;
    @Autowired
    ISubdomainRepository subdomainRepository;
    @Autowired
    DomainMapper mapper;
    @Autowired
    SubdomainMapper subdomainMapper;
    @Override
    public Page<DomainDto> findAllPage(Pageable pageable) {
        return this.domainRepository.findAll(pageable).map(x->mapper.toDto(x));
    }

    @Override
    public Page<DomainDto> searchPage(Pageable pageable, String search) {
        return this.domainRepository.searchAllBy(pageable,search).map(mapper::toDto);
    }

    @Override
    public void exportToExcel(Integer id, HttpServletResponse response){
        DomainDto domainDto = mapper.toDto(this.domainRepository.findById(id).orElseThrow());
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=domain_" + id + ".xlsx";
        response.setHeader(headerKey, headerValue);
        ExportExcelDomain exportExcelDomain = new ExportExcelDomain(domainDto);
        try {
            exportExcelDomain.export(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteDomain(Integer id) {
        try {
            cveRepository.deleteByDomainId(id);
            resultHttpxRepository.deleteByDomainId(id);
            List<SubdomainDto> subdomainDtoList = subdomainRepository.getAllByDomainId(id).stream().map(x -> subdomainMapper.toDto(x)).toList();
            for (SubdomainDto subdomainDto : subdomainDtoList) {
                SubdomainIpEntity subdomainIpEntity = subdomainIpRepository.findBySubdomainId(subdomainDto.getId());
                if (subdomainIpEntity != null){
                    resultNMapRepository.deleteBySubdomainIpId(subdomainIpEntity.getId());
                    resultNucleiRepository.deleteBySubdomainIpId(subdomainIpEntity.getId());
                    resultVulsNMapRepository.deleteBySubdomainIpId(subdomainIpEntity.getId());
                    subdomainIpRepository.deleteBySubdomainId(subdomainDto.getId());
                }
            }
            subdomainRepository.deleteByDomainId(id);
            domainRepository.deleteByDomainId(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
