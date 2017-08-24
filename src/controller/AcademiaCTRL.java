package controller;

import dao.AgendaExamesDAO;
import dao.AlunoDAO;
import dao.HistoricoExamesDAO;
import dao.InstrutorDAO;
import helper.FoneHELPER;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.AgendaExames;
import model.Aluno;
import model.HistoricoExames;
import model.Instrutor;


public class AcademiaCTRL {
    
    public DefaultTableModel listarTodosAlunos(DefaultTableModel dtm) {
        DefaultTableModel model = dtm;
        model.setRowCount(0);
        
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> alunos = dao.selectAll();
        for (Aluno aluno : alunos) {
            int id = aluno.getId();
            String nome = aluno.getNome();
            String cpf = aluno.getCpf();
            String sexo = aluno.getSexo();
            String nasc = new SimpleDateFormat("yyyy-MM-dd").format(aluno.getDataNascimento());
            String fone = aluno.getFone();
            String email = aluno.getEmail();
            String logradouro = aluno.getLogradouro();
            String numero = aluno.getNumero();
            String complemento = aluno.getComplemento();
            String cep = aluno.getCep();
            String bairro = aluno.getBairro();
            String faixa = aluno.getFaixa();
            Object[] linha = {id, nome, cpf, sexo, nasc, fone, email, logradouro, numero, complemento, cep, bairro, faixa};
            
            model.addRow(linha);
        }
        return model;
    }
    
    public void adicionar(Aluno aluno) {
        aluno.setNome(aluno.getNome().trim().toUpperCase());
        aluno.setCpf(aluno.getCpf().replace(".", "").replace("-", "").trim());
        aluno.setSexo(aluno.getSexo().trim());
        aluno.setDataNascimento(aluno.getDataNascimento());
        aluno.setFone(FoneHELPER.limpar(aluno.getFone()).trim());
        aluno.setEmail(aluno.getEmail().trim());
        aluno.setLogradouro(aluno.getLogradouro().trim());
        aluno.setNumero(aluno.getNumero().trim());
        aluno.setComplemento(aluno.getComplemento().trim());
        aluno.setCep(aluno.getCep().replace(".", "").replace("-", "").trim());
        aluno.setBairro(aluno.getBairro().trim());
        aluno.setFaixa(aluno.getFaixa().trim());
        if (aluno.getNome().equals("") || aluno.getFone().equals("")) {
        
            JOptionPane.showMessageDialog(null, "Campos Obrigatorios");
        } else {
            if (aluno.getId() == 0) {
                new AlunoDAO().insert(aluno);
            } else {
                new AlunoDAO().update(aluno);
            }
        }
    }
    
    public DefaultTableModel excluirAlunos(DefaultTableModel modelo, JTable tabela) {
        int[] linhas = tabela.getSelectedRows();
        AlunoDAO dao = new AlunoDAO();
        for (int i = (linhas.length - 1); i >= 0; i--) {
            Aluno aluno = new Aluno();
            aluno.setId((int) tabela.getValueAt(linhas[i], 0));
            aluno.setNome((String) tabela.getValueAt(linhas[i], 1));
            aluno.setCpf((String) tabela.getValueAt(linhas[i], 2));
            aluno.setSexo((String) tabela.getValueAt(linhas[i], 3));
            //aluno.setDataNascimento((String) tabela.getValueAt(linhas[i], 4));
            aluno.setFone((String) tabela.getValueAt(linhas[i], 5));
            aluno.setEmail((String) tabela.getValueAt(linhas[i], 6));
            aluno.setLogradouro((String) tabela.getValueAt(linhas[i], 7));
            aluno.setNumero((String) tabela.getValueAt(linhas[i], 8));
            aluno.setComplemento((String) tabela.getValueAt(linhas[i], 9));
            aluno.setCep((String) tabela.getValueAt(linhas[i], 10));
            aluno.setBairro((String) tabela.getValueAt(linhas[i], 11));
            aluno.setFaixa((String) tabela.getValueAt(linhas[i], 12));
            modelo.removeRow(i);
            dao.delete(aluno);
        }
        return modelo;
    }
    
    public void editar(Aluno aluno) {
        
        aluno.setId(aluno.getId());
        aluno.setNome(aluno.getNome().trim());
        aluno.setCpf(aluno.getCpf().trim());
        aluno.setSexo(aluno.getSexo().trim());
        aluno.setDataNascimento(aluno.getDataNascimento());
        aluno.setFone(aluno.getFone().trim());
        aluno.setEmail(aluno.getEmail().trim());
        aluno.setLogradouro(aluno.getLogradouro().trim());
        aluno.setNumero(aluno.getNumero().trim());
        aluno.setComplemento(aluno.getComplemento().trim());
        aluno.setCep(aluno.getCep().trim());
        aluno.setBairro(aluno.getBairro().trim());
        aluno.setFaixa(aluno.getFaixa().trim());
        
        new AlunoDAO().update(aluno);
         
    }
    
