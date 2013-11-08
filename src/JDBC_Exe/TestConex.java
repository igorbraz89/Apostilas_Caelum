package JDBC_Exe;

import java.sql.*;
import java.util.Calendar;


public class TestConex {
    public static void main(String[] args) throws SQLException {
    	
    
    	
        Connection con= new ConnectionFactory().getConnection();
        
     

        // cria um preparedStatement
        String sql = "insert into contatos" +
                " (nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, "Giran");
        stmt.setString(2, "giran@giran.com.br");
        stmt.setString(3, "Jardim da Penha, Vitoria-ES");
        stmt.setDate(4, new java.sql.Date(
                Calendar.getInstance().getTimeInMillis()));

        // executa
        stmt.execute();
        stmt.close();
        System.out.println("Gravado!");
        
        con.close();
        System.out.println("conex‹o encerrada");
    	
    }
}