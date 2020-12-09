package com.ggl.qlocktwo.view;
 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
import com.ggl.qlocktwo.model.QlocktwoModel;
 
public class QlocktwoMenuBar {
     
    private JMenu colorsMenu;
    private JMenu fileMenu;
    private JMenu optionsMenu;
     
    private JMenuBar menuBar;
     
    private JMenuItem blackColorMenuItem;
    private JMenuItem blueColorMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem greenColorMenuItem;
    private JMenuItem pinkColorMenuItem;
    private JMenuItem redColorMenuItem;
    private JMenuItem testingMenuItem;
     
    private QlocktwoFrame frame;
     
    private QlocktwoModel model;
 
    public QlocktwoMenuBar(QlocktwoFrame frame, QlocktwoModel model) {
        this.frame = frame;
        this.model = model;
        createPartControl();
        updatePartControl();
    }
     
    private void createPartControl() {
        menuBar = new JMenuBar();
         
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);
         
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                frame.exitProcedure();
            }   
        });
        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        fileMenu.add(exitMenuItem);
         
        colorsMenu = new JMenu("Colors");
        colorsMenu.setMnemonic(KeyEvent.VK_C);
        menuBar.add(colorsMenu);
         
        ButtonGroup group = new ButtonGroup();
        ColorActionListener listener = new ColorActionListener();
         
        blackColorMenuItem = new JRadioButtonMenuItem(
                "Black background");
        blackColorMenuItem.addActionListener(listener);
        blackColorMenuItem.setActionCommand("black");
        blackColorMenuItem.setMnemonic(KeyEvent.VK_B);
        blackColorMenuItem.setSelected(true);
        group.add(blackColorMenuItem);
        colorsMenu.add(blackColorMenuItem);
         
        blueColorMenuItem = new JRadioButtonMenuItem(
                "Blue background");
        blueColorMenuItem.addActionListener(listener);
        blueColorMenuItem.setActionCommand("blue");
        blueColorMenuItem.setMnemonic(KeyEvent.VK_U);
        blueColorMenuItem.setSelected(true);
        group.add(blueColorMenuItem);
        colorsMenu.add(blueColorMenuItem);
         
        greenColorMenuItem = new JRadioButtonMenuItem(
                "Green background");
        greenColorMenuItem.addActionListener(listener);
        greenColorMenuItem.setActionCommand("green");
        greenColorMenuItem.setMnemonic(KeyEvent.VK_G);
        greenColorMenuItem.setSelected(true);
        group.add(greenColorMenuItem);
        colorsMenu.add(greenColorMenuItem);
         
        pinkColorMenuItem = new JRadioButtonMenuItem(
                "Pink background");
        pinkColorMenuItem.addActionListener(listener);
        pinkColorMenuItem.setActionCommand("pink");
        pinkColorMenuItem.setMnemonic(KeyEvent.VK_K);
        group.add(pinkColorMenuItem);
        colorsMenu.add(pinkColorMenuItem);
         
        redColorMenuItem = new JRadioButtonMenuItem(
                "Red background");
        redColorMenuItem.addActionListener(listener);
        redColorMenuItem.setActionCommand("red");
        redColorMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(redColorMenuItem);
        colorsMenu.add(redColorMenuItem);
         
        optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic(KeyEvent.VK_O);
        menuBar.add(optionsMenu);
         
        testingMenuItem = new JCheckBoxMenuItem(
                "Test Clock");
        testingMenuItem.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                JCheckBoxMenuItem item = 
                        (JCheckBoxMenuItem) event.getSource();
                if (item.isSelected()) {
                    model.setTestClock(true);
                } else {
                    model.setTestClock(false);
                }
            }   
        });
        testingMenuItem.setMnemonic(KeyEvent.VK_T);
        optionsMenu.add(testingMenuItem);
    }
     
    private void updatePartControl() {
        Color background = model.getColorScheme().getBackground();
        Color on = model.getColorScheme().getOn();
         
        menuBar.setBackground(background);
         
        fileMenu.setForeground(on);
         
        exitMenuItem.setBackground(background);
        exitMenuItem.setForeground(on);
         
        colorsMenu.setForeground(on);
         
        blackColorMenuItem.setBackground(background);
        blackColorMenuItem.setForeground(on);
         
        blueColorMenuItem.setBackground(background);
        blueColorMenuItem.setForeground(on);
         
        greenColorMenuItem.setBackground(background);
        greenColorMenuItem.setForeground(on);
         
        pinkColorMenuItem.setBackground(background);
        pinkColorMenuItem.setForeground(on);
         
        redColorMenuItem.setBackground(background);
        redColorMenuItem.setForeground(on);
         
        optionsMenu.setForeground(on);
         
        testingMenuItem.setBackground(background);
        testingMenuItem.setForeground(on);
    }
 
    public JMenuBar getMenuBar() {
        return menuBar;
    }
     
    public class ColorActionListener implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            Object o = event.getSource();
            JRadioButtonMenuItem item = (JRadioButtonMenuItem) o;
            if (item.isSelected()) {
                if (command.equals("black")) {
                    model.getColorScheme().setBlackColorScheme();
                } else if (command.equals("blue")) {
                    model.getColorScheme().setBlueColorScheme();
                } else if (command.equals("green")) {
                    model.getColorScheme().setGreenColorScheme();
                } else if (command.equals("pink")) {
                    model.getColorScheme().setPinkColorScheme();
                } else if (command.equals("red")) {
                    model.getColorScheme().setRedColorScheme();
                } 
                frame.updateCharacterPanel();
                frame.updateDotPanels();
                updatePartControl();
            }
        }
    }
     
}