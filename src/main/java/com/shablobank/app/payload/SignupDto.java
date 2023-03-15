package com.shablobank.app.payload;
import com.shablobank.app.models.Adresse;
import com.shablobank.app.models.Hopital;
import com.shablobank.app.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {
    private String lastname;
    private String firstname;
    private Hopital hopital;
    private Role role;
    private Adresse adresse;
    private String email;
    private String password;
}
