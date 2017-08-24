package view;


import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class TelaInstrutor extends JFrame
{
   public TelaInstrutor(String nome, String cpf, String sexo, String data, String fone, String email, String logradouro, String numero, String complemento, String cep, String bairro) {
      setLayout(null);
      setTitle("Instrutor");
      setResizable(false);
      setSize(800, 600);
      setLocationRelativeTo(null);
      getContentPane().setBackground(Color.CYAN);
      
      JLabel lbNome = new JLabel ("Nome:");
      lbNome.setBounds(15, 30, 50, 25);
      add(lbNome);
      
      JTextField tfNome = new JTextField(nome);
      tfNome.setBounds(150, 30, 300, 25);
      tfNome.setEditable(false);
      add(tfNome);
      
      JLabel lbCpf = new JLabel ("CPF:");
      lbCpf.setBounds(15, 60, 100, 25);
      add(lbCpf);
      
      JTextField tfCpf = new JTextField(cpf);
      tfCpf.setEditable(false);
      tfCpf.setBounds(150, 60, 100, 25);
      add(tfCpf);
      
      JLabel lbSexo = new JLabel ("Sexo:");
      lbSexo.setBounds(15, 90, 100, 25);
      add(lbSexo);
      
      JTextField tfSexo = new JTextField(sexo);
      tfSexo.setEditable(false);
      tfSexo.setBounds(150, 90, 100, 25);
      add(tfSexo);
      
      JLabel lbData = new JLabel ("Data de Nascimento:");
      lbData.setBounds(15, 120, 120, 25);
      add(lbData);
      
      JTextField tfData = new JTextField(data);
      tfData.setEditable(false);
      tfData.setBounds(150, 120, 90, 25);
      add(tfData);
      
      JLabel lbFone = new JLabel("Fone:");
      lbFone.setBounds(15, 150, 100, 25);
      add(lbFone);
      
      JTextField tfFone = new JTextField(fone);
      tfFone.setEditable(false);
      tfFone.setBounds(150, 150, 100, 25);
      add(tfFone);
      
      JLabel lbEmail = new JLabel("Email:");
      lbEmail.setBounds(15, 180, 100, 25);
      add(lbEmail);
      
      JTextField tfEmail = new JTextField(email);
      tfEmail.setEditable(false);
      tfEmail.setBounds(150, 180, 200, 25);
      add(tfEmail);
      
      JLabel lbLogradouro = new JLabel("Logradouro:");
      lbLogradouro.setBounds(15, 210, 100, 25);
      add(lbLogradouro);
      
      JTextField tfLogradouro = new JTextField(logradouro);
      tfLogradouro.setEditable(false);
      tfLogradouro.setBounds(150, 210, 300, 25);
      add(tfLogradouro);
      
      JLabel lbNumero = new JLabel("Número:");
      lbNumero.setBounds(15, 240, 100, 25);
      add(lbNumero);
      
      JTextField tfNumero = new JTextField(numero);
      tfNumero.setEditable(false);
      tfNumero.setBounds(150, 240, 60, 25);
      add(tfNumero);
      
      JLabel lbComplemento = new JLabel("Complemento:");
      lbComplemento.setBounds(15, 270, 100, 25);
      add(lbComplemento);
      
      JTextField tfComplemento = new JTextField(complemento);
      tfComplemento.setEditable(false);
      tfComplemento.setBounds(150, 270, 300, 25);
      add(tfComplemento);
      
      JLabel lbCep = new JLabel("CEP:");
      lbCep.setBounds(15, 300, 100, 25);
      add(lbCep);
      
      JTextField tfCep = new JTextField(cep);
      tfCep.setEditable(false);
      tfCep.setBounds(150, 300, 100, 25);
      add(tfCep);
      
      JLabel lbBairro = new JLabel("Bairro:");
      lbBairro.setBounds(15, 330, 100, 25);
      add(lbBairro);
      
      JTextField tfBairro = new JTextField(bairro);
      tfBairro.setEditable(false);
      tfBairro.setBounds(150, 330, 100, 25);
      add(tfBairro);
      
      
      
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we) {
            dispose();
         }
      });
       
       
    }
    
}
