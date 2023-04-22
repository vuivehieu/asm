package com.example.asm.service;

import com.example.asm.dto.DomainDto;
import com.example.asm.entity.DomainEntity;
import jakarta.servlet.http.HttpServletResponse;

public interface IDomainService extends IBaseService<DomainDto>{
    public void exportToExcel(Integer id, HttpServletResponse response);
}
