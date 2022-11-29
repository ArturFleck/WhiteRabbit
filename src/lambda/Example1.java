package lambda;

import javax.swing.*;
import java.awt.*;

public class Example1 {
    public static void main(String[] args) {
        final int screenWidth = 1200;
        final int screenHeight = 800;

        JFrame frame = new JFrame();
        frame.setSize(screenWidth,screenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Button button = new Button("Press me!");
        button.addActionListener(e -> JOptionPane.showMessageDialog(null, "Pressed!!!"));

        BorderLayout borderLayout = new BorderLayout();
        frame.getContentPane().setLayout(borderLayout);
        frame.getContentPane().add(button,BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
