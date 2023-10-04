
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display
{
    // instance variables - replace the example below with your own
    private JButton addCar;
    private JButton removeCar;
    private JPanel panel = new JPanel();
    private int PADDING = 20;
    private CarPark carPark;
    public Display(CarPark carPark)
    {
        // initialise instance variables
        // verticalLayout 
        this.carPark = carPark;
        this.refresh();
    } 

    public JPanel getPanel()
    {
        return panel;
    }
    public void refresh() {
        panel.removeAll();
        panel.revalidate();
        panel.setLayout(new GridLayout(0, 2, PADDING, PADDING));

        JPanel visitorPanel = new JPanel();
        visitorPanel.setLayout(new BoxLayout(visitorPanel, BoxLayout.Y_AXIS));

        JPanel staffPanel = new JPanel();
        staffPanel.setLayout(new BoxLayout(staffPanel, BoxLayout.Y_AXIS));

        // displays all the slots in visitor panel with button
        for (int i = 0; i < carPark.getCapacity(); i++) {
            JPanel slotPanel = new JPanel();

            slotPanel.setLayout(new FlowLayout());

            JLabel slotLabel = new JLabel(carPark.getSlot(i).getId());
            JButton slotButton = new JButton("Add Car");
            slotPanel.add(slotLabel);
            slotPanel.add(slotButton);
            visitorPanel.add(slotPanel);
            
        }

        JScrollPane visitorScrollPane = new JScrollPane(visitorPanel);
        JScrollPane staffScrollPane = new JScrollPane(staffPanel);
        visitorScrollPane.setBorder(BorderFactory.createTitledBorder("Visitor"));
        visitorScrollPane.setLayout(new ScrollPaneLayout());
        visitorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        staffScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(visitorScrollPane);
        panel.add(staffScrollPane);
    }
}
