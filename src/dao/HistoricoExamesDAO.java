package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.HistoricoExames;
import util.DataBase;

public class HistoricoExamesDAO {
    
    private final DataBase db;

    public HistoricoExamesDAO(){
        db = new DataBase();
    }
    
    public void insert(HistoricoExames historico){
        String sql = "INSERT INTO TB_HISTORICO_EXAMES (HEX_ALU_ID,HEX_AGE_ID,HEX_FAIXA) VALUES (?,?,?)";
        
        try {
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, historico.getAlunoId());
            ps.setInt(2, historico.getExameId());
            ps.setString(3, historico.getFaixa());
            ps.executeUpdate();
        
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
        }finally{
            db.close();
        }
        
    }
    
    public List<HistoricoExames> selectAll(){
        String sql = "SELECT * FROM TB_HISTORICO_EXAMES";
        try{
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<HistoricoExames> historicos = new ArrayList();
            while (rs.next()){
                HistoricoExames historico = new HistoricoExames();
                historico.setId(rs.getInt("HEX_ID"));
                historico.setAlunoId(rs.getInt("HEX_ALU_ID"));
                historico.setExameId(rs.getInt("HEX_AGE_ID"));
                historico.setFaixa(rs.getString("HEX_FAIXA"));
                historicos.add(historico);
                
            }
            db.close();
            return historicos;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }
        db.close();
        return null;
    }
    
    public void delete(HistoricoExames historico) {
        db.open();
        String sql = "DELETE FROM TB_HISTORICO_EXAMES WHERE HEX_ID= ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, historico.getId());
            ps.executeUpdate();
            System.out.println("EXCLUIDO");
        } catch(SQLException error) {
            System.out.println("ERRO: " + error.toString());
        }finally{
          db.close();  
        }
        
    }
    
    public void update(HistoricoExames historico) {
        db.open();
        String sql = "UPDATE TB_HISTORICO_EXAMES SET HEX_ALU_ID = ?,HEX_AGE_ID = ?,HEX_FAIXA = ? WHERE HEX_ID = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, historico.getAlunoId());
            ps.setInt(2, historico.getExameId());
            ps.setString(3, historico.getFaixa());
            ps.setInt(4, historico.getId());
            ps.executeUpdate();
            System.out.println("ATUALIZADO");
        } catch(SQLException error) {
            System.out.println("ERRO:(UPDATE) " + error.toString());
        }finally{
           db.close(); 
        }
        
    }
    
    public HistoricoExames selectById(int id){
        try{
            String sql = "SELECT * FROM TB_HISTORICO_EXAMES WHERE HEX_ID = ?";
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            HistoricoExames historico = new HistoricoExames();
            if (rs.next()){
                historico.setId(rs.getInt("HEX_ID"));
                historico.setAlunoId(rs.getInt("HEX_ALU_ID"));
                historico.setExameId(rs.getInt("HEX_AGE_ID"));
                historico.setFaixa(rs.getString("HEX_FAIXA"));
            }
            db.close();
            return historico;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }finally{
            db.close();
            return null;
        }
    }
    
    public List<HistoricoExames> selectByLike(String filter){
      List<HistoricoExames> historicos = new ArrayList();
      String filtro = "%" + filter + "%";
        try{
            db.open();
            String sql = "SELECT * FROM TB_HISTORICO_EXAMES INNER JOIN TB_AGENDA_EXAMES ON HEX_AGE_ID = AGE_ID WHERE HEX_ALU_ID LIKE ? ORDER BY AGE_DATA DESC";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, filtro);
            
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                HistoricoExames historico = new HistoricoExames();
                historico.setId(rs.getInt("HEX_ID"));
                historico.setAlunoId(rs.getInt("HEX_ALU_ID"));
                historico.setExameId(rs.getInt("HEX_AGE_ID"));
                historico.setData(rs.getDate("AGE_DATA"));
                historico.setFaixa(rs.getString("HEX_FAIXA"));
                historicos.add(historico);
                
            }
            db.close();
            return historicos;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }finally{
        db.close();
        return historicos;  
        }
    }
    
    
}
