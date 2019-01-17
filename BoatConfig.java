import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class BoatConfig extends JDialog {

    IBoat boat = null;
    PanelConfig boatPanel;
    boolean succes;

    public BoatConfig(JFrame parent) {
        super(parent, true);
        initialize();
    }

    public boolean isSuccessful() {
        setVisible(true);
        return succes;
    }

    private void initialize() {
        this.getContentPane().setBackground(SystemColor.controlHighlight);
        this.setBounds(100, 100, 565, 418);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        JLabel labelBoat = new JLabel("Лодка");
        labelBoat.setHorizontalAlignment(SwingConstants.CENTER);
        labelBoat.setBounds(10, 29, 153, 84);
        labelBoat.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().add(labelBoat);

        JLabel labelCatamaran = new JLabel("Катамаран");
        labelCatamaran.setHorizontalAlignment(SwingConstants.CENTER);
        labelCatamaran.setBounds(10, 135, 153, 84);
        labelCatamaran.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().add(labelCatamaran);

        JLabel labelMainColor = new JLabel("Основной цвет");
        labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelMainColor.setBounds(211, 223, 133, 50);
        labelMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().add(labelMainColor);

        JLabel labelSecondColor = new JLabel("Доп. цвет");
        labelSecondColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelSecondColor.setBounds(211, 286, 133, 50);
        labelSecondColor.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().add(labelSecondColor);

        boatPanel = new PanelConfig();
        boatPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        FlowLayout flowLayout = (FlowLayout) boatPanel.getLayout();
        boatPanel.setBounds(201, 29, 190, 178);
        this.getContentPane().add(boatPanel);

        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent) e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
            }
        };

        labelBoat.addMouseListener(ml);
        labelCatamaran.addMouseListener(ml);
        labelCatamaran.setTransferHandler(new TransferHandler("text"));
        labelBoat.setTransferHandler(new TransferHandler("text"));

        boatPanel.setDropTarget(new DropTarget() {

            public void drop(DropTargetDropEvent e) {

                try {
                    for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                        if (e.getTransferable().getTransferData(df) == "Лодка") {
                            boat = new Boat(10, 10, Color.WHITE);
                            boatPanel.setBoat(boat);
                            boat.SetPosition(25, 50, boatPanel.getWidth(), boatPanel.getHeight());
                        } else if (e.getTransferable().getTransferData(df) == "Катамаран") {
                            boat = new Catamaran(30, 2, Color.WHITE, Color.BLACK);
                            boatPanel.setBoat(boat);
                            boat.SetPosition(25, 50,boatPanel.getWidth(), boatPanel.getHeight());
                        }
                       boatPanel.repaint();
                    }
                } catch (Exception ex) {
                }

            }

            public void dragEnter(DropTargetDragEvent e) {
                for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                    try {
                        if (e.getTransferable().getTransferData(df) instanceof String)
                            e.acceptDrag(DnDConstants.ACTION_COPY);
                        else
                            e.acceptDrag(DnDConstants.ACTION_NONE);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        JPanel panelYellow = new JPanel();
        panelYellow.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelYellow.setName("cyan");
        panelYellow.setBackground(Color.CYAN);
        panelYellow.setBounds(458, 92, 50, 50);
        this.getContentPane().add(panelYellow);

        JPanel panelWhite = new JPanel();
        panelWhite.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelWhite.setName("magenta");
        panelWhite.setBackground(Color.MAGENTA);
        panelWhite.setBounds(396, 29, 50, 50);
        this.getContentPane().add(panelWhite);

        JPanel panelBlue = new JPanel();
        panelBlue.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelBlue.setName("blue");
        panelBlue.setBackground(Color.BLUE);
        panelBlue.setBounds(458, 29, 50, 50);
        this.getContentPane().add(panelBlue);

        JPanel panelRed = new JPanel();
        panelRed.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelRed.setName("pink");
        panelRed.setBackground(Color.PINK);
        panelRed.setBounds(396, 92, 50, 50);
        this.getContentPane().add(panelRed);

        JPanel panelGreen = new JPanel();
        panelGreen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelGreen.setName("green");
        panelGreen.setBackground(Color.GREEN);
        panelGreen.setBounds(396, 223, 50, 50);
        this.getContentPane().add(panelGreen);

        JPanel panelGrey = new JPanel();
        panelGrey.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelGrey.setName("yellow");
        panelGrey.setBackground(Color.YELLOW);
        panelGrey.setBounds(396, 160, 50, 50);
        this.getContentPane().add(panelGrey);

        JPanel panelBlack = new JPanel();
        panelBlack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelBlack.setName("black");
        panelBlack.setBackground(Color.BLACK);
        panelBlack.setBounds(458, 223, 50, 50);
        this.getContentPane().add(panelBlack);

        JPanel panelOrange = new JPanel();
        panelOrange.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelOrange.setName("orange");
        panelOrange.setBackground(Color.ORANGE);
        panelOrange.setBounds(458, 160, 50, 50);
        this.getContentPane().add(panelOrange);

        panelWhite.addMouseListener(ml);
        panelWhite.setTransferHandler(new TransferHandler("name"));

        panelBlue.addMouseListener(ml);
        panelBlue.setTransferHandler(new TransferHandler("name"));

        panelRed.addMouseListener(ml);
        panelRed.setTransferHandler(new TransferHandler("name"));

        panelGrey.addMouseListener(ml);
        panelGrey.setTransferHandler(new TransferHandler("name"));

        panelBlack.addMouseListener(ml);
        panelBlack.setTransferHandler(new TransferHandler("name"));

        panelOrange.addMouseListener(ml);
        panelOrange.setTransferHandler(new TransferHandler("name"));

        panelYellow.addMouseListener(ml);
        panelYellow.setTransferHandler(new TransferHandler("name"));

        panelGreen.addMouseListener(ml);
        panelGreen.setTransferHandler(new TransferHandler("name"));

        JButton btnAdd = new JButton("Добавить");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                succes = true;
                dispose();
            }
        });
        btnAdd.setBounds(29, 250, 106, 23);
        this.getContentPane().add(btnAdd);

        JButton btnCancell = new JButton("Отмена");
        btnCancell.setBounds(29, 300, 106, 23);
        this.getContentPane().add(btnCancell);
        btnCancell.addActionListener((ActionEvent e) -> {
            succes = false;
            dispose();
        });

        labelMainColor.setDropTarget(new DropTarget() {
            public void drop(DropTargetDropEvent e) {
                if (boat != null) {
                    try {
                        for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                        	boat.setMainColor(e.getTransferable().getTransferData(df).toString());
                            boatPanel.setBoat(boat);
                            boatPanel.repaint();
                        }
                    } catch (Exception ex) {
                    }
                }
            }

            public void dragEnter(DropTargetDragEvent e) {
                for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                    try {
                        if (e.getTransferable().getTransferData(df) instanceof String)
                            e.acceptDrag(DnDConstants.ACTION_COPY);
                        else
                            e.acceptDrag(DnDConstants.ACTION_NONE);
                    } catch (UnsupportedFlavorException | IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        labelSecondColor.setDropTarget(new DropTarget() {
            public void drop(DropTargetDropEvent e) {
                if (boat != null) {
                    try {
                        for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                            ((Catamaran) boat).setDopColor(e.getTransferable().getTransferData(df).toString());
                            boatPanel.setBoat(boat);
                            boatPanel.repaint();
                        }
                    } catch (Exception ex) {
                    }
                }
            }

            public void dragEnter(DropTargetDragEvent e) {
                for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                    try {
                        if (e.getTransferable().getTransferData(df) instanceof String)
                            e.acceptDrag(DnDConstants.ACTION_COPY);
                        else
                            e.acceptDrag(DnDConstants.ACTION_NONE);
                    } catch (UnsupportedFlavorException | IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public IBoat getBoat() {
        return boat;
    }

}