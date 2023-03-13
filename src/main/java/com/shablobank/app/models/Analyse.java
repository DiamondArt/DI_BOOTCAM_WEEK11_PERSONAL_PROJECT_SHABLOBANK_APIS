package com.shablobank.app.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tanalyse")
public class Analyse extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ libelle est obligatoire")
    @NotBlank(message = "Le champ libelle ne peut etre vide")
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "analyses",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BloodAnalyse> analyse;
}
