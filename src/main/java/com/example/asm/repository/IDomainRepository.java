package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDomainRepository extends JpaRepository<DomainEntity, Integer> {
    @Query("SELECT d FROM DomainEntity d WHERE d.domainName LIKE %:d%")
    Page<DomainEntity> searchAllBy(Pageable pageable, @Param("d") String d);
}
