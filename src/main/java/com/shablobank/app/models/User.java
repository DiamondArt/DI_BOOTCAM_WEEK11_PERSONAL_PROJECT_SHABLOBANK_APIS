package com.shablobank.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tusers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ firstname est obligatoire")
    @NotBlank(message = "Le champ firstname ne peut etre vide")
    @Column(name = "firstname")
    private String firstname;

    @NotNull(message = "Le champ lastname est obligatoire")
    @NotBlank(message = "Le champ lastname ne peut etre vide")
    @Column(name = "lastname")
    private String lastname;

    @NotNull(message = "Le champ email est obligatoire")
    @NotBlank(message = "Le champ email ne peut etre vide")
    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "idHopital")
    private Hopital hopital;


    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;


 public static User superAdmin(Role role){
     User user = new  User();
     user.setFirstname("Melissa");
     user.setLastname("aaaa");
     user.setEmail("hello@gmail.com");
     user.setPassword("helloworld");
     user.setRole(role);

     return user;
 }
}
