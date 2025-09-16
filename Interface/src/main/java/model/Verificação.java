package model;

import java.sql.Connection;

public class Verificação {
    public static boolean verifica;

    public void Verificação(String usuario, String senha) {
        comandoSql comanado = new comandoSql();

        if (comanado.selectComand(usuario, senha)) {
            System.out.println("Logado com Sucesso");
            verifica = true;
        } else {
            System.out.println("Email ou senha incorretos!");
          verifica = false;
        }
    }
}
