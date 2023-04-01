package com.example.asm.mapper;

import com.example.asm.dto.ResultNucleiDto;
import com.example.asm.entity.ResultNucleiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultNucleiMapper {
    @Autowired
    SubdomainIpMapper subdomainIpMapper;
    public ResultNucleiDto toDto(ResultNucleiEntity entity){
        return ResultNucleiDto.builder().id(entity.getId())
                .protocol(entity.getProtocol())
                .subdomainIp(subdomainIpMapper.toDto(entity.getSubdomainIp()))
                .vulnerabilityName(entity.getVulnerabilityName())
                .build();
    }
}
