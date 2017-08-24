package view;

import controller.AcademiaCTRL;
import dao.AgendaExamesDAO;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.AgendaExames;

public class SaveAgendaExamesVIEW extends JFrame {

    private JLabel lbData, lbFaixas;
    private JTextField tfData,tfFaixas;
    //private JRadioButton rbMasculino, rbFeminino, rbFaixaBranca, rbFaixaAmarela, rbFaixaLaranja, rbFaixaJade, rbFaixaVerdeEscura, rbFaixaRoxa, rbFaixaAzul, rbFaixaVermelha, rbFaixaMarrom, rbFaixaPreta;
    //private ButtonGroup bgSexo,bgFaixas;
    private JButton btSalvar;
    private DefaultTableModel tmAcademia;
    private AgendaExames exame;
    private MaskFormatter mascaraData;
    
    public SaveAgendaExamesVIEW(AgendaExames exame, DefaultTableModel modelo) {
        this.tmAcademia = modelo;
        this.exame = exame;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setTitle("Adicionar Exame");
        setResizable(false);
        setBounds(0, 0, 300, 120);
        
        btSalvar = new JButton(new ImageIcon("save.png"));
        btSalvar.setBorder(null);
        btSalvar.setBackground(new Color(238, 238, 238));
        btSalvar.setBounds(220, 35, 32, 32);
        add(btSalvar);
        
        lbData = new JLabel ("Data:");
        lbData.setBounds(15, 30, 50, 25);
        add(lbData);
        /*
        tfData = new JTextField();
        tfData.setBounds(60, 30, 120, 25);
        add(tfData);*/
        
        try {
                mascaraData = new MaskFormatter("####-##-##");
                tfData = new JFormattedTextField(mascaraData);
                
            
        } catch(ParseException error) {
            System.out.println("Erro: " + error);
        } finally {
            tfData.setBounds(60, 30, 120, 25);
            add(tfData);
            
        }
        
        lbFaixas = new JLabel ("Faixas:");
        lbFaixas.setBounds(15, 60, 100, 25);
        add(lbFaixas);
        
        tfFaixas = new JTextField();
        tfFaixas.setBounds(60, 60, 120, 25);
        add(tfFaixas);
      
    }

    private void definirEventos() {
        btSalvar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (exame == null) {
                    exame = new AgendaExames();
                }
                
                String text = tfData.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date textFieldAsDate = null;

                try {
                    textFieldAsDate = sdf.parse(text);
                    } catch (ParseException pe) {
                    
                 }
                
                exame.setData(textFieldAsDate);
                exame.setFaixas(tfFaixas.getText());
                
                new AcademiaCTRL().adicionarExame(exame);
                carregarTabela();
                setVisible(false);
            }

            public String getSelectedButtonText(ButtonGroup buttonGroup) {
                for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                        return button.getText();
                    }
                }

        return null;
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
    /*
    public class GroupButtonUtils {

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}*/
    
    
    public void abrir() {
        SaveAgendaExamesVIEW janela = new SaveAgendaExamesVIEW(exame, tmAcademia);
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dimensao.width - janela.getSize().width) / 2;
        int y = (dimensao.height - janela.getSize().height) / 2;
        janela.setLocation(x, y);
        janela.setVisible(true);
    }
    
}
