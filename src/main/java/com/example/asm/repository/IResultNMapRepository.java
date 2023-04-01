package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import com.example.asm.entity.ResultNMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResultNMapRepository extends JpaRepository<ResultNMapEntity, Integer> {
}
