package view;

import controller.AcademiaCTRL;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class GuiAgendaExames extends JPanel{
    
    
    private JScrollPane spTabela;
    private JTable tbAgenda;
    private JPanel pnPrincipal, pnTabela;
    private DefaultTableModel tmAgendamento;
    private JButton btAdicionar, btRemover, btEditar;
    
    public GuiAgendaExames() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBounds(0, 0, 400, 400);
        add(pnPrincipal);
        
        btAdicionar = new JButton("Adicionar");
        btAdicionar.setBounds(10, 10, 100, 32);
        pnPrincipal.add(btAdicionar);
        
        btRemover = new JButton("Remover");
        btRemover.setBounds(120, 10, 100, 32);
        pnPrincipal.add(btRemover);
        
        btEditar = new JButton("Editar");
        btEditar.setBounds(230, 10, 100, 32);
        pnPrincipal.add(btEditar);
        
        pnTabela = new JPanel(new BorderLayout());
        pnTabela.setBorder(new TitledBorder("Agenda de Exames"));
        pnTabela.setBounds(10, 130, 350, 230);
        pnPrincipal.add(pnTabela);
        
        Object[] cabecalhoTabela = {"Id", "Data", "Faixas"};
        
        tmAgendamento = new DefaultTableModel(cabecalhoTabela, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };
        
        carregarTabela();
        
        tbAgenda = new JTable(tmAgendamento);
        tbAgenda.getColumnModel().getColumn(0).setWidth(0);
        tbAgenda.getColumnModel().getColumn(0).setMinWidth(0);
        tbAgenda.getColumnModel().getColumn(0).setMaxWidth(0);
        tbAgenda.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbAgenda.getColumnModel().getColumn(2).setPreferredWidth(200);
        //tabela.getColumnModel().getColumn(0).setResizable(false);
        //tabela.getColumnModel().getColumn(1).setResizable(false);
        //tabela.getColumnModel().getColumn(2).setResizable(false);
        
        tbAgenda.getTableHeader().setReorderingAllowed(false);
        tbAgenda.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        spTabela = new JScrollPane(tbAgenda);
        pnTabela.add(spTabela);
    }

    private void definirEventos() {
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAgendaExamesVIEW formulario = new SaveAgendaExamesVIEW(null,tmAgendamento);
                formulario.abrir();
            }
        });
      
        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AcademiaCTRL().excluirExame(tmAgendamento,tbAgenda);
            }
        });
      
        btEditar.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
               
               int row = tbAgenda.getSelectedRow();
               if(row < 0){
               
                   JOptionPane.showMessageDialog(null,
                   "Selecione uma linha da tabela para editar",
                   "Erro",
                   JOptionPane.ERROR_MESSAGE);
             }else{
               int idE = (Integer) tbAgenda.getValueAt(row, 0);
               String dataE = tbAgenda.getValueAt(row, 1).toString();
               String faixaE = tbAgenda.getValueAt(row, 2).toString();
        
               EditAgendaExamesVIEW tela = new EditAgendaExamesVIEW (null, tmAgendamento, idE, dataE, faixaE);
               tela.setVisible(true);
               }
            }
         
      });
    }
    
    private void carregarTabela(){
        tmAgendamento = new AcademiaCTRL().listarExames(tmAgendamento);
    }
    
    
    
}
