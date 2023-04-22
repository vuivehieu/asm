package com.example.asm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_cve")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cve_id")
    private String cveId;
    @Column(name = "cvss_point")
    private Float cvssPoint;
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "web_tech")
    private String webTech;
    @Column(name = "link")
    private String link;
    @ManyToOne(targetEntity = DomainEntity.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "domain_id")
    private DomainEntity domainEntity;
}
