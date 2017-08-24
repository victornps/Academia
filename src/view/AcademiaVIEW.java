package view;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;




public class AcademiaVIEW extends JFrame{
   
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnAlunos, mnInstrutores, mnExames;
    private JMenuItem miListaAluno, miListaInstrutor, miAgenda;
    private JLabel background = new JLabel(new ImageIcon("gym.png"));
    
    public AcademiaVIEW (){
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Academia");
        setBounds(0, 0, 800, 600);
        
        contentPane = getContentPane();
        contentPane.add(background);
        
        mnBarra = new JMenuBar();
        
        mnAlunos = new JMenu("Alunos");
        mnAlunos.setMnemonic(KeyEvent.VK_A);
        
        mnInstrutores = new JMenu("Instrutores");
        mnInstrutores.setMnemonic(KeyEvent.VK_I);
        
        mnExames= new JMenu("Exames");
        mnExames.setMnemonic(KeyEvent.VK_E);
        
        miListaAluno = new JMenuItem("Lista");
        miListaInstrutor = new JMenuItem("Lista");
        miAgenda = new JMenuItem("Agenda");
        
        mnAlunos.add(miListaAluno);
        mnInstrutores.add(miListaInstrutor);
        mnExames.add(miAgenda);
        
        mnBarra.add(mnAlunos);
        mnBarra.add(mnInstrutores);
        mnBarra.add(mnExames);
        
        setJMenuBar(mnBarra);
        
    }

    private void definirEventos() {
        
        miListaAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAlunos panel = new GuiAlunos();
                
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate(); 
                
                
            }
        });
        
        miListaInstrutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiInstrutores panel = new GuiInstrutores();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        
        miAgenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAgendaExames panel = new GuiAgendaExames();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        
        
   }
    
   
    
    
    public static void main(String[] args) {
        AcademiaVIEW janela = new AcademiaVIEW();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dimensao.width - janela.getSize().width) / 2;
        int y = (dimensao.height - janela.getSize().height) / 2;
        janela.setLocation(x, y);
        janela.setVisible(true);
        JOptionPane.showMessageDialog(null, "Seja Bem-Vindo Instrutor!");
        
        
        
        
        
    }
    
}

