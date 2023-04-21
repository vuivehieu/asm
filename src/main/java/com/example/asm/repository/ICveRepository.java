package com.example.asm.repository;

import com.example.asm.entity.CveEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICveRepository extends JpaRepository<CveEntity, Long> {
    @Query(value = "SELECT * FROM tbl_cve cve WHERE cve.cve_id LIKE %:d% " +
            "OR cve.cvss_point LIKE %:d% " +
            "OR cve.descriptions LIKE %:d% " +
            "OR cve.link LIKE %:d% " +
            "OR cve.web_tech LIKE %:d% ", nativeQuery = true)
    Page<CveEntity> searchAllBy(Pageable pageable, @Param("d") String d);
}
