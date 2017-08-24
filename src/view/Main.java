package view;

import dao.AlunoDAO;
import java.text.DateFormat;
import java.text.ParseException;
import model.Aluno;


public class Main {
    
    public static void main(String[] args) throws ParseException {
        
        DateFormat f = DateFormat.getDateInstance();
        
        Aluno aluno = new Aluno();
        aluno.setNome("Epaminondas Castalianni");
        aluno.setCpf("54321567543");
        aluno.setSexo("Masculino");
        aluno.setDataNascimento(f.parse("06/02/1998"));
        aluno.setFone("32110554");
        aluno.setEmail("epami-cast@yahoo.com");
        aluno.setLogradouro("Rua Criciuma");
        aluno.setNumero("2031");
        aluno.setComplemento("");
        aluno.setCep("59003-234");
        aluno.setBairro("Potengi");
        aluno.setFaixa("Amarela");
        
        AlunoDAO dao = new AlunoDAO();
        dao.insert(aluno);
        
    }
}
