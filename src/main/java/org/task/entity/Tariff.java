package org.task.entity;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "tariffs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;

    @NotBlank
    @Size(max = 128)
    private String name;

    @OneToMany(mappedBy = "tariff", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<PackageService> packageServices;

    @Column(name = "is_archived")
    private boolean isArchived = false;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

}
