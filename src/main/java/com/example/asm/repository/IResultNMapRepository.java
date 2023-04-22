package com.example.asm.repository;

import com.example.asm.entity.ResultNMapEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  IResultNMapRepository extends JpaRepository<ResultNMapEntity, Integer> {
    @Query(value = "SELECT * FROM result_nmap d WHERE d.status LIKE %:d% OR " +
            "d.protocol LIKE %:d% or " +
            "d.port_number LIKE %:d% or " +
            "d.id LIKE %:d%", nativeQuery = true)
    Page<ResultNMapEntity> searchAllBy(Pageable pageable, @Param("d") String d);

    @Query(value = "SELECT * FROM result_nmap d WHERE d.id_ip like %:id%", nativeQuery = true)
    List<ResultNMapEntity> getALlBySubdomainIp(@Param("id") Integer id);

    @Modifying
    @Query(value = "delete from result_nmap where id_ip = :id", nativeQuery = true)
    void deleteBySubdomainIpId(@Param("id") Integer id);
}
