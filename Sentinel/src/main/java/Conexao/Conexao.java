package Conexao;
import Logger.Mensageiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //Atributos para conexão do banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/prj_sprint";
    private static final String user = "aluno";
    private static final String password = "aluno";

//    private static final String urlSQLServer = "jdbc:sqlserver://ec2-54-159-156-118.compute-1.amazonaws.com:1433;database=prj_sprint" +
//            ";encrypt=false;trustServerCertificate=true;";
//    private static final String userSQLServer = "sa";
//    private static final String passwordSQLServer = "f";
    private static Connection conn; // objeto p/ conexão utilizando a classe Connection
//    private static Connection connSQLServer;


    // Método para verificar se a conexao foi bem sucedida
    public static Connection getConexao(){
        try {
            if (conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else {
                return conn;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

//    public static Connection getConexaoSQLServer(){
//        try {
//            if (connSQLServer == null){
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                connSQLServer = DriverManager.getConnection(urlSQLServer, userSQLServer, passwordSQLServer);
//                return connSQLServer;
//            }else {
//                return connSQLServer;
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//            return null;
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
