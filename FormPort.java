import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
public class FormPort {

    private JFrame frame;
    private JPanel panel;
    private JList listBoxLevels;
    private DefaultListModel model;
    private JPanel panelTake;
    private int countLevel = 5;
    private JTextField maskedTextBox1;
    MultiLevelPort port;
    private PanelBoat pictureBoxTakeBoat;
    private PanelPort panelPort;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormPort window = new FormPort();
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
    public FormPort() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 980, 503);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        JMenuItem menuSave = new JMenuItem("Save");
        menuSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser filesave = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("txt file", "txt");
                filesave.setFileFilter(filter);
                if (filesave.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = filesave.getSelectedFile();
                    String path = file.getAbsolutePath();
                    if (port.saveData(path)) {
                        JOptionPane.showMessageDialog(null, "Saved");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Save failed", "", 0, null);
                    }
                }
            }
        });
        menuFile.add(menuSave);

        JMenuItem menuLoad = new JMenuItem("Load");
        menuLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("txt file", "txt");
                fileChooser.setFileFilter(filter);
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        if (port.loadData(file.getAbsolutePath())) {
                            JOptionPane.showMessageDialog(null, "Loaded");
                        } else {
                            JOptionPane.showMessageDialog(null, "Load failed", "", 0, null);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "", 0, null);
                    }
                    panelPort.repaint();
                }
            }
        });
        menuFile.add(menuLoad);


        panelPort= new PanelPort();
        panelPort .setBounds(0, 11, 777, 443);
        frame.getContentPane().add(panelPort);
        port = panelPort.getPort();
        JPanel pictureBoxPort = new JPanel();
        pictureBoxPort.setBounds(0, 0, 778, 466);
        frame.getContentPane().add(pictureBoxPort);

        JButton buttonSetBoat = new JButton("Заказать судно");
        buttonSetBoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if (listBoxLevels.getSelectedIndex() > -1) {
                    BoatConfig dConfig = new BoatConfig(frame);
                    if (dConfig.isSuccessful()) {
                        PanelTakeBoat.boat = dConfig.getBoat();
                        int i = port.getPort(listBoxLevels.getSelectedIndex()).Plus(PanelTakeBoat.boat);
                        panelPort.repaint();
                    }
                }
            }
        });
        buttonSetBoat.setBounds(790, 141,  140, 41);
        frame.getContentPane().add(buttonSetBoat);

        JPanel panel = new JPanel();
        panel.setBounds(779, 226, 250, 230);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        pictureBoxTakeBoat = new PanelBoat();
        pictureBoxTakeBoat.setBounds(12, 102, 250, 180);
        panel.add(pictureBoxTakeBoat);

        JLabel label = new JLabel("Забрать судно");
        label.setBounds(12, 0, 118, 16);
        panel.add(label);

        maskedTextBox1 = new JTextField();
        maskedTextBox1.setBounds(68, 29, 70, 22);
        panel.add(maskedTextBox1);
        maskedTextBox1.setColumns(10);

        JLabel label_1 = new JLabel("Место:");
        label_1.setBounds(12, 32, 56, 16);
        panel.add(label_1);

        JButton buttonTakeBoat = new JButton("Забрать");
        buttonTakeBoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!maskedTextBox1.getText().equals("")) {
                    IBoat boat = port.getPort(listBoxLevels.getSelectedIndex()).Minus(Integer.parseInt(maskedTextBox1.getText()));
                    if (boat != null) {
                        boat.SetPosition(5,50, pictureBoxTakeBoat.getWidth(), pictureBoxTakeBoat.getHeight());
                        pictureBoxTakeBoat.setBoat(boat);
                        pictureBoxTakeBoat.repaint();
                        panelPort.repaint();
                    } else {
                    	pictureBoxTakeBoat.setBoat(null);
                    	pictureBoxTakeBoat.repaint();
                    }
                }
            }
        });
        buttonTakeBoat.setBounds(22, 64, 97, 25);
        panel.add(buttonTakeBoat);

        listBoxLevels = new JList();
        listBoxLevels.setBounds(790, 11, 118, 118);
        frame.getContentPane().add(listBoxLevels);
        model = new DefaultListModel();
        for(int i = 0; i < 5; i++)
        {
            model.addElement("Уровень " + (i + 1));
        }
        listBoxLevels.setModel(model);
        listBoxLevels.setSelectedIndex(0);
        panelPort.setListLevels(listBoxLevels);
        listBoxLevels.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                panelPort.repaint();
            }
        });

    }
}