package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import com.example.asm.entity.ResultNucleiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResultNucleiRepository extends JpaRepository<ResultNucleiEntity, Integer> {
}
