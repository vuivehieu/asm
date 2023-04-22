package com.example.asm.repository;

import com.example.asm.entity.DomainEntity;
import com.example.asm.entity.ResultNMapEntity;
import com.example.asm.entity.ResultNucleiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IResultNucleiRepository extends JpaRepository<ResultNucleiEntity, Integer> {
    @Query(value = "SELECT * FROM result_nuclei d WHERE d.protocol LIKE %:d% OR " +
            "d.vulnerability_name LIKE %:d% or " +
            "d.id LIKE %:d%", nativeQuery = true)
    Page<ResultNucleiEntity> searchAllBy(Pageable pageable, @Param("d") String d);

    @Query(value = "SELECT * FROM result_nuclei d WHERE d.id_ip = :id", nativeQuery = true)
    List<ResultNucleiEntity> findAllBySubdomainIpId(@Param("id") Integer id);
    @Modifying

    @Query(value = "delete from result_nuclei where id_ip = :id", nativeQuery = true)
    void deleteBySubdomainIpId(@Param("id") Integer id);
}