    public DefaultTableModel listarInstrutores(DefaultTableModel dtm) {
        DefaultTableModel model = dtm;
        model.setRowCount(0);
        
        InstrutorDAO dao = new InstrutorDAO();
        List<Instrutor> instrutores = dao.selectAll();
        for (Instrutor instrutor : instrutores) {
            int id = instrutor.getId();
            String nome = instrutor.getNome();
            String cpf = instrutor.getCpf();
            String sexo = instrutor.getSexo();
            String nasc = new SimpleDateFormat("yyyy-MM-dd").format(instrutor.getDataNascimento());
            String fone = instrutor.getFone();
            String email = instrutor.getEmail();
            String logradouro = instrutor.getLogradouro();
            String numero = instrutor.getNumero();
            String complemento = instrutor.getComplemento();
            String cep = instrutor.getCep();
            String bairro = instrutor.getBairro();
            
            Object[] linha = {id, nome, cpf, sexo, nasc, fone, email, logradouro, numero, complemento, cep, bairro};
            
            model.addRow(linha);
        }
        return model;
    }
    
    public void adicionarInstrutor(Instrutor instrutor) {
        instrutor.setNome(instrutor.getNome().trim().toUpperCase());
        instrutor.setCpf(instrutor.getCpf().trim());
        instrutor.setSexo(instrutor.getSexo().trim());
        instrutor.setDataNascimento(instrutor.getDataNascimento());
        instrutor.setFone(FoneHELPER.limpar(instrutor.getFone()).trim());
        instrutor.setEmail(instrutor.getEmail().trim());
        instrutor.setLogradouro(instrutor.getLogradouro().trim());
        instrutor.setNumero(instrutor.getNumero().trim());
        instrutor.setComplemento(instrutor.getComplemento().trim());
        instrutor.setCep(instrutor.getCep().trim());
        instrutor.setBairro(instrutor.getBairro().trim());
        
        if (instrutor.getNome().equals("") || instrutor.getFone().equals("")) {
        
            JOptionPane.showMessageDialog(null, "Campos Obrigatorios");
        } else {
            if (instrutor.getId() == 0) {
                new InstrutorDAO().insert(instrutor);
            } else {
                new InstrutorDAO().update(instrutor);
            }
        }
    }
    
    public DefaultTableModel excluirInstrutores(DefaultTableModel modelo, JTable tabela) {
        int[] linhas = tabela.getSelectedRows();
        InstrutorDAO dao = new InstrutorDAO();
        for (int i = (linhas.length - 1); i >= 0; i--) {
            Instrutor instrutor = new Instrutor();
            instrutor.setId((int) tabela.getValueAt(linhas[i], 0));
            instrutor.setNome((String) tabela.getValueAt(linhas[i], 1));
            instrutor.setCpf((String) tabela.getValueAt(linhas[i], 2));
            instrutor.setSexo((String) tabela.getValueAt(linhas[i], 3));
            //aluno.setDataNascimento((String) tabela.getValueAt(linhas[i], 4));
            instrutor.setFone((String) tabela.getValueAt(linhas[i], 5));
            instrutor.setEmail((String) tabela.getValueAt(linhas[i], 6));
            instrutor.setLogradouro((String) tabela.getValueAt(linhas[i], 7));
            instrutor.setNumero((String) tabela.getValueAt(linhas[i], 8));
            instrutor.setComplemento((String) tabela.getValueAt(linhas[i], 9));
            instrutor.setCep((String) tabela.getValueAt(linhas[i], 10));
            instrutor.setBairro((String) tabela.getValueAt(linhas[i], 11));
            
            modelo.removeRow(i);
            dao.delete(instrutor);
        }
        return modelo;
    }
    
    public void editarInstrutor(Instrutor instrutor) {
        
        instrutor.setId(instrutor.getId());
        instrutor.setNome(instrutor.getNome().trim());
        instrutor.setCpf(instrutor.getCpf().trim());
        instrutor.setSexo(instrutor.getSexo().trim());
        instrutor.setDataNascimento(instrutor.getDataNascimento());
        instrutor.setFone(instrutor.getFone().trim());
        instrutor.setEmail(instrutor.getEmail().trim());
        instrutor.setLogradouro(instrutor.getLogradouro().trim());
        instrutor.setNumero(instrutor.getNumero().trim());
        instrutor.setComplemento(instrutor.getComplemento().trim());
        instrutor.setCep(instrutor.getCep().trim());
        instrutor.setBairro(instrutor.getBairro().trim());
        
        
        new InstrutorDAO().update(instrutor);
         
    }
    
