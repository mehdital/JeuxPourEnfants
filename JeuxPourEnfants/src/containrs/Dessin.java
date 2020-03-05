/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alixia
 */
public class Dessin extends JPanel {

    int x = 0, y = 0;
    JPanel container = new JPanel();
    JLabel label = new JLabel();
    JPanel dessin = new JPanel();
    BoxLayout bl = new BoxLayout(this, Y_AXIS);

    public Dessin() {
        dessin.setBackground(Color.cyan);
        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

            }
        });
        container.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = dessin.getGraphics();
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();

            }
        });

        container.setLayout(new BorderLayout());
        container.add(label, BorderLayout.SOUTH);
        container.add(dessin, BorderLayout.CENTER);
        this.add(container);
    }

}
