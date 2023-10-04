
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
import java.util.ArrayList;
public class Display
{
    // instance variables - replace the example below with your own
    private JButton addCar;
    private JButton removeCar;
    private JPanel panel = new JPanel();
    private int PADDING = 20;
    private ArrayList<Car> cars;
    private CarPark carPark;
    public Display(CarPark carPark,ArrayList<Car> cars)
    {
        // initialise instance variables
        // verticalLayout 
        this.cars = cars;
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

        JPanel slotsPanel = new JPanel();
        slotsPanel.setLayout(new BoxLayout(slotsPanel, BoxLayout.Y_AXIS));

        JPanel carsPanel = new JPanel();
        carsPanel.setLayout(new BoxLayout(carsPanel, BoxLayout.Y_AXIS));

        // displays all the slots in visitor panel with button
        for (int i = 0; i < carPark.getCapacity(); i++) {
            JPanel slotPanel = new JPanel();

            slotPanel.setLayout(new FlowLayout());

            JLabel slotLabel = new JLabel(carPark.getSlot(i).getId());
            JButton slotButton = new JButton("Park Car");
            slotsPanel.add(slotLabel);
            slotsPanel.add(slotButton);
            slotsPanel.add(slotPanel);
            
        }
        for(Car car : cars){
            JPanel carPanel = new JPanel();
            carPanel.setLayout(new FlowLayout());
            JTextArea carText = new JTextArea(car.toString());
            JButton carButton = new JButton("Delete Car");
            carPanel.add(carText);
            carPanel.add(carButton);
            carsPanel.add(carPanel);
        }


        JScrollPane carParkingSlotsPane = new JScrollPane(slotsPanel);
        JScrollPane carsPane = new JScrollPane(carsPanel);
        carParkingSlotsPane.setBorder(BorderFactory.createTitledBorder("Car Parking Slots"));
        carParkingSlotsPane.setLayout(new ScrollPaneLayout());
        carParkingSlotsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        carsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        panel.add(carParkingSlotsPane);
        panel.add(carsPane);
    }
}
