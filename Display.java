/**
 * The Display class represents the graphical user interface of the Car Park system.
 * It displays the parking slots and the list of cars in the car park.
 * It also provides buttons to park and remove cars from the parking slots.
 * The class uses Swing components to create the user interface.
 *
 * @author Suchat Tangjarukij
 * @version 1.0.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private ParkingSlotFilter parkingSlotFilterStruct;
    /**
    * @param carPark The CarPark object that represents the car park.
    * @param cars The ArrayList of Car objects that represents the cars in the car park.
    * @param carFilterStruct The CarFilter object that represents the filter for the list of cars.
    * 
    * @return A JPanel object that represents the graphical user interface of the Car Park system.
    */
    public Display(CarPark carPark,ArrayList<Car> cars,CarFilter carFilterStruct,ParkingSlotFilter parkingSlotFilterStruct)
    {
        this.carFilterStruct = carFilterStruct;
        this.parkingSlotFilterStruct = parkingSlotFilterStruct;
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
            ParkingSlot slot = carPark.getSlot(i);
            String slotId = slot.getId();
            Car parkedCar = slot.getCar();
            if(parkingSlotFilterStruct.isFiltering()){
                if(parkingSlotFilterStruct.getId() != null && !parkingSlotFilterStruct.getId().equals(slotId)){
                    continue;
                }
            }

            JPanel slotPanel = new JPanel();
            slotPanel.setLayout(new FlowLayout());
            JLabel slotLabel = new JLabel(slotId);
            JLabel slotCarLabel = new JLabel("None");
            JButton slotButton = new JButton("Park Car");
            JButton slotRemoveButton = new JButton("Remove Car");
            
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
        carParkingSlotsPane.setBorder(BorderFactory.createTitledBorder("Car Parking Slots (supports sideways parking)"));
        carParkingSlotsPane.setLayout(new ScrollPaneLayout());
        carParkingSlotsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        carsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        carsPane.setBorder(BorderFactory.createTitledBorder("Existing Cars in the system"));

        
        
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
