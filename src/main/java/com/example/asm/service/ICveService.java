package com.example.asm.service;

import com.example.asm.dto.CveDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICveService extends IBaseService<CveDto> {
    List<CveDto> findAll();

    Page<CveDto> findAllPageByDomainId(Pageable pageable, int domainId);
}
