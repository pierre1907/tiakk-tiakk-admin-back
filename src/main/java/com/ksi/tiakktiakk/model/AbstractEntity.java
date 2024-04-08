package com.ksi.tiakktiakk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    @JsonIgnore
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "last_updated_date", nullable = true)
    @JsonIgnore
    private Instant lastUpdatedDate;

    //private String createdBy;



}
