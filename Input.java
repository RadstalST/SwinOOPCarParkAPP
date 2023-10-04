
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class Input
{
    // instance variables - replace the example below with your own
    private JButton addCar;
    private JButton removeCar;
    private JPanel panel;
    private int PADDING = 20;
    public Input()
    {
        // initialise instance variables
        // verticalLayout 
        panel = new JPanel();
        addCar = new JButton("some btn2");
        removeCar = new JButton("some btn");
        panel.setLayout( new FlowLayout());
        panel.add(new JLabel("Input Panel"));
        panel.add(addCar);
        panel.add(removeCar);
    } 

    public JPanel getPanel()
    {
        return panel;
    }
}