    public DefaultTableModel listarExames(DefaultTableModel dtm) {
        DefaultTableModel model = dtm;
        model.setRowCount(0);
        
        AgendaExamesDAO dao = new AgendaExamesDAO();
        List<AgendaExames> exames = dao.selectAll();
        for (AgendaExames exame : exames) {
            int id = exame.getId();
            String data = new SimpleDateFormat("yyyy-MM-dd").format(exame.getData());
            String faixas = exame.getFaixas();
            Object[] linha = {id, data, faixas};
            
            model.addRow(linha);
        }
        return model;
    }
    
    public void adicionarExame(AgendaExames exame) {
        exame.setData(exame.getData());
        exame.setFaixas(exame.getFaixas());
        
        
        if (exame.getData().equals("") || exame.getFaixas().equals("")) {
        
            JOptionPane.showMessageDialog(null, "Campos Obrigatorios");
        } else {
            if (exame.getId() == 0) {
                new AgendaExamesDAO().insert(exame);
            } else {
                new AgendaExamesDAO().update(exame);
            }
        }
    }
    
    public DefaultTableModel excluirExame(DefaultTableModel modelo, JTable tabela) {
        int[] linhas = tabela.getSelectedRows();
        AgendaExamesDAO dao = new AgendaExamesDAO();
        for (int i = (linhas.length - 1); i >= 0; i--) {
            AgendaExames exame = new AgendaExames();
            exame.setId((int) tabela.getValueAt(linhas[i], 0));
            //exame.setData((Date) tabela.getValueAt(linhas[i], 1));
            exame.setFaixas((String) tabela.getValueAt(linhas[i], 2));
            
            modelo.removeRow(i);
            dao.delete(exame);
        }
        return modelo;
    }
    
    public void editarExame(AgendaExames exame) {
        
        exame.setId(exame.getId());
        exame.setData(exame.getData());
        exame.setFaixas(exame.getFaixas().trim());
        
        new AgendaExamesDAO().update(exame);
         
    }
    
    public DefaultTableModel listarTodoHistorico(DefaultTableModel dtm) {
        DefaultTableModel model = dtm;
        model.setRowCount(0);
        
        HistoricoExamesDAO dao = new HistoricoExamesDAO();
        List<HistoricoExames> historicos = dao.selectAll();
        for (HistoricoExames historico : historicos) {
            int id = historico.getId();
            int alunoId = historico.getAlunoId();
            int exameId = historico.getExameId();
            String faixa = historico.getFaixa();
            Object[] linha = {id, alunoId, exameId, faixa};
            
            model.addRow(linha);
        }
        return model;
    }
    
    public DefaultTableModel listarHistoricoAluno(DefaultTableModel dtm, String filter) {
        DefaultTableModel model = dtm;
        model.setRowCount(0);
        
        HistoricoExamesDAO dao = new HistoricoExamesDAO();
        List<HistoricoExames> historicos = dao.selectByLike(filter);
        for (HistoricoExames historico : historicos) {
            int id = historico.getId();
            int alunoId = historico.getAlunoId();
            int exameId = historico.getExameId();
            Date data = historico.getData();
            String faixa = historico.getFaixa();
            Object[] linha = {id, alunoId, exameId, faixa, data};
            
            model.addRow(linha);
        }
        return model;
    }
    
    public void adicionarHistorico(HistoricoExames hist) {
        hist.setAlunoId(hist.getAlunoId());
        hist.setExameId(hist.getExameId());
        hist.setData(hist.getData());
        hist.setFaixa(hist.getFaixa());
        
        
        if (hist.getData().equals("") || hist.getFaixa().equals("")) {
        
            JOptionPane.showMessageDialog(null, "Campos Obrigatorios");
        } else {
            if (hist.getId() == 0) {
                new HistoricoExamesDAO().insert(hist);
            } else {
                new HistoricoExamesDAO().update(hist);
            }
        }
    }
    
    public DefaultTableModel excluirHistorico(DefaultTableModel modelo, JTable tabela) {
        int[] linhas = tabela.getSelectedRows();
        HistoricoExamesDAO dao = new HistoricoExamesDAO();
        for (int i = (linhas.length - 1); i >= 0; i--) {
            HistoricoExames hist = new HistoricoExames();
            hist.setId((int) tabela.getValueAt(linhas[i], 0));
            hist.setAlunoId((int) tabela.getValueAt(linhas[i], 1));
            hist.setExameId((int) tabela.getValueAt(linhas[i], 2));
            //exame.setData((Date) tabela.getValueAt(linhas[i], 3));
            hist.setFaixa((String) tabela.getValueAt(linhas[i], 4));
            
            modelo.removeRow(i);
            dao.delete(hist);
        }
        return modelo;
    }
    
    public void editarHistorico(HistoricoExames hist) {
        
        hist.setId(hist.getId());
        hist.setAlunoId(hist.getAlunoId());
        hist.setExameId(hist.getExameId());
        hist.setData(hist.getData());
        hist.setFaixa(hist.getFaixa().trim());
        
        new HistoricoExamesDAO().update(hist);
         
    }
}
