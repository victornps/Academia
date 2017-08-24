package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import util.DataBase;

public class AlunoDAO {
    
    private final DataBase db;

    public AlunoDAO(){
        db = new DataBase();
    }
    
    public void insert(Aluno aluno){
        String sql = "INSERT INTO TB_ALUNOS (ALU_NOME,ALU_CPF,ALU_SEXO,ALU_NASC,ALU_FONE,ALU_EMAIL,ALU_LOGRADOURO,ALU_NUMERO,ALU_COMPLEMENTO,ALU_CEP,ALU_BAIRRO,ALU_FAIXA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getSexo());
            ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(aluno.getDataNascimento()));
            ps.setString(5, aluno.getFone());
            ps.setString(6, aluno.getEmail());
            ps.setString(7, aluno.getLogradouro());
            ps.setString(8, aluno.getNumero());
            ps.setString(9, aluno.getComplemento());
            ps.setString(10, aluno.getCep());
            ps.setString(11, aluno.getBairro());
            ps.setString(12, aluno.getFaixa());
            ps.executeUpdate();
        
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
        }finally{
            db.close();
        }
        
    }
    
    public List<Aluno> selectAll(){
        String sql = "SELECT * FROM TB_ALUNOS";
        try{
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList();
            while (rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("ALU_ID"));
                aluno.setNome(rs.getString("ALU_NOME"));
                aluno.setCpf(rs.getString("ALU_CPF"));
                aluno.setSexo(rs.getString("ALU_SEXO"));
                aluno.setDataNascimento(rs.getDate("ALU_NASC"));
                aluno.setFone(rs.getString("ALU_FONE"));
                aluno.setEmail(rs.getString("ALU_EMAIL"));
                aluno.setLogradouro(rs.getString("ALU_LOGRADOURO"));
                aluno.setNumero(rs.getString("ALU_NUMERO"));
                aluno.setComplemento(rs.getString("ALU_COMPLEMENTO"));
                aluno.setCep(rs.getString("ALU_CEP"));
                aluno.setBairro(rs.getString("ALU_BAIRRO"));
                aluno.setFaixa(rs.getString("ALU_FAIXA"));
                alunos.add(aluno);
                
            }
            db.close();
            return alunos;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }
        db.close();
        return null;
    }
    
    public void delete(Aluno aluno) {
        db.open();
        String sql = "DELETE FROM TB_ALUNOS WHERE ALU_ID= ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, aluno.getId());
            ps.executeUpdate();
            System.out.println("EXCLUIDO");
        } catch(SQLException error) {
            System.out.println("ERRO: " + error.toString());
        }finally{
          db.close();  
        }
        
    }
    
    public void update(Aluno aluno) {
        db.open();
        String sql = "UPDATE TB_ALUNOS SET ALU_NOME = ?,ALU_CPF = ?,ALU_SEXO = ?,ALU_NASC = ?,ALU_FONE = ?,ALU_EMAIL = ?,ALU_LOGRADOURO = ?,ALU_NUMERO = ?,ALU_COMPLEMENTO = ?,ALU_CEP = ?,ALU_BAIRRO = ?,ALU_FAIXA = ? WHERE ALU_ID = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getSexo());
            ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(aluno.getDataNascimento()));
            ps.setString(5, aluno.getFone());
            ps.setString(6, aluno.getEmail());
            ps.setString(7, aluno.getLogradouro());
            ps.setString(8, aluno.getNumero());
            ps.setString(9, aluno.getComplemento());
            ps.setString(10, aluno.getCep());
            ps.setString(11, aluno.getBairro());
            ps.setString(12, aluno.getFaixa());
            ps.setInt(13, aluno.getId());
            ps.executeUpdate();
            System.out.println("ATUALIZADO");
        } catch(SQLException error) {
            System.out.println("ERRO:(UPDATE) " + error.toString());
        }finally{
           db.close(); 
        }
        
    }
    
    public Aluno selectById(int id){
        try{
            String sql = "SELECT * FROM TB_ALUNOS WHERE ALU_ID = ?";
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Aluno aluno = new Aluno();
            if (rs.next()){
                aluno.setId(rs.getInt("ALU_ID"));
                aluno.setNome(rs.getString("ALU_NOME"));
                aluno.setCpf(rs.getString("ALU_CPF"));
                aluno.setSexo(rs.getString("ALU_SEXO"));
                aluno.setDataNascimento(rs.getDate("ALU_NASC"));
                aluno.setFone(rs.getString("ALU_FONE"));
                aluno.setNome(rs.getString("ALU_EMAIL"));
                aluno.setLogradouro(rs.getString("ALU_LOGRADOURO"));
                aluno.setNumero(rs.getString("ALU_NUMERO"));
                aluno.setComplemento(rs.getString("ALU_COMPLEMENTO"));
                aluno.setCep(rs.getString("ALU_CEP"));
                aluno.setBairro(rs.getString("ALU_BAIRRO"));
                aluno.setFaixa(rs.getString("ALU_FAIXA"));
            }
            db.close();
            return aluno;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }finally{
            db.close();
            return null;
        }
    }
    
    public List<Aluno> selectByLike(String filter){
      List<Aluno> alunos = new ArrayList();
      String filtro = "%" + filter + "%";
        try{
            db.open();
            String sql = "SELECT * FROM TB_ALUNOS WHERE ALU_NOME LIKE ? OR ALU_FONE LIKE ?";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("ALU_ID"));
                aluno.setNome(rs.getString("ALU_NOME"));
                aluno.setFone(rs.getString("ALU_FONE"));
                alunos.add(aluno);
                
            }
            db.close();
            return alunos;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }finally{
        db.close();
        return alunos;  
        }
    }
    
    
}

