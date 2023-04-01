package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import com.example.asm.entity.SubdomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubdomainRepository extends JpaRepository<SubdomainEntity, Integer> {
}
