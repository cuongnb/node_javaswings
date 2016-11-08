package Main;

import ObjetDraw.Blabla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by cuongnb on 11/8/16.
 */
public class AddMoreImform extends JFrame implements ActionListener {

    ArrayList<Blabla> parent = new ArrayList<>();
    ArrayList<Blabla> outcome = new ArrayList<>();

    public AddMoreImform(ArrayList<Blabla> parent, ArrayList<Blabla> outcome) {
        this.parent = parent;
        this.outcome = outcome;
        setTitle("Calories from Fat");
        setLayout(new FlowLayout());

        for (Blabla blabla : parent) {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(blabla.jLabel);
            jPanel1.add(blabla.jTextField);
            add(jPanel1);
        }


        for (Blabla blabla : outcome) {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(blabla.jLabel);
            jPanel1.add(blabla.jTextField);
            if (blabla.isleave) {
                jPanel1.add(blabla.sValue);
                jPanel1.add(blabla.jfLeave);
            }
            add(jPanel1);
        }
    }

    public static void main(String[] args) {
        int numberParent = 3;
        ArrayList<Blabla> parent = new ArrayList<>();
        ArrayList<Blabla> outcome = new ArrayList<>();
        for (int i = 0; i < numberParent; i++) {
            parent.add(new Blabla("parent " + i));
        }
        int numberOutcome = 4;
        for (int i = 0; i < numberOutcome; i++) {
            outcome.add(new Blabla("outcone " + i, false));
        }
        AddMoreImform program = new AddMoreImform(parent, outcome);
        program.setSize(300, 225);
        program.setResizable(true);
        program.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}