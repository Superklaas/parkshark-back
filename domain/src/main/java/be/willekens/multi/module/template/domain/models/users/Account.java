package be.willekens.multi.module.template.domain.models.users;

import javax.persistence.*;

import static be.willekens.multi.module.template.infrastructure.utils.EmailUtils.*;

@Entity
@Table(name= "accounts" )
public class Account {

    @Id
    @Column(name="account_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name= "email", unique=true)
    private String email;
    @Column(name="password")
    private String EncryptedPassword;
    @Enumerated(value=EnumType.STRING)
    @Column(name="role")
    private Role role;

    public Account(String email, String encryptedPassword, Role role) {
        assertIsValidEmailOrThrowException(email);
        this.email = email;
        EncryptedPassword = encryptedPassword;
        this.role = role;
    }

    public Account() {
    }

    public String getEmail() {
        return email;
    }

    public String getEncryptedPassword() {
        return EncryptedPassword;
    }

    public Role getRole() {
        return role;
    }
}
