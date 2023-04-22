package com.example.asm.service;

import com.example.asm.dto.CveDto;

import java.util.List;

public interface ICveService extends IBaseService<CveDto> {
    List<CveDto> findAll();
}
