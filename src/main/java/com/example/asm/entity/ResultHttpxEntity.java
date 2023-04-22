package com.example.asm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_result_httpx")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultHttpxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "output")
    private String output;
    @ManyToOne(targetEntity = DomainEntity.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "domain_id")
    private DomainEntity domainEntity;
}
