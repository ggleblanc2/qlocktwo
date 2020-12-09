package com.ggl.qlocktwo.view;
 
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.ggl.qlocktwo.model.QlocktwoModel;
 
public class QlocktwoPanel {
     
    protected static final Insets zeroInsets = 
            new Insets(0, 0, 0, 0);
     
    private CharacterPanel characterPanel;
     
    private DotPanel dotPanelNW;
    private DotPanel dotPanelNE;
    private DotPanel dotPanelSE;
    private DotPanel dotPanelSW;
     
    private DummyPanel dummyPanel1;
    private DummyPanel dummyPanel2;
    private DummyPanel dummyPanel3;
    private DummyPanel dummyPanel4;
     
    private JPanel panel;
     
    private QlocktwoModel model;
     
    public QlocktwoPanel(QlocktwoModel model) {
        this.model = model;
        createPartControl();
    }
 
    private void createPartControl() {
        characterPanel = new CharacterPanel(model);
         
        dotPanelNW = new DotPanel(model);
        dotPanelNE = new DotPanel(model);
        dotPanelSE = new DotPanel(model);
        dotPanelSW = new DotPanel(model);
         
        dummyPanel1 = new DummyPanel(model);
        dummyPanel2 = new DummyPanel(model);
        dummyPanel3 = new DummyPanel(model);
        dummyPanel4 = new DummyPanel(model);
         
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
         
        int gridy = 0;
          
        addComponent(panel, dotPanelNW, 0, gridy, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
         
        addComponent(panel, dummyPanel1, 1, gridy, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
         
        addComponent(panel, dotPanelNE, 2, gridy++, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
         
        addComponent(panel, dummyPanel2, 0, gridy, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
         
        addComponent(panel, characterPanel.getPanel(), 1, gridy, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
         
        addComponent(panel, dummyPanel3, 2, gridy++, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
         
        addComponent(panel, dotPanelSW, 0, gridy, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
         
        addComponent(panel, dummyPanel4, 1, gridy, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
         
        addComponent(panel, dotPanelSE, 2, gridy++, 1, 1,
                zeroInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);
    }
     
    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, 
            Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, 
                insets, 0, 0);
        container.add(component, gbc);
    }
 
    public JPanel getPanel() {
        return panel;
    }
     
    public void updateCharacterPanel() {
        characterPanel.updatePartControl();
    }
     
    public void repaint() {
        dummyPanel1.repaint();
        dummyPanel2.repaint();
        dummyPanel3.repaint();
        dummyPanel4.repaint();
    }
     
    public void updateDotPanels(int minute) {
        int dot = minute % 5;
         
        if (dot == 0) {
            dotPanelNW.setOn(false);
            dotPanelNE.setOn(false);
            dotPanelSE.setOn(false);
            dotPanelSW.setOn(false);
        } else if (dot == 1) {
            dotPanelNW.setOn(true);
            dotPanelNE.setOn(false);
            dotPanelSE.setOn(false);
            dotPanelSW.setOn(false);
        } else if (dot == 2) {
            dotPanelNW.setOn(true);
            dotPanelNE.setOn(true);
            dotPanelSE.setOn(false);
            dotPanelSW.setOn(false);
        } else if (dot == 3) {
            dotPanelNW.setOn(true);
            dotPanelNE.setOn(true);
            dotPanelSE.setOn(true);
            dotPanelSW.setOn(false);
        } else if (dot == 4) {
            dotPanelNW.setOn(true);
            dotPanelNE.setOn(true);
            dotPanelSE.setOn(true);
            dotPanelSW.setOn(true);
        } 
         
        dotPanelNW.repaint();
        dotPanelNE.repaint();
        dotPanelSE.repaint();
        dotPanelSW.repaint();
    }
 
}