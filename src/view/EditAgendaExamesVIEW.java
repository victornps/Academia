package view;

import controller.AcademiaCTRL;
import dao.AgendaExamesDAO;
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
import model.AgendaExames;

public class EditAgendaExamesVIEW extends JFrame {

    private JLabel lbData, lbFaixas;
    private JTextField tfData, tfFaixas;
    private JButton btSalvarEdit;
    private DefaultTableModel tmAcademia;
    private AgendaExames exame;
    private int idUp;
    private String dataTexto, faixaTexto;
    
    
    public EditAgendaExamesVIEW(AgendaExames exame, DefaultTableModel modelo, int id, String data, String faixas) {
        
        this.tmAcademia = modelo;
        this.exame = exame;
        this.idUp = id;
        this.dataTexto = data;
        this.faixaTexto = faixas;
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        
        setLayout(null);
        setTitle("Editar Exame");
        setResizable(false);
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        lbData = new JLabel ("Data:");
        lbData.setBounds(15, 30, 50, 25);
        add(lbData);
      
        tfData = new JTextField(dataTexto);
        tfData.setBounds(60, 30, 120, 25);
        add(tfData);
      
        lbFaixas = new JLabel ("Faixas:");
        lbFaixas.setBounds(15, 60, 100, 25);
        add(lbFaixas);
      
        tfFaixas = new JTextField(faixaTexto);
        tfFaixas.setBounds(60, 60, 100, 25);
        add(tfFaixas);
      
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
                if (exame == null) {
                    exame = new AgendaExames();
                }
                exame.setId(idUp);
                
                String text = tfData.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date textFieldAsDate = null;

                try {
                    textFieldAsDate = sdf.parse(text);
                    } catch (ParseException pe) {
                    
                 }
                
                exame.setData(textFieldAsDate);
                exame.setFaixas(tfFaixas.getText());
                
                new AcademiaCTRL().editarExame(exame);
                carregarTabela();
                setVisible(false);
            }
        });
    }
    
    private void carregarTabela() {
        AgendaExamesDAO dao = new AgendaExamesDAO();
        tmAcademia.setRowCount(0);
        for (AgendaExames e : dao.selectAll()) {
            Object[] linha = {e.getId(), e.getData(), e.getFaixas()};
            tmAcademia.addRow(linha);
        }
    }
    
    
    
}

