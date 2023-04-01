package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import com.example.asm.entity.SubdomainIpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubdomainIpRepository extends JpaRepository<SubdomainIpEntity, Integer> {
}
