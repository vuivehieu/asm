package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import com.example.asm.entity.ResultNMapEntity;
import com.example.asm.entity.SubdomainIpEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISubdomainIpRepository extends JpaRepository<SubdomainIpEntity, Integer> {
    @Query(value = "SELECT * FROM ip_subdomains d WHERE d.ip LIKE %:d% or d.id LIKE %:d%",nativeQuery = true)
    Page<SubdomainIpEntity> searchAllBy(Pageable pageable, @Param("d") String d);
    @Query(value = "select * from ip_subdomains d where d.id_subdomain = :id", nativeQuery = true)
    SubdomainIpEntity findBySubdomainId(@Param("id") Integer id);
    @Modifying
    @Query(value = "delete from ip_subdomains where id_subdomain = :id", nativeQuery = true)
    void deleteBySubdomainId(@Param("id") Integer id);
}
