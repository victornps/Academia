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

public class GuiInstrutores extends JPanel{
 
    
    private JScrollPane spInstrutores;
    private JTable tbInstrutores;
    private JPanel pnPrincipal, pnTabela;
    private DefaultTableModel tmInstrutores;
    private JButton btAdicionar, btRemover, btEditar;
    
    public GuiInstrutores() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBounds(0, 0, 600, 600);
        add(pnPrincipal);
        
        pnTabela = new JPanel(new BorderLayout());
        pnTabela.setBorder(new TitledBorder(""));
        pnTabela.setBounds(190, 130, 350, 300);
        pnPrincipal.add(pnTabela);
        
        btAdicionar = new JButton("Adicionar");
        btAdicionar.setBounds(200, 10, 100, 32);
        pnPrincipal.add(btAdicionar);
        
        btRemover = new JButton("Remover");
        btRemover.setBounds(310, 10, 100, 32);
        pnPrincipal.add(btRemover);
        
        btEditar = new JButton("Editar");
        btEditar.setBounds(420, 10, 100, 32);
        pnPrincipal.add(btEditar);
        
        
        
        
        Object[] cabecalhoTabela = {"ID","NOME","CPF","SEXO","DATA DE NASCIMENTO","FONE","EMAIL","LOGRADOURO","NUMERO","COMPLEMENTO","CEP","BAIRRO"};
        
        tmInstrutores = new DefaultTableModel(cabecalhoTabela, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };
        
        carregarTabela();
        
        
        
        tbInstrutores = new JTable(tmInstrutores);
        tbInstrutores.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbInstrutores.getColumnModel().getColumn(1).setPreferredWidth(300);
        tbInstrutores.getColumnModel().getColumn(2).setWidth(0);
        tbInstrutores.getColumnModel().getColumn(2).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(2).setMaxWidth(0); 
        tbInstrutores.getColumnModel().getColumn(3).setWidth(0);
        tbInstrutores.getColumnModel().getColumn(3).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(3).setMaxWidth(0);
        tbInstrutores.getColumnModel().getColumn(4).setWidth(0);
        tbInstrutores.getColumnModel().getColumn(4).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(4).setMaxWidth(0);
        tbInstrutores.getColumnModel().getColumn(5).setWidth(0);
        tbInstrutores.getColumnModel().getColumn(5).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(5).setMaxWidth(0);
        tbInstrutores.getColumnModel().getColumn(6).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(6).setMaxWidth(0);
        tbInstrutores.getColumnModel().getColumn(7).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(7).setMaxWidth(0);
        tbInstrutores.getColumnModel().getColumn(8).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(8).setMaxWidth(0);
        tbInstrutores.getColumnModel().getColumn(9).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(9).setMaxWidth(0);
        tbInstrutores.getColumnModel().getColumn(10).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(10).setMaxWidth(0);
        tbInstrutores.getColumnModel().getColumn(11).setMinWidth(0);
        tbInstrutores.getColumnModel().getColumn(11).setMaxWidth(0);
        
        tbInstrutores.getTableHeader().setReorderingAllowed(false);
        //tbInstrutores.getTableHeader().setResizingAllowed(false);
        tbInstrutores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        spInstrutores = new JScrollPane(tbInstrutores);
        //spInstrutores.setBounds(10, 70, 375, 280);
        pnTabela.add(spInstrutores);
    }

    private void definirEventos() {
        
        tbInstrutores.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            
             if (e.getClickCount() == 2) {
               
               JTable target = (JTable) e.getSource();
               int row = target.getSelectedRow();
               
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
               
               
               
               TelaInstrutor tela = new TelaInstrutor(nomeA,cpfA,sexoA,dataA,foneA,emailA,logA,numeroA,compA,cepA,bairroA);
               
               tela.setVisible(true);
            }
         }
      });
        
      
      
      btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveInstrutorVIEW formulario = new SaveInstrutorVIEW(null,tmInstrutores);
                formulario.abrir();
            }
        });
      
      btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AcademiaCTRL().excluirInstrutores(tmInstrutores,tbInstrutores);
            }
        });
      
      btEditar.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
               
               
               
               int row = tbInstrutores.getSelectedRow();
               if(row < 0){
               
                   JOptionPane.showMessageDialog(null,
                   "Selecione uma linha da tabela para editar",
                   "Erro",
                   JOptionPane.ERROR_MESSAGE);
             }else{
               int idA = (Integer) tbInstrutores.getValueAt(row, 0);
               String nomeA = tbInstrutores.getValueAt(row, 1).toString();
               String cpfA = tbInstrutores.getValueAt(row, 2).toString();
               String sexoA = tbInstrutores.getValueAt(row, 3).toString();
               String dataA = tbInstrutores.getValueAt(row, 4).toString();
               String foneA = tbInstrutores.getValueAt(row, 5).toString();
               String emailA = tbInstrutores.getValueAt(row, 6).toString();
               String lograA = tbInstrutores.getValueAt(row, 7).toString();
               String numA = tbInstrutores.getValueAt(row, 8).toString();
               String compA = tbInstrutores.getValueAt(row, 9).toString();
               String cepA = tbInstrutores.getValueAt(row, 10).toString();
               String bairroA = tbInstrutores.getValueAt(row, 11).toString();
               
        
               EditInstrutorVIEW tela = new EditInstrutorVIEW (null, tmInstrutores, idA, nomeA,cpfA, sexoA, dataA, foneA, emailA, lograA, numA, compA, cepA, bairroA);
               tela.setVisible(true);
               }
            }
         
      });
    
        }
    
    private void carregarTabela(){
        tmInstrutores = new AcademiaCTRL().listarInstrutores(tmInstrutores);
    }
    
}
