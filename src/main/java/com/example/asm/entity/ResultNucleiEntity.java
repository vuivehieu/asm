package com.example.asm.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tbl_result_nuclei")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultNucleiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "vulnerability_name")
    private String vulnerabilityName;
    @Column(name = "protocol")
    private String protocol;
    @ManyToOne(targetEntity = SubdomainIpEntity.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "subdomain_ip_id")
    private SubdomainIpEntity subdomainIp;
}
