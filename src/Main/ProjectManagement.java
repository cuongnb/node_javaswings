package Main;

import ObjetDraw.Node;
import ObjetDraw.Relationship;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnb on 11/8/16.
 */
public class ProjectManagement {
    public static List<Node> fruits = new ArrayList<>();
    public static List<Relationship> relationships = new ArrayList<>();
    public static Font baseFont = new Font("Sans Serif", Font.BOLD, 12);
    public static Node newNode = new Node("newNode", baseFont, 150, 150);
}
