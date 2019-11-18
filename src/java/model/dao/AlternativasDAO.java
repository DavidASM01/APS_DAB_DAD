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
import model.bean.Alternativas;

public class AlternativasDAO {
        public void create(Alternativas a) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO alternativas (idquestao,a,b,c,d)VALUES(?,?,?,?,?)");
            stmt.setInt(1, a.getIdquestao());
            stmt.setString(2, a.getA());
            stmt.setString(3, a.getB());
            stmt.setString(4, a.getC());
            stmt.setString(5, a.getD());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Alternativas> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Alternativas> Alternativass = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alternativas");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Alternativas Alternativas = new Alternativas();

                Alternativas.setIdalternativas(rs.getInt("idalternativas"));
                Alternativas.setIdquestao(rs.getInt("idquetao"));
                Alternativas.setA(rs.getString("a"));
                Alternativas.setB(rs.getString("b"));
                Alternativas.setC(rs.getString("c"));
                Alternativas.setD(rs.getString("d"));
                Alternativass.add(Alternativas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Alternativass;

    }
    public List<Alternativas> readForAlter(int alter) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Alternativas> Alternativass = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alternativas WHERE idquestao LIKE ?");
            stmt.setInt(1,alter);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Alternativas Alternativas = new Alternativas();
                
                Alternativas.setA(rs.getString("a"));
                Alternativas.setB(rs.getString("b"));
                Alternativas.setC(rs.getString("c"));
                Alternativas.setD(rs.getString("d"));
                Alternativass.add(Alternativas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Alternativass;

    }

    public void update(Alternativas a) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE alternativas SET idquestao = ?, a = ?, b = ?, c = ?, d = ? WHERE idalternativas = ?");
            stmt.setInt(1, a.getIdquestao());
            stmt.setString(2, a.getA());
            stmt.setString(3, a.getB());
            stmt.setString(4, a.getC());
            stmt.setString(5, a.getD());
            stmt.setInt(6, a.getIdalternativas());;

            stmt.executeUpdate();

            
        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Alternativas a) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM alternativas WHERE idalternativas = ?");
            stmt.setInt(1, a.getIdalternativas());

            stmt.executeUpdate();

            
        } catch (SQLException ex) {
           Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
    
    

