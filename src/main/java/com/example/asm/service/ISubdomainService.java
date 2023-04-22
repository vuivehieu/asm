package com.example.asm.service;

import com.example.asm.dto.SubdomainDto;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public interface ISubdomainService extends IBaseService<SubdomainDto>{
    Map<String, Object> getMoreInformation(Integer id);
    void export(Integer id, HttpServletResponse response);
    Boolean deleteById(Integer id);
}
