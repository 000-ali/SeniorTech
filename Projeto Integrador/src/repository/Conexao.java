package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao{
    public static Connection conectar(){
        Connection conexao = null;
         String url = "jdbc:mysql://localhost:3307/sistema_tutorial";
        String user = "root";
        String pass = "";
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           conexao = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException e){
            System.out.println("Erro: Driver JDBC não encontrado. ");
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return conexao;
    }

    public static void main(String[] args){
        conectar();
    }
}

