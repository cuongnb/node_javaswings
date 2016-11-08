package ObjetDraw;

import javax.swing.*;

/**
 * Created by cuongnb on 11/8/16.
 */
public class Blabla extends JFrame {
    String name;
    public JPanel jPanel;
    public JLabel jLabel;
    public JTextField jTextField;

    public Blabla(String name) {
        jLabel = new JLabel(name);
        jTextField = new JTextField(7);
        jPanel.add(jLabel);
        jPanel.add(jTextField);
    }

    public Blabla(String name, boolean isLeave) {
        jLabel = new JLabel(name);
        jTextField = new JTextField(7);
        jPanel.add(jLabel);
        if (isLeave) {
            jPanel.add(jTextField);
        }
    }
}
