package Main;

import ObjetDraw.Fruit;
import ObjetDraw.Paintable;
import ObjetDraw.Person;
import ObjetDraw.Relationship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnb on 11/8/16.
 */
public class Main extends JPanel {
    private List<Person> persons;
    private List<Fruit> fruits;
    private Point2D offset;
    private static Font baseFont;
    private static final int W = 640;
    private static final int H = 480;

    private Paintable selectedShape;

    private List<Relationship> relationships;

    public Main(List<Person> persons, List<Fruit> fruits) {
        this.persons = persons;
        this.fruits = fruits;
//        persons = new ArrayList<>();
//        fruits = new ArrayList<>();
        relationships = new ArrayList<>(25);
        baseFont = new Font("Sans Serif", Font.BOLD, 12);

        String person1 = "Jimmy";
        String person2 = "Sally";


        String fruit1 = "Banana";
        String fruit2 = "Apple";
        String fruit3 = "Orange";
        String fruit4 = "Watermelon";
        String fruit5 = "Pineapple";
        String fruit6 = "Grapes";

        Person person = new Person(person1, 50, 50);
        addPerson(person);

        Fruit bubble = new Fruit(fruit1, baseFont, 150, 50);
        addFruit(bubble);
        relate(person, bubble);
        bubble = new Fruit(fruit2, baseFont, 150, 100);
        addFruit(bubble);
        relate(person, bubble);
        bubble = new Fruit(fruit3, baseFont, 150, 150);
        addFruit(bubble);
        relate(person, bubble);

        person = new Person(person2, 50, 150);
        addPerson(person);

        bubble = new Fruit(fruit4, baseFont, 150, 200);
        addFruit(bubble);
        relate(person, bubble);
        bubble = new Fruit(fruit5, baseFont, 150, 250);
        addFruit(bubble);
        relate(person, bubble);
        bubble = new Fruit(fruit6, baseFont, 150, 300);
        addFruit(bubble);
        relate(person, bubble);
        Fruit bubble1 = new Fruit(fruit5, baseFont, 250, 350);
        addFruit(bubble1);
        relate(bubble, bubble1);

        this.setFont(baseFont);
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                for (int i = 0; i < fruits.size(); i++) {
                    Paintable p = fruits.get(i);
                    if (p.contains(e.getPoint())) {
                        // select
                        selectedShape = p;
                        offset = new Point2D.Double(e.getX() - p.getBounds().getX(), e.getY() - p.getBounds().getY());
                        fruits.get(i).setFource(true);
                    } else {
                        fruits.get(i).setFource(false);
                    }
                }

                for (int i = 0; i < persons.size(); i++) {
                    Paintable p = persons.get(i);
                    if (p.contains(e.getPoint())) {
                        // select
                        selectedShape = p;
                        offset = new Point2D.Double(e.getX() - p.getBounds().getX(), e.getY() - p.getBounds().getY());
                        persons.get(i).setFource(true);
                    } else {
                        persons.get(i).setFource(false);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                selectedShape = null;
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedShape != null) {
                    Point2D d = new Point2D.Double(e.getX() - offset.getY(), e.getY() - offset.getY());
                    selectedShape.moveTo(d);
                }
                repaint();
            }
        });


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        for (Relationship relationship : relationships) {

            Point2D p1 = new Point2D.Double(relationship.getParent().getBounds().getCenterX(), relationship.getParent().getBounds().getCenterY());
            Point2D p2 = new Point2D.Double(relationship.getChild().getBounds().getX(), relationship.getChild().getBounds().getY());

            g2.draw(new Line2D.Double(p1, p2));
            Ellipse2D.Double hole = new Ellipse2D.Double();
            hole.width = 5;
            hole.height = 5;
            hole.x = p2.getX();
            hole.y = p2.getY();
            g2.draw(hole);
        }

        for (Person p : persons) {
            p.paint(this, g2);
        }
        for (Fruit f : fruits) {
            f.paint(this, g2);
        }
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame f = new JFrame();
//
//                f.add(new Main.Main());
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.pack();
//                f.setLocationRelativeTo(null);
//                f.setVisible(true);
//
//            }
//        });
//    }

    protected void relate(Person person, Fruit bubble) {
        relationships.add(new Relationship(person, bubble));
    }

    protected void relate(Fruit person, Fruit bubble) {
        relationships.add(new Relationship(person, bubble));
    }

    protected void addFruit(Fruit fruit) {
        fruits.add(fruit);
        repaint();
    }

    protected void addPerson(Person person) {
        persons.add(person);
        repaint();
    }

    protected List<Paintable> getShapes() {
        ArrayList<Paintable> shapes = new ArrayList<>(fruits);
        shapes.addAll(persons);
        return shapes;
    }
}
