package com.ggl.qlocktwo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.ggl.qlocktwo.model.QlocktwoCharacter;
import com.ggl.qlocktwo.model.QlocktwoModel;

public class CharacterPanel {

   private JLabel[][] label;
    
   private JPanel panel;
    
   private QlocktwoModel model;

   public CharacterPanel(QlocktwoModel model) {
       this.model = model;
       createPartControl();
   }
    
   private void createPartControl() {
       int height = model.getHeight();
       int width = model.getWidth();
        
       panel = new JPanel();
       panel.setBackground(model.getColorScheme().getBackground());
       panel.setLayout(new GridLayout(height, width));
        
       Font font = new Font("SansSerif", Font.BOLD, 36);
        
       label = new JLabel[height][width];
        
       QlocktwoCharacter[][] characterArray = 
               model.getCharacterArray();
        
       Border border = BorderFactory.createLineBorder(
               model.getColorScheme().getBackground(), 4);
        
       for (int i = 0; i < height; i++) {
           for (int j = 0; j < width; j++) {
               String s = Character.toString(
                       characterArray[i][j].getCharacter());
               label[i][j] = new JLabel(s);
               label[i][j].setBorder(border);
               label[i][j].setFont(font);
               label[i][j].setForeground(
                       model.getColorScheme().getOff());
               label[i][j].setHorizontalAlignment(JLabel.CENTER);
               panel.add(label[i][j]);
           }
       }
   }
    
   public void updatePartControl() {
       panel.setBackground(model.getColorScheme().getBackground());
        
       Border border = BorderFactory.createLineBorder(
               model.getColorScheme().getBackground(), 4);
        
       int height = model.getHeight();
       int width = model.getWidth();
        
       QlocktwoCharacter[][] characterArray = 
               model.getCharacterArray();
        
       for (int i = 0; i < height; i++) {
           for (int j = 0; j < width; j++) {
               Color color = null;
               if (characterArray[i][j].isOn()) {
                   color = model.getColorScheme().getOn();
               } else {
                   color = model.getColorScheme().getOff();
               }
               label[i][j].setBorder(border);
               label[i][j].setForeground(color);
           }
       }
   }

   public JPanel getPanel() {
       return panel;
   }
    
}
