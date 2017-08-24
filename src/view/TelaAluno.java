package view;


import controller.AcademiaCTRL;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;



public class TelaAluno extends JFrame{

   private JLabel lbNome, lbCpf, lbSexo, lbData, lbFone, lbEmail, lbLogradouro, lbNumero, lbComplemento, lbCep, lbBairro, lbFaixa; 
   private JTextField tfNome, tfCpf, tfSexo, tfData, tfFone, tfEmail, tfLogradouro, tfNumero, tfComplemento, tfCep, tfBairro, tfFaixa;
   private JScrollPane spHistorico;
   private JTable tbHistorico;
   private DefaultTableModel tmHistorico;
   private String id, nome, cpf, sexo, data, fone, email, logradouro, numero, complemento, cep, bairro, faixa;
   private JButton btAdicionar, btRemover, btEditar; 
    
   public TelaAluno(String id, String nome, String cpf, String sexo, String data, String fone, String email, String logradouro, String numero, String complemento, String cep, String bairro, String faixa) {
      this.id = id;
      this.nome = nome;
      this.cpf = cpf; 
      this.sexo = sexo;
      this.data = data;
      this.fone = fone; 
      this.email = email;
      this.logradouro = logradouro;
      this.numero = numero;
      this.complemento = complemento;
      this.cep = cep;
      this.bairro = bairro;
      this.faixa = faixa;
      inicializarComponentes();
      definirEventos();
   }  
       
       
       
