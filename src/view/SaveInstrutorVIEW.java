package view;

import controller.AcademiaCTRL;
import dao.InstrutorDAO;
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
import model.Instrutor;

public class SaveInstrutorVIEW extends JFrame {

    private JLabel lbNome, lbCpf, lbSexo, lbDataNascimento, lbFone, lbEmail, lbLogradouro, lbNumero, lbComplemento, lbCep, lbBairro;
    private JTextField tfNome, tfCpf, tfDataNascimento, tfFone, tfEmail, tfLogradouro, tfNumero, tfComplemento, tfCep, tfBairro;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup bgSexo;
    private JButton btSalvar;
    private DefaultTableModel tmAcademia;
    private Instrutor instrutor;
    private MaskFormatter mascaraCpf, mascaraData, mascaraFone, mascaraCep;
    
    public SaveInstrutorVIEW(Instrutor instrutor, DefaultTableModel modelo) {
        this.tmAcademia = modelo;
        this.instrutor = instrutor;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setTitle("Adicionar Instrutor");
        setResizable(false);
        setBounds(0, 0, 800, 600);
        
        btSalvar = new JButton(new ImageIcon("save.png"));
        btSalvar.setBorder(null);
        btSalvar.setBackground(new Color(238, 238, 238));
        btSalvar.setBounds(500, 35, 32, 32);
        add(btSalvar);
        
        lbNome = new JLabel ("Nome:");
        lbNome.setBounds(15, 30, 50, 25);
        add(lbNome);
      
        tfNome = new JTextField();
        tfNome.setBounds(60, 30, 300, 25);
        add(tfNome);
      
        lbCpf = new JLabel ("CPF:");
        lbCpf.setBounds(15, 60, 100, 25);
        add(lbCpf);
        /*
        tfCpf = new JTextField();
        tfCpf.setBounds(60, 60, 100, 25);
        add(tfCpf);*/
      
        lbSexo = new JLabel ("Sexo:");
        lbSexo.setBounds(15, 90, 100, 25);
        add(lbSexo);
      
        /*tfSexo = new JTextField();
        tfSexo.setBounds(60, 90, 100, 25);
        add(tfSexo);*/
        
        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setBounds(60, 90, 100, 25);
        add(rbMasculino);
        
        rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setBounds(160, 90, 100, 25);
        add(rbFeminino);
        
        bgSexo = new ButtonGroup();
        bgSexo.add(rbMasculino);
        bgSexo.add(rbFeminino);
      
        lbDataNascimento = new JLabel ("Data de Nascimento:");
        lbDataNascimento.setBounds(15, 120, 120, 25);
        add(lbDataNascimento);
        /*
        tfDataNascimento = new JTextField();
        tfDataNascimento.setBounds(150, 120, 90, 25);
        add(tfDataNascimento);*/
      
        lbFone = new JLabel("Fone:");
        lbFone.setBounds(15, 150, 100, 25);
        add(lbFone);
        /*
        tfFone = new JTextField();
        tfFone.setBounds(60, 150, 100, 25);
        add(tfFone);*/
      
        lbEmail = new JLabel("Email:");
        lbEmail.setBounds(15, 180, 100, 25);
        add(lbEmail);
      
        tfEmail = new JTextField();
        tfEmail.setBounds(60, 180, 200, 25);
        add(tfEmail);
      
        lbLogradouro = new JLabel("Logradouro:");
        lbLogradouro.setBounds(15, 210, 100, 25);
        add(lbLogradouro);
      
        tfLogradouro = new JTextField();
        tfLogradouro.setBounds(90, 210, 300, 25);
        add(tfLogradouro);
      
        lbNumero = new JLabel("Número:");
        lbNumero.setBounds(15, 240, 100, 25);
        add(lbNumero);
      
        tfNumero = new JTextField();
        tfNumero.setBounds(90, 240, 60, 25);
        add(tfNumero);
      
        lbComplemento = new JLabel("Complemento:");
        lbComplemento.setBounds(15, 270, 100, 25);
        add(lbComplemento);
      
        tfComplemento = new JTextField();
        tfComplemento.setBounds(120, 270, 300, 25);
        add(tfComplemento);
      
        lbCep = new JLabel("CEP:");
        lbCep.setBounds(15, 300, 100, 25);
        add(lbCep);
        /*
        tfCep = new JTextField();
        tfCep.setBounds(60, 300, 100, 25);
        add(tfCep);*/
      
        lbBairro = new JLabel("Bairro:");
        lbBairro.setBounds(15, 330, 100, 25);
        add(lbBairro);
      
        tfBairro = new JTextField();
        tfBairro.setBounds(60, 330, 100, 25);
        add(tfBairro);
      
        
        
        try {
            if (instrutor == null) {
                
                mascaraCpf = new MaskFormatter("###.###.###-##");
                tfCpf = new JFormattedTextField(mascaraCpf);
                mascaraData = new MaskFormatter("####-##-##");
                tfDataNascimento = new JFormattedTextField(mascaraData);
                mascaraFone = new MaskFormatter("(##) ####-####");
                tfFone = new JFormattedTextField(mascaraFone);
                mascaraCep = new MaskFormatter("##.###-###");
                tfCep = new JFormattedTextField(mascaraCep);
            } 
        } catch(ParseException error) {
            System.out.println("Erro: " + error);
        } finally {
            tfCpf.setBounds(60, 60, 100, 25);
            add(tfCpf);
            tfDataNascimento.setBounds(150, 120, 90, 25);
            add(tfDataNascimento);
            tfFone.setBounds(60, 150, 100, 25);
            add(tfFone);
            tfCep.setBounds(60, 300, 100, 25);
            add(tfCep);
        }
    }

    private void definirEventos() {
        btSalvar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (instrutor == null) {
                    instrutor = new Instrutor();
                }
                
                
                instrutor.setNome(tfNome.getText());
                instrutor.setCpf(tfCpf.getText());
                String pegaSexo = getSelectedButtonText(bgSexo);
                instrutor.setSexo(pegaSexo);
                
                String text = tfDataNascimento.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date textFieldAsDate = null;

                try {
                    textFieldAsDate = sdf.parse(text);
                    } catch (ParseException pe) {
                    
                 }
                
                instrutor.setDataNascimento(textFieldAsDate);
                instrutor.setFone(tfFone.getText());
                instrutor.setEmail(tfEmail.getText());
                instrutor.setLogradouro(tfLogradouro.getText());
                instrutor.setNumero(tfNumero.getText());
                instrutor.setComplemento(tfComplemento.getText());
                instrutor.setCep(tfCep.getText());
                instrutor.setBairro(tfBairro.getText());
                
                new AcademiaCTRL().adicionarInstrutor(instrutor);
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
        InstrutorDAO dao = new InstrutorDAO();
        tmAcademia.setRowCount(0);
        for (Instrutor i : dao.selectAll()) {
            Object[] linha = {i.getId(), i.getNome(), i.getCpf(), i.getSexo(), i.getDataNascimento(), i.getFone(), i.getEmail(), i.getLogradouro(), i.getNumero(), i.getComplemento(), i.getCep(), i.getBairro()};
            tmAcademia.addRow(linha);
        }
    }
    
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
}
    
    
    public void abrir() {
        SaveInstrutorVIEW janela = new SaveInstrutorVIEW(instrutor, tmAcademia);
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dimensao.width - janela.getSize().width) / 2;
        int y = (dimensao.height - janela.getSize().height) / 2;
        janela.setLocation(x, y);
        janela.setVisible(true);
    }
    
}
