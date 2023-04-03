package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import com.example.asm.entity.ResultNMapEntity;
import com.example.asm.entity.SubdomainEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISubdomainRepository extends JpaRepository<SubdomainEntity, Integer> {
    @Query(value = "SELECT * FROM tbl_subdomains_amass d WHERE d.subdomain_name LIKE %:d% OR " +
            "d.id LIKE %:d%", nativeQuery = true)
    Page<SubdomainEntity> searchAllBy(Pageable pageable, @Param("d") String d);
}
