package View;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
@SuppressWarnings("serial")
public class JScrollPane extends  javax.swing.JScrollPane {
    public JScrollPane(JComponent component){
        super(component);
        setBackground(null);
        getViewport().setBackground(null);
        setBorder(null);

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(null);
        scrollBar.setBorder(null);
        scrollBar.setUI(new BasicScrollBarUI(){
            // to change scroll bar color
            @Override
            protected void configureScrollBarColors(){
                this.thumbColor = GUIConstants.textAreaHint;
            }
            // to hide the arrows of scroll bar
            @Override
            protected javax.swing.JButton createDecreaseButton(int orientation){
                return createZeroButton();
            }
            @Override
            protected javax.swing.JButton createIncreaseButton(int orientation){
                return createZeroButton();
            }
            private javax.swing.JButton createZeroButton() {
                javax.swing.JButton btn = new javax.swing.JButton();
                btn.setPreferredSize(new Dimension(0,0));
                btn.setMaximumSize(new Dimension(0,0));
                btn.setMinimumSize(new Dimension(0,0));
                return btn;
            }
        });
        setVerticalScrollBar(scrollBar);
        //to hide horizontal scroll bar
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        getVerticalScrollBar().setPreferredSize(new Dimension(5,0));
        getHorizontalScrollBar().setPreferredSize(new Dimension(0,5));
    }
}
