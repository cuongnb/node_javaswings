package ObjetDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by cuongnb on 11/8/16.
 */
public class Person implements Paintable {
    String person;
    private Rectangle2D bounds;
    int w = 40;
    int h = 90;
    boolean isFource = false;

    public Person(String person, int x, int y) {
        this.person = person;
        bounds = new Rectangle2D.Double(x, y, w, h);
    }

    @Override
    public void paint(JComponent parent, Graphics2D g2d) {
        Graphics2D g2 = (Graphics2D) g2d.create();
        g2.translate(bounds.getX(), bounds.getY());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawOval(0, 0, 20, 20); // head
        g2.drawLine(10, 20, 10, 50); // bounds.getY()
        g2.drawLine(10, 20, 25, 40); // right hand
        g2.drawLine(10, 20, -5, 40); // left hand
        g2.drawLine(10, 50, -5, 70); // left leg
        g2.drawLine(10, 50, 25, 70); // right leg
        g2.drawString(person, 0 - 15, 85);
        g2.dispose();
    }

    @Override
    public boolean contains(Point p) {
        return bounds.contains(p);
    }

    @Override
    public void moveTo(Point2D p) {
        bounds = new Rectangle2D.Double(p.getX(), p.getY(), w, h);
    }

    @Override
    public Rectangle2D getBounds() {
        return bounds.getBounds2D();
    }

    public String getPerson() {
        return person;
    }

    public boolean isFource() {
        return isFource;
    }

    public void setFource(boolean fource) {
        isFource = fource;
    }
}
