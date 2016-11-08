package ObjetDraw;

import javax.swing.*;

/**
 * Created by cuongnb on 11/8/16.
 */
public class Blabla extends JPanel {
    String name;
    //    public JPanel jPanel;
    public JLabel jLabel;
    public JTextField jTextField;
    public boolean isleave = false;
    public JLabel sValue = new JLabel("Value: ");
    public JTextField jfLeave;

    public Blabla(String name) {
        this.name = name;
        jLabel = new JLabel(name + ": ");
        jTextField = new JTextField(7);
        jfLeave = new JTextField(7);
    }

    public Blabla(String name, boolean isLeave) {
        this.name = name;
        this.isleave = isLeave;
        jLabel = new JLabel(name + ": ");
        jTextField = new JTextField(7);
        jfLeave = new JTextField(7);
    }
}
