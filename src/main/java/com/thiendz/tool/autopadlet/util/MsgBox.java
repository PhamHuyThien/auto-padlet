
package com.thiendz.tool.autopadlet.util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MsgBox {

    public static String input(Component c, String message) {
        return JOptionPane.showInputDialog(c, message, "CheckAZ Warning!", JOptionPane.WARNING_MESSAGE);
    }

    public static void alert(Component c, String message) {
        JOptionPane.showMessageDialog(c, message, "CheckAZ Warning!", JOptionPane.WARNING_MESSAGE);
    }
}
