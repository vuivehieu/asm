package com.example.asm.repository;

import com.example.asm.entity.ResultHttpxEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IResultHttpxRepository extends JpaRepository<ResultHttpxEntity, Integer> {
    @Query(value = "SELECT d FROM ResultHttpxEntity d WHERE d.output LIKE %:d%")
    Page<ResultHttpxEntity> searchAllBy(Pageable pageable, @Param("d") String d);
}