   private void inicializarComponentes() {
      setLayout(null);
      setTitle("Aluno");
      setResizable(false);
      setSize(800, 750);
      setLocationRelativeTo(null);
      getContentPane().setBackground(Color.CYAN);
      
      lbNome = new JLabel ("Nome:");
      lbNome.setBounds(15, 30, 50, 25);
      add(lbNome);
      
      tfNome = new JTextField(nome);
      tfNome.setBounds(150, 30, 300, 25);
      tfNome.setEditable(false);
      add(tfNome);
      
      lbCpf = new JLabel ("CPF:");
      lbCpf.setBounds(15, 60, 100, 25);
      add(lbCpf);
      
      tfCpf = new JTextField(cpf);
      tfCpf.setEditable(false);
      tfCpf.setBounds(150, 60, 100, 25);
      add(tfCpf);
      
      lbSexo = new JLabel ("Sexo:");
      lbSexo.setBounds(15, 90, 100, 25);
      add(lbSexo);
      
      tfSexo = new JTextField(sexo);
      tfSexo.setEditable(false);
      tfSexo.setBounds(150, 90, 100, 25);
      add(tfSexo);
      
      lbData = new JLabel ("Data de Nascimento:");
      lbData.setBounds(15, 120, 120, 25);
      add(lbData);
      
      tfData = new JTextField(data);
      tfData.setEditable(false);
      tfData.setBounds(150, 120, 90, 25);
      add(tfData);
      
      lbFone = new JLabel("Fone:");
      lbFone.setBounds(15, 150, 100, 25);
      add(lbFone);
      
      tfFone = new JTextField(fone);
      tfFone.setEditable(false);
      tfFone.setBounds(150, 150, 100, 25);
      add(tfFone);
      
      lbEmail = new JLabel("Email:");
      lbEmail.setBounds(15, 180, 100, 25);
      add(lbEmail);
      
      tfEmail = new JTextField(email);
      tfEmail.setEditable(false);
      tfEmail.setBounds(150, 180, 200, 25);
      add(tfEmail);
      
      lbLogradouro = new JLabel("Logradouro:");
      lbLogradouro.setBounds(15, 210, 100, 25);
      add(lbLogradouro);
      
      tfLogradouro = new JTextField(logradouro);
      tfLogradouro.setEditable(false);
      tfLogradouro.setBounds(150, 210, 300, 25);
      add(tfLogradouro);
      
      lbNumero = new JLabel("Número:");
      lbNumero.setBounds(15, 240, 100, 25);
      add(lbNumero);
      
      tfNumero = new JTextField(numero);
      tfNumero.setEditable(false);
      tfNumero.setBounds(150, 240, 60, 25);
      add(tfNumero);
      
      lbComplemento = new JLabel("Complemento:");
      lbComplemento.setBounds(15, 270, 100, 25);
      add(lbComplemento);
      
      tfComplemento = new JTextField(complemento);
      tfComplemento.setEditable(false);
      tfComplemento.setBounds(150, 270, 300, 25);
      add(tfComplemento);
      
      lbCep = new JLabel("CEP:");
      lbCep.setBounds(15, 300, 100, 25);
      add(lbCep);
      
      tfCep = new JTextField(cep);
      tfCep.setEditable(false);
      tfCep.setBounds(150, 300, 100, 25);
      add(tfCep);
      
      lbBairro = new JLabel("Bairro:");
      lbBairro.setBounds(15, 330, 100, 25);
      add(lbBairro);
      
      tfBairro = new JTextField(bairro);
      tfBairro.setEditable(false);
      tfBairro.setBounds(150, 330, 100, 25);
      add(tfBairro);
      
      lbFaixa = new JLabel("Faixa:");
      lbFaixa.setBounds(15, 360, 100, 25);
      add(lbFaixa);
      
      tfFaixa = new JTextField(faixa);
      tfFaixa.setEditable(false);
      tfFaixa.setBounds(150, 360, 100, 25);
      add(tfFaixa);
      
      btAdicionar = new JButton("Adicionar");
      btAdicionar.setBounds(310, 500, 100, 32);
      add(btAdicionar);
        
      btRemover = new JButton("Remover");
      btRemover.setBounds(420, 500, 100, 32);
      add(btRemover);
        
      btEditar = new JButton("Editar");
      btEditar.setBounds(530, 500, 100, 32);
      add(btEditar);
      
      Object[] cabecalhoTabela = {"ID","ID ALUNO","ID EXAME","FAIXA","DATA"};
        
        tmHistorico = new DefaultTableModel(cabecalhoTabela, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };
        
        carregarTabela();
        
        
        
        tbHistorico = new JTable(tmHistorico);
        tbHistorico.getColumnModel().getColumn(0).setWidth(0);
        tbHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        tbHistorico.getColumnModel().getColumn(0).setMaxWidth(0); 
        tbHistorico.getColumnModel().getColumn(1).setWidth(0);
        tbHistorico.getColumnModel().getColumn(1).setMinWidth(0);
        tbHistorico.getColumnModel().getColumn(1).setMaxWidth(0); 
        tbHistorico.getColumnModel().getColumn(2).setWidth(0);
        tbHistorico.getColumnModel().getColumn(2).setMinWidth(0);
        tbHistorico.getColumnModel().getColumn(2).setMaxWidth(0); 
        tbHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        
        tbHistorico.getTableHeader().setReorderingAllowed(false);
        tbHistorico.getTableHeader().setResizingAllowed(false);
        tbHistorico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        spHistorico = new JScrollPane(tbHistorico);
        spHistorico.setBounds(10, 420, 200, 280);
        add(spHistorico);
      
      
      
      
      
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we) {
            dispose();
         }
      });
       
       
    }
    
    private void definirEventos() {
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveHistoricoExamesVIEW formulario = new SaveHistoricoExamesVIEW(null,tmHistorico);
                formulario.abrir();
            }
        });
      
        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AcademiaCTRL().excluirHistorico(tmHistorico,tbHistorico);
            }
        });
      
        btEditar.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
               
               int row = tbHistorico.getSelectedRow();
               if(row < 0){
               
                   JOptionPane.showMessageDialog(null,
                   "Selecione uma linha da tabela para editar",
                   "Erro",
                   JOptionPane.ERROR_MESSAGE);
             }else{
               int idE = (Integer) tbHistorico.getValueAt(row, 0);
               int alunoId = (int)tbHistorico.getValueAt(row, 1);
               int exameId = (int) tbHistorico.getValueAt(row, 2);
               //String dataE = tbHistorico.getValueAt(row, 3).toString();
               String faixaE = tbHistorico.getValueAt(row, 3).toString();
        
               EditHistoricoExamesVIEW tela = new EditHistoricoExamesVIEW (null, tmHistorico, idE, alunoId, exameId, faixaE);
               tela.setVisible(true);
               }
            }
         
      });
    }
    
    private void carregarTabela(){
        tmHistorico = new AcademiaCTRL().listarHistoricoAluno(tmHistorico,id);
    }

    
    
}
