package com.example.asm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "domain")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "domain_name")
    private String domainName;
    @CreationTimestamp
    @Column(name = "date_created")
    private LocalDateTime createdDate;
}
