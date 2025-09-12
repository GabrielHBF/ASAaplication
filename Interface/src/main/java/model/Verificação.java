package model;

import java.sql.Connection;

public class Verificação {

    static boolean verificar;
    private String Senha;
    private String Email;

    public Verificação(String Senha, String Email) {
        this.Senha = Senha;
        this.Email = Email;
    }
}
