package view;

import controller.AcademiaCTRL;
import dao.HistoricoExamesDAO;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.HistoricoExames;

public class EditHistoricoExamesVIEW extends JFrame {

    private JLabel lbIdAluno, lbIdExame, lbFaixa;
    private JTextField tfIdAluno, tfIdExame, tfFaixa;
    private JButton btSalvarEdit;
    private DefaultTableModel tmAcademia;
    private HistoricoExames hist;
    private int idUp, alunoId, exameId;
    private String faixaTexto;
    
    
    public EditHistoricoExamesVIEW(HistoricoExames hist, DefaultTableModel modelo, int id, int alunoId, int exameId, String faixa) {
        
        this.tmAcademia = modelo;
        this.hist = hist;
        this.idUp = id;
        this.alunoId = alunoId;
        this.exameId = exameId;
        this.faixaTexto = faixa;
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        
        setLayout(null);
        setTitle("Editar Histórico");
        setResizable(false);
        setSize(300, 180);
        setLocationRelativeTo(null);
        
        lbIdAluno = new JLabel ("Id do Aluno:");
        lbIdAluno.setBounds(15, 30, 100, 25);
        add(lbIdAluno);
        
        tfIdAluno = new JTextField(alunoId);
        tfIdAluno.setBounds(90, 30, 120, 25);
        add(tfIdAluno);
        
        lbIdExame = new JLabel ("Id do Exame:");
        lbIdExame.setBounds(15, 60, 100, 25);
        add(lbIdExame);
        
        tfIdExame = new JTextField(exameId);
        tfIdExame.setBounds(90, 60, 120, 25);
        add(tfIdExame);
        
        lbFaixa = new JLabel ("Faixa:");
        lbFaixa.setBounds(15, 90, 100, 25);
        add(lbFaixa);
        
        tfFaixa = new JTextField(faixaTexto);
        tfFaixa.setBounds(90, 90, 120, 25);
        add(tfFaixa);
      
        btSalvarEdit = new JButton(new ImageIcon("save.png"));
        btSalvarEdit.setBorder(null);
        btSalvarEdit.setBackground(new Color(238, 238, 238));
        btSalvarEdit.setBounds(250, 35, 32, 32);
        add(btSalvarEdit);
        
        
    }

    private void definirEventos() {
        btSalvarEdit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (hist == null) {
                    hist = new HistoricoExames();
                }
                hist.setId(idUp);
                
                
                hist.setAlunoId(Integer.parseInt(tfIdAluno.getText()));
                hist.setExameId(Integer.parseInt(tfIdExame.getText()));
                
                hist.setFaixa(tfFaixa.getText());
                
                new AcademiaCTRL().editarHistorico(hist);
                carregarTabela();
                setVisible(false);
            }
        });
    }
    
    private void carregarTabela() {
        HistoricoExamesDAO dao = new HistoricoExamesDAO();
        tmAcademia.setRowCount(0);
        for (HistoricoExames e : dao.selectAll()) {
            Object[] linha = {e.getId(), e.getAlunoId(), e.getExameId(), e.getFaixa(), e.getData()};
            tmAcademia.addRow(linha);
        }
    }
    
    
    
}
