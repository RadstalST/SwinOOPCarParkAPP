
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class Input
{
    // instance variables - replace the example below with your own
    private Display displayPanel;
    JPanel panel = new JPanel();
    JPanel carFilterPanel = new JPanel();
    JPanel parkingFilterPanel = new JPanel();
    CarFilter carFilterStruct;
    ParkingSlotFilter parkingSlotFilterStruct;

    private int PADDING = 20;
    public Input(Display displayPanel,ArrayList<Car> cars,CarFilter carFilterStruct,ParkingSlotFilter parkingSlotFilterStruct)
    {
        // initialise instance variables
        // verticalLayout 
        this.displayPanel = displayPanel;
        this.carFilterStruct = carFilterStruct;
        this.parkingSlotFilterStruct = parkingSlotFilterStruct;
        panel.setLayout(new GridLayout(0, 2, PADDING, PADDING));
        panel.setBackground(Constants.primaryColor);
        createCarsFilterPane();
        createParkingFilterPane();
        panel.add(parkingFilterPanel);
        panel.add(carFilterPanel);

        
        

    } 

    public JPanel getPanel()
    {
        return panel;
    }
    public JPanel createParkingFilterPane(){
        parkingFilterPanel.setLayout(new GridLayout(0, 2, PADDING, PADDING));
        parkingFilterPanel.setBackground(Constants.primaryColor);
        parkingFilterPanel.setBorder(BorderFactory.createTitledBorder("Parking Filter"));

        // parking filter fields with id, make, model, year
        JLabel idLabel = new JLabel("ID");
        JTextField idTextField = new JTextField();

        // id filter with dropdown of all the ids
        JList idList = new JList();
        idList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        idList.setLayoutOrientation(JList.VERTICAL);
        idList.setVisibleRowCount(-1);
        // JScrollPane idListScroller = new JScrollPane(idList);
        // idListScroller.setPreferredSize(new Dimension(250, 80));
        // parkingFilterPanel.add(idLabel);
        // parkingFilterPanel.add(idListScroller);
        JLabel slotLabel = new JLabel("SlotID");
        JTextField slotTextField = new JTextField();
        parkingFilterPanel.add(idLabel);
        parkingFilterPanel.add(slotTextField);

        JButton filterBtn = new JButton("Filter");
        JButton slotResetBtn = new JButton("Reset");

        parkingFilterPanel.add(filterBtn);
        parkingFilterPanel.add(slotResetBtn);

        slotResetBtn.addActionListener(e -> {
                System.out.println("resetBtn");
                slotTextField.setText("");
                parkingSlotFilterStruct.clear();
                displayPanel.refresh();

            });
        filterBtn.addActionListener(e -> {
                System.out.println("filterBtn");
                parkingSlotFilterStruct.clear(); // clear the filter
                parkingSlotFilterStruct.setId(slotTextField.getText());
                displayPanel.refresh();
            });
        
        return parkingFilterPanel;

        

    }
    public JPanel createCarsFilterPane(){
        carFilterPanel.setLayout(new GridLayout(0, 2, PADDING, PADDING));
        carFilterPanel.setBackground(Constants.primaryColor);
        carFilterPanel.setBorder(BorderFactory.createTitledBorder("Cars Filter"));

        // car filter fields with id, make, model, year
        JLabel idLabel = new JLabel("ID");
        JTextField idTextField = new JTextField();

        // id filter with dropdown of all the ids
        JList idList = new JList();
        idList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        idList.setLayoutOrientation(JList.VERTICAL);
        idList.setVisibleRowCount(-1);

        JLabel makeLabel = new JLabel("Make");
        JTextField makeTextField = new JTextField();
        JLabel modelLabel = new JLabel("Model");
        JTextField modelTextField = new JTextField();
        JLabel yearLabel = new JLabel("Year");
        JTextField yearTextField = new JTextField();
        carFilterPanel.add(idLabel);
        carFilterPanel.add(idTextField);
        carFilterPanel.add(makeLabel);
        carFilterPanel.add(makeTextField);
        carFilterPanel.add(modelLabel);
        carFilterPanel.add(modelTextField);
        carFilterPanel.add(yearLabel);
        carFilterPanel.add(yearTextField);
        // buttons
        JButton filterBtn = new JButton("Filter");
        JButton resetBtn = new JButton("Reset");

        carFilterPanel.add(filterBtn);
        carFilterPanel.add(resetBtn);

        resetBtn.addActionListener(e -> {
                System.out.println("resetBtn");
                idTextField.setText("");
                makeTextField.setText("");
                modelTextField.setText("");
                yearTextField.setText("");
                carFilterStruct.clear(); // clear the filter
                displayPanel.refresh();
            });



        filterBtn.addActionListener(e -> {
                System.out.println("filterBtn");
                carFilterStruct.clear(); // clear the filter
                carFilterStruct.setId(idTextField.getText());
                carFilterStruct.setMake(makeTextField.getText());
                carFilterStruct.setModel(modelTextField.getText());
                carFilterStruct.setYear(yearTextField.getText());
                
                
                displayPanel.refresh();
               
            });
        return carFilterPanel;

    }
}
