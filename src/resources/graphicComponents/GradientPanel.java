package resources.graphicComponents;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {

    private Color gradientColor1 = new Color(255, 90, 90); // Cor 1 do gradiente
    private Color gradientColor2 = new Color(42, 199, 80); // Cor 2 do gradiente

    public Color getGradientColor1() {
        return gradientColor1;
    }

    public void setGradientColor1(Color gradientColor1) {
        this.gradientColor1 = gradientColor1;
        repaint();
    }

    public Color getGradientColor2() {
        return gradientColor2;
    }

    public void setGradientColor2(Color gradientColor2) {
        this.gradientColor2 = gradientColor2;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        
        // Desenha o gradiente de cima para baixo
        GradientPaint gp = new GradientPaint(0, 0, gradientColor1, 0, height, gradientColor2);
        g2.setPaint(gp);
        g2.fillRect(0, 0, width, height);
    }
}
