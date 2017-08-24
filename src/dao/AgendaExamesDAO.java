package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.AgendaExames;
import util.DataBase;

public class AgendaExamesDAO {
    
    private final DataBase db;

    public AgendaExamesDAO(){
        db = new DataBase();
    }
    
    public void insert(AgendaExames agenda){
        String sql = "INSERT INTO TB_AGENDA_EXAMES (AGE_DATA,AGE_FAIXAS) VALUES (?,?)";
        
        try {
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(agenda.getData()));
            ps.setString(2, agenda.getFaixas());
            ps.executeUpdate();
        
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
        }finally{
            db.close();
        }
        
    }
    
    public List<AgendaExames> selectAll(){
        String sql = "SELECT * FROM TB_AGENDA_EXAMES ORDER BY AGE_DATA DESC";
        try{
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<AgendaExames> agendas = new ArrayList();
            while (rs.next()){
                AgendaExames agenda = new AgendaExames();
                agenda.setId(rs.getInt("AGE_ID"));
                agenda.setData(rs.getDate("AGE_DATA"));
                agenda.setFaixas(rs.getString("AGE_FAIXAS"));
                agendas.add(agenda);
                
            }
            db.close();
            return agendas;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }
        db.close();
        return null;
    }
    
    public void delete(AgendaExames agenda) {
        db.open();
        String sql = "DELETE FROM TB_AGENDA_EXAMES WHERE AGE_ID= ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, agenda.getId());
            ps.executeUpdate();
            System.out.println("EXCLUIDO");
        } catch(SQLException error) {
            System.out.println("ERRO: " + error.toString());
        }finally{
          db.close();  
        }
        
    }
    
    public void update(AgendaExames agenda) {
        db.open();
        String sql = "UPDATE TB_AGENDA_EXAMES SET AGE_DATA = ?,AGE_FAIXAS = ? WHERE AGE_ID = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(agenda.getData()));
            ps.setString(2, agenda.getFaixas());
            ps.setInt(3, agenda.getId());
            ps.executeUpdate();
            System.out.println("ATUALIZADO");
        } catch(SQLException error) {
            System.out.println("ERRO:(UPDATE) " + error.toString());
        }finally{
           db.close(); 
        }
        
    }
    
    public AgendaExames selectById(int id){
        try{
            String sql = "SELECT * FROM TB_AGENDA_EXAMES WHERE AGE_ID = ?";
            db.open();
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            AgendaExames agenda = new AgendaExames();
            if (rs.next()){
                agenda.setId(rs.getInt("AGE_ID"));
                agenda.setData(rs.getDate("AGE_DATA"));
                agenda.setFaixas(rs.getString("AGE_FAIXAS"));
            }
            db.close();
            return agenda;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }finally{
            db.close();
            return null;
        }
    }
    
    public List<AgendaExames> selectByLike(String filter){
      List<AgendaExames> agendas = new ArrayList();
      String filtro = "%" + filter + "%";
        try{
            db.open();
            String sql = "SELECT * FROM TB_AGENDA_EXAMES WHERE AGE_FAIXAS LIKE ?";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                AgendaExames agenda = new AgendaExames();
                agenda.setId(rs.getInt("AGE_ID"));
                agenda.setData(rs.getDate("AGE_DATA"));
                agenda.setFaixas(rs.getString("AGE_FAIXAS"));
                agendas.add(agenda);
                
            }
            db.close();
            return agendas;
        }catch(SQLException error){
            System.out.println("ERRO: " + error);
        }finally{
        db.close();
        return agendas;  
        }
    }
    
    
}
