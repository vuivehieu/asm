package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import com.example.asm.entity.ResultNMapEntity;
import com.example.asm.entity.SubdomainIpEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISubdomainIpRepository extends JpaRepository<SubdomainIpEntity, Integer> {
    @Query(value = "SELECT * FROM tbl_subdomain_ips d WHERE d.ip LIKE %:d% or d.id LIKE %:d%",nativeQuery = true)
    Page<SubdomainIpEntity> searchAllBy(Pageable pageable, @Param("d") String d);
}
