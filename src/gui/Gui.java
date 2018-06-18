package gui;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import threads.AnimalThreads;

/**
 *
 * @author Jeniffer Merino
 */
public class Gui extends JFrame {

    private JLabel[] labels;
    private JButton inicio;
    private JButton reiniciar;
    private String[] nombre = {"canguro", "tortuga", "dragon"};

    public Gui() {
        super("Carrera de animales");
        initialComponens();
    }

    private void initialComponens() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        reiniciar = new JButton("Reiniciar");
        Container container = getContentPane();

        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombre[i] + ".gif")));
            labels[i].setBounds(10, (i * 200) + 10, 200, 200);
            container.add(labels[i]);
        }
        inicio.setBounds(10, 0, 100, 30);
        container.add(inicio);
        reiniciar.setBounds(100, 0, 100, 30);
        container.add(reiniciar);

        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThreads canguro = new AnimalThreads("canguro", 500, labels[0], labels[0].getX(), labels[0].getY());
                AnimalThreads tortuga = new AnimalThreads("tortuga", 500, labels[1], labels[1].getX(), labels[1].getY());
                AnimalThreads dragon = new AnimalThreads("dragon", 500, labels[2], labels[2].getX(), labels[2].getY());
                canguro.start();
                tortuga.start();
                dragon.start();
                //(levantar el verificador)verificador.start();
                 
            }
        });
        setSize(700, 650);

        reiniciar.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
           
            labels[i].setBounds(10, (i * 200) + 10, 200, 200);
           reiniciar.setVisible(false);
        }
              

            }
            
        });

    }
    
    public static void main(String[]args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
            
            
        });
    }
}


