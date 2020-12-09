package com.ggl.qlocktwo.view;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
 
import javax.swing.JPanel;
 
import com.ggl.qlocktwo.model.QlocktwoModel;
 
public class DotPanel extends JPanel {
 
    private static final long serialVersionUID = -6203388399246019293L;
     
    private boolean on;
     
    private QlocktwoModel model;
     
    public DotPanel(QlocktwoModel model) {
        this.model = model;
    }
 
    public boolean isOn() {
        return on;
    }
 
    public void setOn(boolean on) {
        this.on = on;
    }
 
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(64, 64);
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(model.getColorScheme().getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        Color color = null;
        if (isOn()) {
            color = model.getColorScheme().getOn();
        } else {
            color = model.getColorScheme().getOff();
        }
        paintCircle(g, color, 6, getWidth() / 2, getHeight() / 2);
    }
     
    private void paintCircle(Graphics g, Color color, 
            int radius, int x, int y) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius + radius, 
                radius + radius);
    }
}
