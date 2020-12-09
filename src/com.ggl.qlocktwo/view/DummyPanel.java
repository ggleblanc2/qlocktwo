package com.ggl.qlocktwo.view;
 
import java.awt.Graphics;
 
import javax.swing.JPanel;
 
import com.ggl.qlocktwo.model.QlocktwoModel;
 
public class DummyPanel extends JPanel {
 
    private static final long serialVersionUID = -2025698607367461610L;
     
    private QlocktwoModel model;
     
    public DummyPanel(QlocktwoModel model) {
        this.model = model;
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(model.getColorScheme().getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
 
}
