package com.shablobank.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tanalyses")
public class Analyses extends AbstractEntity {
    @Column(name = "anaylyseName")
    private String anaylyseName;
    //@JsonIgnore

    @OneToMany(mappedBy = "analyses")
    Set<AnalyseBlood> analyseBloods;
}
