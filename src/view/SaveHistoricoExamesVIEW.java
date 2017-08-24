package view;

import controller.AcademiaCTRL;
import dao.HistoricoExamesDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.HistoricoExames;

public class SaveHistoricoExamesVIEW extends JFrame {

    private JLabel lbIdAluno, lbIdExame, lbFaixa;
    private JTextField tfIdAluno, tfIdExame, tfFaixa;
    private JButton btSalvar;
    private DefaultTableModel tmAcademia;
    private HistoricoExames hist;
    
    
    public SaveHistoricoExamesVIEW(HistoricoExames hist, DefaultTableModel modelo) {
        this.tmAcademia = modelo;
        this.hist = hist;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setTitle("Adicionar Histórico");
        setResizable(false);
        setBounds(0, 0, 300, 120);
        
        btSalvar = new JButton(new ImageIcon("save.png"));
        btSalvar.setBorder(null);
        btSalvar.setBackground(new Color(238, 238, 238));
        btSalvar.setBounds(220, 35, 32, 32);
        add(btSalvar);
        
        lbIdAluno = new JLabel ("Id do Aluno:");
        lbIdAluno.setBounds(15, 30, 50, 25);
        add(lbIdAluno);
        
        tfIdAluno = new JTextField();
        tfIdAluno.setBounds(60, 30, 120, 25);
        add(tfIdAluno);
        
        lbIdExame = new JLabel ("Id do Exame:");
        lbIdExame.setBounds(15, 60, 100, 25);
        add(lbIdExame);
        
        tfIdExame = new JTextField();
        tfIdExame.setBounds(60, 60, 120, 25);
        add(tfIdExame);
        
        lbFaixa = new JLabel ("Faixa:");
        lbFaixa.setBounds(15, 90, 100, 25);
        add(lbFaixa);
        
        tfFaixa = new JTextField();
        tfFaixa.setBounds(60, 90, 120, 25);
        add(tfFaixa);
    }

    private void definirEventos() {
        btSalvar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (hist == null) {
                    hist = new HistoricoExames();
                }
                
                hist.setAlunoId(Integer.parseInt(tfIdAluno.getText()));
                hist.setExameId(Integer.parseInt(tfIdExame.getText()));
                
                hist.setFaixa(tfFaixa.getText());
                
                new AcademiaCTRL().adicionarHistorico(hist);
                carregarTabela();
                setVisible(false);
            }

            
        });
        
        
    }
    
    private void carregarTabela() {
        HistoricoExamesDAO dao = new HistoricoExamesDAO();
        tmAcademia.setRowCount(0);
        for (HistoricoExames e : dao.selectAll()) {
            Object[] linha = {e.getId(), e.getAlunoId(),e.getExameId(), e.getFaixa()};
            tmAcademia.addRow(linha);
        }
    }
    
    
    
    public void abrir() {
        SaveHistoricoExamesVIEW janela = new SaveHistoricoExamesVIEW(hist, tmAcademia);
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dimensao.width - janela.getSize().width) / 2;
        int y = (dimensao.height - janela.getSize().height) / 2;
        janela.setLocation(x, y);
        janela.setVisible(true);
    }
    
}
