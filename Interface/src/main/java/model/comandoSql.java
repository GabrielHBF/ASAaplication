package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class comandoSql {

    public void insertComand(String nome,String email,String password){

        String sql = "INSERT INTO users (nome, email, senha) VALUES (?, ?, ?)";
        try(Connection conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, BCrypt.hashpw(password, BCrypt.gensalt()));
            stmt.executeUpdate();

            System.out.println("Usuário inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public boolean selectComand(String email,String senha) {

        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = Conexao.conexao(); PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                String senhaCryp = rs.getString("senha");
                if (BCrypt.checkpw(senha, senhaCryp)) {
                    return true;
                }
            }else {
                return false;
            };
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return false;
    }



    public boolean selectComand(String email){
        String sql = "SELECT * FROM users WHERE email = ?";

        try(Connection conn = Conexao.conexao(); PreparedStatement stm = conn.prepareStatement(sql)){

            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            return (rs.next());

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }



    public void updateComand(String senha, String email){
        String sql = "UPDATE users SET senha = ? WHERE email = ?";

        try (Connection conn = Conexao.conexao(); PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setString(1, senha);
            stm.setString(2, email);

            stm.executeUpdate();
            System.out.println("Usuario atualizado com sucesso!");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}