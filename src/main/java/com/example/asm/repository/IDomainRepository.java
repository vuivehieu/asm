package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDomainRepository extends JpaRepository<DomainEntity, Integer> {

}
