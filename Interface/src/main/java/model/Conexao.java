package model;

import java.sql.*;

public class Conexao {

    private static String UrlConection = "jdbc:postgresql://localhost:5432/postgres";
    private static String User = "postgres";
    private static String Password = "ASAapp";

    public static Connection conexao() throws SQLException{
        return  DriverManager.getConnection(UrlConection,User,Password);
    }
}

