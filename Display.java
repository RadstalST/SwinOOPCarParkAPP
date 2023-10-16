
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
import javax.swing.border.EmptyBorder;
public class Display
{
    // instance variables - replace the example below with your own
    private JButton addCar;
    private JButton removeCar;
    private JPanel panel = new JPanel();
    private int PADDING = 20;
    private ArrayList<Car> cars;
    private CarPark carPark;
    private CarFilter carFilterStruct;


    public Display(CarPark carPark,ArrayList<Car> cars,CarFilter carFilterStruct)
    {
        this.carFilterStruct = carFilterStruct;
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

            
            JLabel slotCarLabel = new JLabel("None");
            JButton slotButton = new JButton("Park Car");
            JButton slotRemoveButton = new JButton("Remove Car");
            ParkingSlot slot = carPark.getSlot(i);
            Car parkedCar = slot.getCar();

            if (parkedCar != null) {
                slotCarLabel.setText(parkedCar.getId());
            }

            slotPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            slotPanel.add(slotLabel);
            slotPanel.add(slotCarLabel);
            slotPanel.add(slotButton);
            slotPanel.add(slotRemoveButton);
            slotsPanel.add(slotPanel);

            // attach listener to button create a new frame that list all carID and park
            // button
            
            slotButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("parkCarBtn");
                        JFrame popup = new JFrame("Park Car");
                        JPanel popupPanel = new JPanel();
                        popupPanel.setLayout(new GridLayout(0, 1, PADDING, PADDING));
                        popupPanel.setBackground(Constants.primaryColor);
                        popupPanel.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
                        popup.add(popupPanel);
                        for (Car car : cars) {
                            JButton carButton = new JButton(car.getId());
                            popupPanel.add(carButton);
                            carButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        slot.parkCar(car);
                                        refresh();
                                        popup.dispose();
                                    }
                                });
                        }
                        popup.pack();
                        popup.setVisible(true);
                    }
                });
            slotRemoveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        slot.removeCar();
                        refresh();
                    }
                });

            
        }

        ArrayList<Car> filteredCars = filterCars(carFilterStruct);
        

        for(Car car : filteredCars){
            JPanel carPanel = new JPanel();
            carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.Y_AXIS));
            carPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
            carPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JTextArea carText = new JTextArea(car.toString());
            carText.setAlignmentX(Component.CENTER_ALIGNMENT);
            carText.setEditable(false);
            carPanel.add(carText);

            JButton carButton = new JButton("Delete Car");
            carButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            carPanel.add(carButton);
            carsPanel.add(carPanel);
            // attach listener to button
            carButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cars.remove(car);
                        //remove car from slot
                        for(ParkingSlot slot : carPark.getParkingSlots()){
                            if(slot.getCar() == car){
                                slot.removeCar();
                            }
                        }
                        refresh();
                    }
                });
        }


        JScrollPane carParkingSlotsPane = new JScrollPane(slotsPanel);
        JScrollPane carsPane = new JScrollPane(carsPanel);
        carParkingSlotsPane.setBorder(BorderFactory.createTitledBorder("Car Parking Slots"));
        carParkingSlotsPane.setLayout(new ScrollPaneLayout());
        carParkingSlotsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        carsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        carsPane.setBorder(BorderFactory.createTitledBorder("Existing Cars"));

        
        
        panel.add(carParkingSlotsPane);
        panel.add(carsPane);
    }

    public ArrayList<Car> filterCars(String id, String make, String model, String year, boolean union){
        ArrayList<Car> filteredCars = new ArrayList<Car>();


        if(union){
            if(id != null){
                filteredCars.addAll(cars.stream().filter(car -> car.getId().equals(id)).toList());
            }
            if(make != null){
                filteredCars.addAll(cars.stream().filter(car -> car.getMake().equals(make)).toList());
            }
            if(model != null){
                filteredCars.addAll(cars.stream().filter(car -> car.getModel().equals(model)).toList());
            }
            if(year != null){
                filteredCars.addAll(cars.stream().filter(car -> car.getYear().equals(year)).toList());
            }
        }else{
            if(id != null){
                filteredCars.addAll(filteredCars.stream().filter(car -> car.getId().equals(id)).toList());
            }
            if(make != null){
                 filteredCars.addAll(filteredCars.stream().filter(car -> car.getMake().equals(make)).toList());
            }
            if(model != null){
                 filteredCars.addAll(filteredCars.stream().filter(car -> car.getModel().equals(model)).toList());
            }
            if(year != null){
                 filteredCars.addAll(filteredCars.stream().filter(car -> car.getYear().equals(year)).toList());
            }
            
            
        }
        return filteredCars;

    }
    public ArrayList<Car> filterCars(CarFilter carFilterStruct){
        ArrayList<Car> filteredCars = new ArrayList<Car>();
        if(carFilterStruct.isFiltering()){
            filteredCars = filterCars(
                carFilterStruct.getId(),
                carFilterStruct.getMake(),
                carFilterStruct.getModel(),
                carFilterStruct.getYear(),
                carFilterStruct.isUnion());
        }else{
            filteredCars = cars;
        }
        return filteredCars;
    }
    
}
