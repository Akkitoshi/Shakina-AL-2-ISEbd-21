import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FormBoat {

    private JFrame frame;
    private JPanel panel;
    private JButton buttonUp;
    private JButton buttonDown;
    private JButton buttonLeft;
    private JButton buttonRight;
    private JButton buttonCreateBoat;
    private JButton buttonCreateCatamaran;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormBoat window = new FormBoat();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */

    public FormBoat() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 901, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        panel = new PanelBoat();
        panel.setBounds(12, 13, 864, 439);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        buttonRight = new JButton("");
        buttonRight.setIcon(new ImageIcon("C:\\Doc\\Right.png"));
        buttonRight.setBounds(814, 386, 50, 50);
        panel.add(buttonRight);
        buttonRight.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PanelBoat.initialization) {
                    PanelBoat.boat.MoveTransport(Direction.Right);
                }
                UpDate();
            }
        });
        buttonDown = new JButton("");
        buttonDown.setIcon(new ImageIcon("C:\\Doc\\Down.png"));
        buttonDown.setBounds(751, 386, 50, 50);
        panel.add(buttonDown);
        buttonDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PanelBoat.initialization) {
                    PanelBoat.boat.MoveTransport(Direction.Down);
                }
                UpDate();
            }
        });
        buttonLeft = new JButton("");
        buttonLeft.setIcon(new ImageIcon("C:\\Doc\\Left.png"));
        buttonLeft.setBounds(689, 386, 50, 50);
        panel.add(buttonLeft);
        buttonLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PanelBoat.initialization) {
                    PanelBoat.boat.MoveTransport(Direction.Left);
                }
                UpDate();
            }
        });
        buttonUp = new JButton("");
        buttonUp.setIcon(new ImageIcon("C:\\Doc\\Up.png"));
        buttonUp.setBounds(751, 323, 50, 50);
        panel.add(buttonUp);
        buttonUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PanelBoat.initialization) {
                    PanelBoat.boat.MoveTransport(Direction.Up);
                }
                UpDate();
            }
        });
        buttonCreateBoat = new JButton("Создать лодку");
        buttonCreateBoat.setBounds(0, 0, 160, 25);
        panel.add(buttonCreateBoat);
        buttonCreateBoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Random rnd = new Random();
                PanelBoat.boat = new Boat(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000, Color.GRAY);
                PanelBoat.initialization = true;
                PanelBoat.boat.SetPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 60, panel.getWidth(), panel.getHeight());
                UpDate();
            }
        });

        buttonCreateCatamaran = new JButton("Создать катамаран");
        buttonCreateCatamaran.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Random rnd = new Random();
                PanelBoat.boat = new Catamaran(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000, Color.GRAY, Color.BLUE);
                PanelBoat.initialization = true;
                PanelBoat.boat.SetPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 60, panel.getWidth(), panel.getHeight());
                UpDate();
            }
        });
        buttonCreateCatamaran.setBounds(180, 0, 160, 25);
        panel.add(buttonCreateCatamaran);
    }

    private void UpDate() {
        panel.repaint();
    }
}