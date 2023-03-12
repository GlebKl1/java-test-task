package org.task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;
import org.task.enums.Category;
import org.task.validation.PackageServiceValue;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "package_service")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class PackageService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreationTimestamp
    private Date creationDate;

    @NotBlank
    @Size(max = 128)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @PackageServiceValue
    private Integer value;

    private boolean isDeleted = false;

    @PrePersist
    public void setId() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
}
