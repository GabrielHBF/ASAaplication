package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class comandoSql {

    public void insertComand(String nome,String email,String password){

        String sql = "INSERT INTO users (nome, email, senha) VALUES (?, ?, ?)";
        try(Connection conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();

            System.out.println("Usuário inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}