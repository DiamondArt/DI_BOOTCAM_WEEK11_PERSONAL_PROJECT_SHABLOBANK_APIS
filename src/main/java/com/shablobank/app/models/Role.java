package com.shablobank.app.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "troles")
public class Role extends AbstractEntity{
    @Column(name = "roleName")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
}
