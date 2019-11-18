package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Usuario;

public class UsuarioDAO {
        public void create(Usuario u) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Usuario (nome,senha,tipo)VALUES(?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, u.getTipo());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Usuario> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> Usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario Usuario = new Usuario();

                Usuario.setIdusuario(rs.getInt("idusuario"));
                Usuario.setNome(rs.getString("nome"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setTipo(rs.getString("tipo"));
                Usuarios.add(Usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Usuarios;

    }
    public List<Usuario> readForUsoa(String usua) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> Usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE enunciado LIKE ?");
            stmt.setString(1, "%"+usua+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario Usuario = new Usuario();
             
                Usuario.setIdusuario(rs.getInt("idusuario"));
                Usuario.setNome(rs.getString("nome"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setTipo(rs.getString("tipo"));
                Usuarios.add(Usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Usuarios;

    }

    public void update(Usuario u) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Usuario SET nome = ? ,senha = ?,tipo = ? WHERE idusuario = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, u.getTipo());
            stmt.setInt(4, u.getIdusuario());;

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Usuario u) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Usuario WHERE idusuario = ?");
            stmt.setInt(1, u.getIdusuario());

            stmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
    
    

