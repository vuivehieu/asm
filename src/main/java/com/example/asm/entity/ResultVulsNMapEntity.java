package com.example.asm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_result_vuls_nmap")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultVulsNMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "output")
    private String outPut;
    @ManyToOne(targetEntity = SubdomainIpEntity.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "subdomain_ip_id")
    private SubdomainIpEntity subdomainIp;
}
