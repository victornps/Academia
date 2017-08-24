package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Instrutor;
import util.DataBase;

public class InstrutorDAO {
    
    private final DataBase db;

    public InstrutorDAO(){
        db = new DataBase();
    }
    
    public void insert(Instrutor instrutor){
        String sql = "INSERT INTO TB_INSTRUTORES (INS_NOME,INS_CPF,INS_SEXO,INS_NASC,INS_FONE,INS_EMAIL,INS_LOGRADOURO,INS_NUMERO,INS_COMPLEMENTO,INS_CEP,INS_BAIRRO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, instrutor.getNome());
            ps.setString(2, instrutor.getCpf());
            ps.setString(3, instrutor.getSexo());
            ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(instrutor.getDataNascimento()));
            ps.setString(5, instrutor.getFone());
            ps.setString(6, instrutor.getEmail());
            ps.setString(7, instrutor.getLogradouro());
            ps.setString(8, instrutor.getNumero());
            ps.setString(9, instrutor.getComplemento());
            ps.setString(10, instrutor.getCep());
            ps.setString(11, instrutor.getBairro());
            
            ps.executeUpdate();
        
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
        }finally{
            db.close();
        }
        
    }
    
    public List<Instrutor> selectAll(){
        String sql = "SELECT * FROM TB_INSTRUTORES";
        try{
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Instrutor> instrutores = new ArrayList();
            while (rs.next()){
                Instrutor instrutor = new Instrutor();
                instrutor.setId(rs.getInt("INS_ID"));
                instrutor.setNome(rs.getString("INS_NOME"));
                instrutor.setCpf(rs.getString("INS_CPF"));
                instrutor.setSexo(rs.getString("INS_SEXO"));
                instrutor.setDataNascimento(rs.getDate("INS_NASC"));
                instrutor.setFone(rs.getString("INS_FONE"));
                instrutor.setEmail(rs.getString("INS_EMAIL"));
                instrutor.setLogradouro(rs.getString("INS_LOGRADOURO"));
                instrutor.setNumero(rs.getString("INS_NUMERO"));
                instrutor.setComplemento(rs.getString("INS_COMPLEMENTO"));
                instrutor.setCep(rs.getString("INS_CEP"));
                instrutor.setBairro(rs.getString("INS_BAIRRO"));
                
                instrutores.add(instrutor);
                
            }
            db.close();
            return instrutores;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }
        db.close();
        return null;
    }
    
    public void delete(Instrutor instrutor) {
        db.open();
        String sql = "DELETE FROM TB_INSTRUTORES WHERE INS_ID= ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, instrutor.getId());
            ps.executeUpdate();
            System.out.println("EXCLUIDO");
        } catch(SQLException error) {
            System.out.println("ERRO: " + error.toString());
        }finally{
          db.close();  
        }
        
    }
    
    public void update(Instrutor instrutor) {
        db.open();
        String sql = "UPDATE TB_INSTRUTORES SET INS_NOME = ?,INS_CPF = ?,INS_SEXO = ?,INS_NASC = ?,INS_FONE = ?,INS_EMAIL = ?,INS_LOGRADOURO = ?,INS_NUMERO = ?,INS_COMPLEMENTO = ?,INS_CEP = ?,INS_BAIRRO = ? WHERE INS_ID = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, instrutor.getNome());
            ps.setString(2, instrutor.getCpf());
            ps.setString(3, instrutor.getSexo());
            ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(instrutor.getDataNascimento()));
            ps.setString(5, instrutor.getFone());
            ps.setString(6, instrutor.getEmail());
            ps.setString(7, instrutor.getLogradouro());
            ps.setString(8, instrutor.getNumero());
            ps.setString(9, instrutor.getComplemento());
            ps.setString(10, instrutor.getCep());
            ps.setString(11, instrutor.getBairro());
            ps.setInt(12, instrutor.getId());
            ps.executeUpdate();
            System.out.println("ATUALIZADO");
        } catch(SQLException error) {
            System.out.println("ERRO:(UPDATE) " + error.toString());
        }finally{
           db.close(); 
        }
        
    }
    
    public Instrutor selectById(int id){
        try{
            String sql = "SELECT * FROM TB_INSTRUTORES WHERE INS_ID = ?";
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Instrutor instrutor = new Instrutor();
            if (rs.next()){
                instrutor.setId(rs.getInt("INS_ID"));
                instrutor.setNome(rs.getString("INS_NOME"));
                instrutor.setCpf(rs.getString("INS_CPF"));
                instrutor.setSexo(rs.getString("INS_SEXO"));
                instrutor.setDataNascimento(rs.getDate("INS_NASC"));
                instrutor.setFone(rs.getString("INS_FONE"));
                instrutor.setEmail(rs.getString("INS_EMAIL"));
                instrutor.setLogradouro(rs.getString("INS_LOGRADOURO"));
                instrutor.setNumero(rs.getString("INS_NUMERO"));
                instrutor.setComplemento(rs.getString("INS_COMPLEMENTO"));
                instrutor.setCep(rs.getString("INS_CEP"));
                instrutor.setBairro(rs.getString("INS_BAIRRO"));
            }
            db.close();
            return instrutor;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }finally{
            db.close();
            return null;
        }
    }
    
    public List<Instrutor> selectByLike(String filter){
      List<Instrutor> instrutores = new ArrayList();
      String filtro = "%" + filter + "%";
        try{
            db.open();
            String sql = "SELECT * FROM TB_INSTRUTORES WHERE INS_NOME LIKE ? OR INS_FONE LIKE ?";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Instrutor instrutor = new Instrutor();
                instrutor.setId(rs.getInt("INS_ID"));
                instrutor.setNome(rs.getString("INS_NOME"));
                instrutor.setFone(rs.getString("INS_FONE"));
                instrutores.add(instrutor);
                
            }
            db.close();
            return instrutores;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }finally{
        db.close();
        return instrutores;  
        }
    }
    
    
}

