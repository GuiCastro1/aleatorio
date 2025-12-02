package br.com.starttech.cadastro_user.cadastro_user.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Integer IdUser;
    @Column(name = "NAME")
    private String NameUser;
    @Column(name = "EMAIL")
    private String EmailUser;
    @Column(name = "TELEFONE")
    private String TelefoneUser;
    @Column(name = "PASSWORD")
    private String PasswordUser;

    public String getPasswordUser() {
        return PasswordUser;
    }

    public void setPasswordUser(String passwordUser) {
        PasswordUser = passwordUser;
    }

    public Integer getIdUser() {
        return IdUser;
    }

    public void setIdUser(Integer idUser) {
        IdUser = idUser;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String nameUser) {
        NameUser = nameUser;
    }

    public String getEmailUser() {
        return EmailUser;
    }

    public void setEmailUser(String emailUser) {
        EmailUser = emailUser;
    }

    public String getTelefoneUser() {
        return TelefoneUser;
    }

    public void setTelefoneUser(String telefoneUser) {
        TelefoneUser = telefoneUser;
    }
}
