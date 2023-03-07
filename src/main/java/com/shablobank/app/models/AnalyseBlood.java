package com.shablobank.app.models;
import lombok.*;

import javax.persistence.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tanalyseblood")
public class AnalyseBlood extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "bloodBag_id")
    BloodBag bloodBag;

    @ManyToOne
    @JoinColumn(name = "analyse_id")
    Analyses analyses;

}
