package webservice;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.dao.QuestaoDAO;
import model.bean.Questao;
import model.dao.AlternativasDAO;
import model.bean.Alternativas;
import model.dao.UsuarioDAO;
import model.bean.Usuario;

@WebService(serviceName = "ProvaWebService")
public class ProvaWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "createquestao")
    public void q(@WebParam(name = "enunciado") String enunciado, @WebParam(name = "correta") String correta, @WebParam(name = "score") int score) {
        Questao q = new Questao();
        QuestaoDAO dao = new QuestaoDAO();
        q.setEnunciado(enunciado);
        q.setCorreta(correta);
        q.setScore(score);
        dao.create(q);
    }

    @WebMethod(operationName = "createalternativa")
    public void w(@WebParam(name = "idquestao") int idquestao, @WebParam(name = "a") String a, @WebParam(name = "b") String b, @WebParam(name = "c") String c, @WebParam(name = "d") String d) {
        Alternativas w = new Alternativas();
        AlternativasDAO dao = new AlternativasDAO();
        w.setIdquestao(idquestao);
        w.setA(a);
        w.setB(b);
        w.setC(c);
        w.setD(d);
        dao.create(w);
    }

    @WebMethod(operationName = "createusuario")
    public void u(@WebParam(name = "nome") String nome, @WebParam(name = "senha") String senha, @WebParam(name = "tipo") String tipo) {
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        u.setNome(nome);
        u.setSenha(senha);
        u.setTipo(tipo);

        dao.create(u);

    }

    @WebMethod(operationName = "consultquestao")
    public List<Questao> qt(@WebParam(name = "idquestao") int idquestao) {
        QuestaoDAO dao = new QuestaoDAO();
        return dao.readForIDquestao(idquestao);
    }

    @WebMethod(operationName = "allquestao")
    public List<Questao> all () {
        QuestaoDAO dao = new QuestaoDAO();
        return dao.read();
    }
    
    
    
    @WebMethod(operationName = "consultalternativas")
    public List<Alternativas> at(@WebParam(name = "idquestao") int idquestao) {
        AlternativasDAO dao = new AlternativasDAO();
        return dao.readForAlter(idquestao);
    }

    @WebMethod(operationName = "updatequestao")
    public void upq(@WebParam(name = "idquestao") int idquestao, @WebParam(name = "enunciado") String enunciado, @WebParam(name = "correta") String correta, @WebParam(name = "score") int score) {
        Questao upq = new Questao();
        QuestaoDAO dao = new QuestaoDAO();
        upq.setIdquestao(idquestao);
        upq.setEnunciado(enunciado);
        upq.setCorreta(correta);
        upq.setScore(score);
        dao.update(upq);
    }

    @WebMethod(operationName = "updatealternativa")
    public void upat(@WebParam(name = "idquestao") int idquestao, @WebParam(name = "a") String a, @WebParam(name = "b") String b, @WebParam(name = "c") String c, @WebParam(name = "d") String d) {
        Alternativas upat = new Alternativas();
        AlternativasDAO dao = new AlternativasDAO();
        upat.setIdquestao(idquestao);
        upat.setA(a);
        upat.setB(b);
        upat.setC(c);
        upat.setD(d);
        dao.update(upat);
    }

       @WebMethod(operationName = "updateusuario")
    public void upu(@WebParam(name = "idusuario") int idusuario,@WebParam(name = "nome") String nome, @WebParam(name = "senha") String senha, @WebParam(name = "tipo") String tipo) {
        Usuario upu = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        upu.setIdusuario(idusuario);
        upu.setNome(nome);
        upu.setSenha(senha);
        upu.setTipo(tipo);
        dao.update(upu);

    }
   
    
    @WebMethod(operationName = "consultcorrecao")
    public List<Questao> core(@WebParam(name = "idquestao") int idquestao) {
        QuestaoDAO dao = new QuestaoDAO();
        return dao.readForCorrecao(idquestao);
    }
    

}
