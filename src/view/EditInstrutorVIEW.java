package view;

import controller.AcademiaCTRL;
import dao.InstrutorDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Instrutor;

public class EditInstrutorVIEW extends JFrame {

    private JLabel lbNome, lbCpf, lbSexo, lbDataNascimento, lbFone, lbEmail, lbLogradouro, lbNumero, lbComplemento, lbCep, lbBairro;
    private JTextField tfNome, tfCpf, tfSexo, tfDataNascimento, tfFone, tfEmail, tfLogradouro, tfNumero, tfComplemento, tfCep, tfBairro;
    private JButton btSalvarEdit;
    private DefaultTableModel tmAcademia;
    private Instrutor instrutor;
    private int idUp;
    private String nomeTexto, cpfTexto, sexoTexto, nascTexto, foneTexto, emailTexto, lograTexto, numTexto, compTexto, cepTexto, bairroTexto;
    
    
    public EditInstrutorVIEW(Instrutor instrutor, DefaultTableModel modelo, int id, String nome, String cpf, String sexo, String data, String fone, String email, String logradouro, String numero, String complemento, String cep, String bairro) {
        
        this.tmAcademia = modelo;
        this.instrutor = instrutor;
        this.idUp = id;
        this.nomeTexto = nome;
        this.cpfTexto = cpf;
        this.sexoTexto = sexo;
        this.nascTexto = data;
        this.foneTexto = fone;
        this.emailTexto = email;
        this.lograTexto = logradouro;
        this.numTexto = numero;
        this.compTexto = complemento;
        this.cepTexto = cep;
        this.bairroTexto = bairro;
        
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        
        setLayout(null);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        lbNome = new JLabel ("Nome:");
        lbNome.setBounds(15, 30, 50, 25);
        add(lbNome);
      
        tfNome = new JTextField(nomeTexto);
        tfNome.setBounds(60, 30, 300, 25);
        add(tfNome);
      
        lbCpf = new JLabel ("CPF:");
        lbCpf.setBounds(15, 60, 100, 25);
        add(lbCpf);
      
        tfCpf = new JTextField(cpfTexto);
        tfCpf.setBounds(60, 60, 100, 25);
        add(tfCpf);
      
        lbSexo = new JLabel ("Sexo:");
        lbSexo.setBounds(15, 90, 100, 25);
        add(lbSexo);
      
        tfSexo = new JTextField(sexoTexto);
        tfSexo.setBounds(60, 90, 100, 25);
        add(tfSexo);
      
        lbDataNascimento = new JLabel ("Data de Nascimento:");
        lbDataNascimento.setBounds(15, 120, 120, 25);
        add(lbDataNascimento);
      
        tfDataNascimento = new JTextField(nascTexto);
        tfDataNascimento.setBounds(150, 120, 90, 25);
        add(tfDataNascimento);
      
        lbFone = new JLabel("Fone:");
        lbFone.setBounds(15, 150, 100, 25);
        add(lbFone);
      
        tfFone = new JTextField(foneTexto);
        tfFone.setBounds(60, 150, 100, 25);
        add(tfFone);
      
        lbEmail = new JLabel("Email:");
        lbEmail.setBounds(15, 180, 100, 25);
        add(lbEmail);
      
        tfEmail = new JTextField(emailTexto);
        tfEmail.setBounds(60, 180, 200, 25);
        add(tfEmail);
      
        lbLogradouro = new JLabel("Logradouro:");
        lbLogradouro.setBounds(15, 210, 100, 25);
        add(lbLogradouro);
      
        tfLogradouro = new JTextField(lograTexto);
        tfLogradouro.setBounds(90, 210, 300, 25);
        add(tfLogradouro);
      
        lbNumero = new JLabel("Número:");
        lbNumero.setBounds(15, 240, 100, 25);
        add(lbNumero);
      
        tfNumero = new JTextField(numTexto);
        tfNumero.setBounds(90, 240, 60, 25);
        add(tfNumero);
      
        lbComplemento = new JLabel("Complemento:");
        lbComplemento.setBounds(15, 270, 100, 25);
        add(lbComplemento);
      
        tfComplemento = new JTextField(compTexto);
        tfComplemento.setBounds(120, 270, 300, 25);
        add(tfComplemento);
      
        lbCep = new JLabel("CEP:");
        lbCep.setBounds(15, 300, 100, 25);
        add(lbCep);
      
        tfCep = new JTextField(cepTexto);
        tfCep.setBounds(60, 300, 100, 25);
        add(tfCep);
      
        lbBairro = new JLabel("Bairro:");
        lbBairro.setBounds(15, 330, 100, 25);
        add(lbBairro);
      
        tfBairro = new JTextField(bairroTexto);
        tfBairro.setBounds(60, 330, 100, 25);
        add(tfBairro);
      
        btSalvarEdit = new JButton(new ImageIcon("save.png"));
        btSalvarEdit.setBorder(null);
        btSalvarEdit.setBackground(new Color(238, 238, 238));
        btSalvarEdit.setBounds(500, 35, 32, 32);
        add(btSalvarEdit);
        
        
    }

    private void definirEventos() {
        btSalvarEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (instrutor == null) {
                    instrutor = new Instrutor();
                }
                instrutor.setId(idUp);
                instrutor.setNome(tfNome.getText());
                instrutor.setCpf(tfCpf.getText());
                instrutor.setSexo(tfSexo.getText());
                
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
                
                
                new AcademiaCTRL().editarInstrutor(instrutor);
                carregarTabela();
                setVisible(false);
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
    
    
    
}
