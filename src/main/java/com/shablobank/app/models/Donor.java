package com.shablobank.app.models;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tdonors")
public class Donor extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;
    @Column(name = "lastName", length = 150, nullable = false)
    private String lastName;
    @Column(name = "email", length = 250, nullable = true)
    private String email;
    @Column(name = "phone", length = 250, nullable = false)
    private String phone;
    @Column(name = "typeDonor", length = 100, nullable = false)
    private String typeDonor;

    @Column(name = "typeBlood", length = 3, nullable = false)
    private String typeBlood;
    @Embedded
    private Adresse adresse;

    @Column(name = "idHopital")
    private Integer idHopital;

    //@OneToMany(mappedBy = "donor")
    //private List<Bloods> bloods;

}
