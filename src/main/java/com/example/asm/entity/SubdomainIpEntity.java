package com.example.asm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "tbl_subdomain_ips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubdomainIpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ip")
    private String ip;
    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(targetEntity = SubdomainEntity.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "subdomain_id")
    private SubdomainEntity subdomain;
}
