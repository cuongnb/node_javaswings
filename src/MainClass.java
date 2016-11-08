import ObjetDraw.Blabla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by cuongnb on 11/8/16.
 */
public class MainClass extends JFrame implements ActionListener {
    private List<Person> persons = new ArrayList<>();
    private List<Fruit> fruits = new ArrayList<>();

    JFrame f = new JFrame();

    JLabel nameNode = new JLabel("Name: ");
    JLabel numberParent = new JLabel("Number Parent: ");
    JLabel numberOutcome = new JLabel("Number outcome: ");

    JTextField tfName = new JTextField(7);
    JTextField tfNumberParent = new JTextField(4);
    JTextField tfNumberOutcome = new JTextField(4);

    JButton doit = new JButton("Do It!");
    JCheckBox check = new JCheckBox("Leave");

    JPanel namePanel = new JPanel();
    JPanel numberNameParentPanel = new JPanel();
    JPanel numberOutcomePanel = new JPanel();

    ArrayList<Blabla> parent = new ArrayList<>();
    ArrayList<Blabla> outcome = new ArrayList<>();

    public MainClass() {
        setTitle("Calories from Fat");
        setLayout(new FlowLayout());

        // Add components to Panels
        namePanel.add(nameNode);
        namePanel.add(tfName);

        numberNameParentPanel.add(numberParent);
        numberNameParentPanel.add(tfNumberParent);

        numberOutcomePanel.add(numberOutcome);
        numberOutcomePanel.add(tfNumberOutcome);

        add(namePanel);
        add(numberNameParentPanel);
        add(numberOutcomePanel);
        add(check);
        add(doit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doit.addActionListener(this);


        f.add(new Main(persons, fruits));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    // The application
    public void calcPercent() {
//        percent = ((fatGrams * 9.0) / calories) * 100.0;
        f.repaint();
    }

    public void actionPerformed(ActionEvent evt) {
//        String userIn;
//        userIn = tfName.getText();
//        fatGrams = Integer.parseInt(userIn);
//
//        userIn = tfNameParent.getText();
//        calories = Integer.parseInt(userIn);
//        calcPercent();
//        JButton o = (JButton) evt.getSource();
//        String name = o.getName();
        if (evt.getActionCommand() == "Ok") {
            int numberParent = Integer.parseInt(tfNumberParent.getText());
//            tfNameChild.setText(numberParent + "balaba");
//            for (int i = 0; i < numberParent; i++) {
//                JPanel jPanel = new JPanel();
//                jPanel.add(nameParent);
//                jPanel.add(tfNameParent);
//                jPanels.add(jPanel);
//            }
            repaint();

        } else if (evt.getActionCommand() == "Do It!") {

//            tfNameChild.setText(" adafdaf");
            persons.add(new Person("cuongnb", 60, 100));
            repaint();
        }


    }

    public static void main(String[] args) {
        MainClass fatApp = new MainClass();
        fatApp.setSize(300, 225);
        fatApp.setResizable(true);

    }
}