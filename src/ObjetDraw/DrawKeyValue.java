package ObjetDraw;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by cuongnb on 11/8/16.
 */
public class DrawKeyValue extends JPanel {
    String name;
    //    public JPanel jPanel;
    public JLabel jLabel;
    public JTextField jTextField;
    public JLabel sValue = new JLabel("Value: ");
    public JTextField jfLeave;

    public boolean isleave = false;
    public ArrayList<String> outcome = new ArrayList<>();
    public ArrayList<Double> valueOutcome = new ArrayList<>();

    public DrawKeyValue(String name) {
        this.name = name;
        jLabel = new JLabel(name + ": ");
        jTextField = new JTextField(7);
        jfLeave = new JTextField(7);
    }

    public DrawKeyValue(String name, boolean isLeave) {
        this.name = name;
        this.isleave = isLeave;
        jLabel = new JLabel(name + ": ");
        jTextField = new JTextField(7);
        jfLeave = new JTextField(7);
    }
}
