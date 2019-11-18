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
import model.bean.Questao;

public class QuestaoDAO {
        public void create(Questao q) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Questao (enunciado,correta,score)VALUES(?,?,?)");
            stmt.setString(1, q.getEnunciado());
            stmt.setString(2, q.getCorreta());
            stmt.setInt(3, q.getScore());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Questao> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questao> Questaos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Questao");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Questao Questao = new Questao();

                Questao.setIdquestao(rs.getInt("idquestao"));
                Questao.setEnunciado(rs.getString("enunciado"));
                Questao.setCorreta(rs.getString("correta"));
                Questao.setScore(rs.getInt("score"));
                Questaos.add(Questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Questaos;

    }
    public List<Questao> readForIDquestao(int IDquestao) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questao> Questaos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Questao WHERE idquestao LIKE ?");
            stmt.setInt(1, IDquestao);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Questao Questao = new Questao();

                Questao.setIdquestao(rs.getInt("idquestao"));
                Questao.setEnunciado(rs.getString("enunciado"));
                Questao.setCorreta(rs.getString("correta"));
                Questao.setScore(rs.getInt("score"));
                Questaos.add(Questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Questaos;

    }
    
    
    public List<Questao> readForCorrecao(int IDquestao) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questao> Questaos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Questao WHERE idquestao LIKE ?");
            stmt.setInt(1, IDquestao);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Questao Questao = new Questao();

                Questao.setCorreta(rs.getString("correta"));
                Questaos.add(Questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Questaos;

    }
    
    
    
    public void update(Questao q) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Questao SET enunciado = ? ,correta = ?,score = ? WHERE idquestao = ?");
            stmt.setString(1, q.getEnunciado());
            stmt.setString(2, q.getCorreta());
            stmt.setInt(3, q.getScore());
            stmt.setInt(4, q.getIdquestao());;

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Questao q) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Questao WHERE idquestao = ?");
            stmt.setInt(1, q.getIdquestao());

            stmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(AlternativasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
    
    

