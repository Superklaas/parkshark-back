package be.willekens.multi.module.template.domain.models.users;

public class Account {

    private String email;
    private String EncryptedPassword;
    private Role role;

    public Account(String email, String encryptedPassword, Role role) {
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
