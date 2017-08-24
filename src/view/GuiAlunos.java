package view;

import controller.AcademiaCTRL;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GuiAlunos extends JPanel{
 
    
    private JScrollPane spAlunos;
    private JTable tbAlunos;
    private JPanel pnPrincipal, pnTabela;
    private DefaultTableModel tmAlunos;
    private JButton btAdicionar, btRemover, btEditar;
    
    public GuiAlunos() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBounds(0, 0, 600, 600);
        add(pnPrincipal);
        
        btAdicionar = new JButton("Adicionar");
        btAdicionar.setBounds(220, 10, 100, 32);
        pnPrincipal.add(btAdicionar);
        
        btRemover = new JButton("Remover");
        btRemover.setBounds(330, 10, 100, 32);
        pnPrincipal.add(btRemover);
        
        btEditar = new JButton("Editar");
        btEditar.setBounds(440, 10, 100, 32);
        pnPrincipal.add(btEditar);
        
        pnTabela = new JPanel(new BorderLayout());
        pnTabela.setBorder(new TitledBorder(""));
        pnTabela.setBounds(180, 130, 400, 300);
        pnPrincipal.add(pnTabela);
        
        
        
        
        Object[] cabecalhoTabela = {"ID","NOME","CPF","SEXO","DATA DE NASCIMENTO","FONE","EMAIL","LOGRADOURO","NUMERO","COMPLEMENTO","CEP","BAIRRO","FAIXA"};
        
        tmAlunos = new DefaultTableModel(cabecalhoTabela, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };
        
        carregarTabela();
        
        
        
        tbAlunos = new JTable(tmAlunos);
        tbAlunos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbAlunos.getColumnModel().getColumn(1).setPreferredWidth(350);
        tbAlunos.getColumnModel().getColumn(2).setWidth(0);
        tbAlunos.getColumnModel().getColumn(2).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(2).setMaxWidth(0); 
        tbAlunos.getColumnModel().getColumn(3).setWidth(0);
        tbAlunos.getColumnModel().getColumn(3).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(3).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(4).setWidth(0);
        tbAlunos.getColumnModel().getColumn(4).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(4).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(5).setWidth(0);
        tbAlunos.getColumnModel().getColumn(5).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(5).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(6).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(6).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(7).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(7).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(8).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(8).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(9).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(9).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(10).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(10).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(11).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(11).setMaxWidth(0);
        tbAlunos.getColumnModel().getColumn(12).setMinWidth(0);
        tbAlunos.getColumnModel().getColumn(12).setMaxWidth(0);
        tbAlunos.getTableHeader().setReorderingAllowed(false);
        //tbAlunos.getTableHeader().setResizingAllowed(false);
        tbAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        spAlunos = new JScrollPane(tbAlunos);
        //spAlunos.setBounds(10, 70, 375, 280);
        pnTabela.add(spAlunos);
    }

    private void definirEventos() {
        
        tbAlunos.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            
             if (e.getClickCount() == 2) {
               
               JTable target = (JTable) e.getSource();
               int row = target.getSelectedRow();
               
               int idB = (Integer) tbAlunos.getValueAt(row, 0);
               String idA = ""+ idB; 
               String nomeA = target.getValueAt(row, 1).toString();
               String cpfA = target.getValueAt(row, 2).toString();
               String sexoA = target.getValueAt(row, 3).toString();
               String dataA = target.getValueAt(row, 4).toString();
               String foneA = target.getValueAt(row, 5).toString();
               String emailA = target.getValueAt(row, 6).toString();
               String logA = target.getValueAt(row, 7).toString();
               String numeroA = target.getValueAt(row, 8).toString();
               String compA = target.getValueAt(row, 9).toString();
               String cepA = target.getValueAt(row, 10).toString();
               String bairroA = target.getValueAt(row, 11).toString();
               String faixaA = target.getValueAt(row, 12).toString();
               
               
               TelaAluno tela = new TelaAluno(idA,nomeA,cpfA,sexoA,dataA,foneA,emailA,logA,numeroA,compA,cepA,bairroA,faixaA);
               
               tela.setVisible(true);
            }
         }
      });
        
      
      
      btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAlunoVIEW formulario = new SaveAlunoVIEW(null,tmAlunos);
                formulario.abrir();
            }
        });
      
      btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AcademiaCTRL().excluirAlunos(tmAlunos,tbAlunos);
            }
        });
      
      btEditar.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
               
               int row = tbAlunos.getSelectedRow();
               if(row < 0){
               
                   JOptionPane.showMessageDialog(null,
                   "Selecione uma linha da tabela para editar",
                   "Erro",
                   JOptionPane.ERROR_MESSAGE);
             }else{
               int idA = (Integer) tbAlunos.getValueAt(row, 0);
               String nomeA = tbAlunos.getValueAt(row, 1).toString();
               String cpfA = tbAlunos.getValueAt(row, 2).toString();
               String sexoA = tbAlunos.getValueAt(row, 3).toString();
               String dataA = tbAlunos.getValueAt(row, 4).toString();
               String foneA = tbAlunos.getValueAt(row, 5).toString();
               String emailA = tbAlunos.getValueAt(row, 6).toString();
               String lograA = tbAlunos.getValueAt(row, 7).toString();
               String numA = tbAlunos.getValueAt(row, 8).toString();
               String compA = tbAlunos.getValueAt(row, 9).toString();
               String cepA = tbAlunos.getValueAt(row, 10).toString();
               String bairroA = tbAlunos.getValueAt(row, 11).toString();
               String faixaA = tbAlunos.getValueAt(row, 12).toString();
        
               EditAlunoVIEW tela = new EditAlunoVIEW (null, tmAlunos, idA, nomeA,cpfA, sexoA, dataA, foneA, emailA, lograA, numA, compA, cepA, bairroA, faixaA );
               tela.setVisible(true);
               }
            }
         
      });
    
        }
    
    private void carregarTabela(){
        tmAlunos = new AcademiaCTRL().listarTodosAlunos(tmAlunos);
    }
    
}
