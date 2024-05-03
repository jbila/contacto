package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import conexao.Conexao;
import model.Contacto;

public class Dao_contacto {

    private static final String INSERT = "INSERT INTO contacto(nome,contacto,email) VALUES(?,?,?)";
    private static final String LIST = "SELECT * FROM contacto ORDER BY id  ";
    private static final String DELETE = "DELETE FROM contacto WHERE id=?";
    private static final String UPDATE = "UPDATE contacto SET nome=?,email=?,contacto=? WHERE id=? ";

    public void add(Contacto contacto) throws SQLException {
        if (contacto != null) {
            Connection conn = null;
            PreparedStatement stmt;

            try {
                conn = Conexao.connect();
                stmt = conn.prepareStatement(INSERT);
                stmt.setString(1, contacto.getNome());
                stmt.setString(2, contacto.getContacto());
                stmt.setString(3, contacto.getEmail());
                stmt.executeUpdate();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Contacto Cadastrada com Sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            conn.close();
        } else {
            JOptionPane.showMessageDialog(null, "contacto enviado por par�metro est� vazio");
        }

    }

    public ArrayList<Contacto> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Contacto> contactos = new ArrayList<>();

        try {
            conn = Conexao.connect();
            stmt = conn.prepareStatement(LIST);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Contacto contacto = new Contacto();
                contacto.setId(rs.getInt("id"));
                contacto.setNome(rs.getString("nome"));
                contacto.setEmail(rs.getString("email"));
                contacto.setContacto(rs.getString("contacto"));
                contactos.add(contacto);
            } // FECHA O WHILE

            stmt.close();
            rs.close();
            conn.close();
        } // FECHA O TRY
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Contactos" + ex.getMessage());
        }
        return contactos;

    }
    // =========================================================================================================================

    public ArrayList<Contacto> findBy(String nome) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Contacto> contactos = new ArrayList<>();

        try {
            conn = Conexao.connect();
            stmt = conn.prepareStatement("SELECT * FROM contacto WHERE nome LIKE ?");
          stmt.setString(1, "%".concat(nome).concat("%"));
            rs = stmt.executeQuery();

            while (rs.next()) {
                Contacto contacto = new Contacto();
                contacto.setId(rs.getInt("id"));
                contacto.setNome(rs.getString("nome"));
                contacto.setEmail(rs.getString("email"));
                contacto.setContacto(rs.getString("contacto"));
                contactos.add(contacto);
            } // FECHA O WHILE

            stmt.close();
            rs.close();
            conn.close();
        } // FECHA O TRY
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Contactos" + ex.getMessage());
        }
        return contactos;

    }

    public void removerContacto(int id) {

        Connection conn = null;
        PreparedStatement stmt;
        try {
            conn = Conexao.connect();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Contacto Removido com sucesso");
//	  stmt.close(); Conexao.disconect(conn);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a Categoria da base de" + "dados " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------------
    public void updateContacto(Contacto contacto) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt;

        conn = Conexao.connect();
        stmt = conn.prepareStatement(UPDATE);
        stmt.setString(1, contacto.getNome());
        stmt.setString(2, contacto.getContacto());
        stmt.setString(3, contacto.getEmail());
        stmt.setInt(4, contacto.getId());
        stmt.executeUpdate();
        stmt.close();
        JOptionPane.showMessageDialog(null, "Contacto actualizada");

    }

}
