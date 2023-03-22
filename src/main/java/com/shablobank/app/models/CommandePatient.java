package com.shablobank.app.models;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tcommandepatients")
public class CommandePatient  extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "blood")
    private Bloods blood;

    @Column(name = "rhesus")
    private String rhesus;

    @Column(name = "patient_nom")
    private String patientNom;

    @Column(name = "date_naissance")
    private String dateNaissance;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "idHopital")
    private Integer idHopital;
}
