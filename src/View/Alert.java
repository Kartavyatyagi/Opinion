package View;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class Alert {
    public Alert(String content, JFrame parent){
        JFrame frame = new View.JFrame();
        frame.setSize(430,170);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panel.setBackground(GUIConstants.white);

        JLabel title = new JLabel("Alert", 24, GUIConstants.blue ,Font.BOLD);
        title.setHorizontalAlignment(JLabel.CENTER);
        panel.add(title, BorderLayout.NORTH);

        JLabel msg = new JLabel(content, 18, GUIConstants.black ,Font.BOLD);
        msg.setHorizontalAlignment(JLabel.CENTER);
        panel.add(msg, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(parent);
        frame.setVisible(true);
    }
}
