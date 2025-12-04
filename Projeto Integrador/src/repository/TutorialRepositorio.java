package repository;

import Modelo.Tutorial;
import java.sql.*;
import java.util.ArrayList;

public class TutorialRepositorio implements TutorialDAO {

    @Override
    public void salvar(Tutorial t) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO tutorial(titulo, descricao, categoria) VALUES (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, t.getTitulo());
        stmt.setString(2, t.getDescricao());
        stmt.setString(3, t.getCategoria());

        stmt.execute();
        conn.close();
    }

    @Override
    public ArrayList<Tutorial> buscar(String termo) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM tutorial WHERE titulo LIKE ? OR descricao LIKE ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, "%" + termo + "%");
        stmt.setString(2, "%" + termo + "%");

        ResultSet rs = stmt.executeQuery();
        ArrayList<Tutorial> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(new Tutorial(
                    rs.getInt("idTutorial"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    rs.getString("categoria")
            ));
        }

        conn.close();
        return lista;
    }

    @Override
    public void atualizar(Tutorial t) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "UPDATE tutorial SET titulo=?, descricao=?, categoria=? WHERE idTutorial=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, t.getTitulo());
        stmt.setString(2, t.getDescricao());
        stmt.setString(3, t.getCategoria());
        stmt.setInt(4, t.getIdTutorial());

        stmt.execute();
        conn.close();
    }

    @Override
    public void deletar(int idTutorial) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "DELETE FROM tutorial WHERE idTutorial=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idTutorial);

        stmt.execute();
        conn.close();
    }
}
