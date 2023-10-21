import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class Menu implements ActionListener {
    // private static final String LIST_ALL_CAR_SLOT_LABEL = "List All Car Slot";
    // private static final String PARK_CAR_LABEL = "Park Car";
    // private static final String FIND_CAR_LABEL = "Find Car";
    // private static final String ADD_CAR_LABEL = "Add Car";
    // private static final String REMOVE_CAR_LABEL = "Remove Car";
    // private static final String ADD_CAR_SLOT_LABEL = "Add Car Slot";
    // private static final String REMOVE_CAR_SLOT_LABEL = "Remove Car Slot";

    private JButton addCarBtn = new JButton("Add Car");
    private JButton addCarSlotBtn = new JButton("Add Car Slot");
    private JButton generateCarsBtn = new JButton("Generate Cars");
    private JButton generateCarSlotsBtn = new JButton("Generate Car Slots");

    private JPanel panel;
    private JFrame popup;
    private int PADDING = 10;
    private CarPark carPark;
    private Display displayPanel;
    private ArrayList<Car> cars;
    public Menu(CarPark carPark, Display displayPanel, ArrayList<Car> cars) {
        this.carPark = carPark;
        this.displayPanel = displayPanel;
        this.cars = cars;
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, PADDING, PADDING));
        panel.setBackground(Constants.primaryColor);
        panel.add(addCarBtn);
        panel.add(addCarSlotBtn);
        panel.add(generateCarsBtn);
        panel.add(generateCarSlotsBtn);
        addCarBtn.addActionListener(this);
        addCarSlotBtn.addActionListener(this);
        generateCarsBtn.addActionListener(this);
        generateCarSlotsBtn.addActionListener(this);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        Component source = (Component) e.getSource();

       if(source == addCarBtn){
            System.out.println("addCarBtn");
            showAddCarPopup();
        }else if(source == addCarSlotBtn){
            System.out.println("addCarSlotBtn");
            showAddCarSlotPopup();
        }else if(source == generateCarsBtn){
            System.out.println("generateCarsBtn");
            cars.addAll(Car.generateCar(3));
            displayPanel.refresh();
        }else if(source == generateCarSlotsBtn){
            System.out.println("generateCarSlotsBtn");
            carPark.getSlots().addAll(ParkingSlot.generateParkingSlot(3));
            displayPanel.refresh();
        }

        
    }
private void showAddCarPopup() {
    popup = new JFrame("Add Car");
    JPanel contentPane = new JPanel(new FlowLayout());
    contentPane.setBackground(Constants.primaryColor);
    popup.add(contentPane);

    JTextField idTextField = new JTextField();
    JTextField makeTextField = new JTextField();
    JTextField modelTextField = new JTextField();
    JTextField yearTextField = new JTextField();


    JButton addBtn = new JButton("Add");
    JButton cancelBtn = new JButton("Cancel");
    idTextField.setPreferredSize(new Dimension(200, 24));
    makeTextField.setPreferredSize(new Dimension(200, 24));
    modelTextField.setPreferredSize(new Dimension(200, 24));
    yearTextField.setPreferredSize(new Dimension(200, 24));

    contentPane.add(new JLabel("Registration Number:"));
    contentPane.add(idTextField);
    contentPane.add(new JLabel("Make:"));
    contentPane.add(makeTextField);
    contentPane.add(new JLabel("Model:"));
    contentPane.add(modelTextField);
    contentPane.add(new JLabel("Year:"));
    contentPane.add(yearTextField);

    contentPane.add(addBtn);
    contentPane.add(cancelBtn);
    popup.pack();
    popup.setVisible(true);

    addBtn.addActionListener(e -> {
        System.out.println("addBtn");

        String id = idTextField.getText();
        String make = makeTextField.getText();
        String model = modelTextField.getText();
        String year = yearTextField.getText();

        // Check if car ID already exists
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                System.out.println("Car with ID " + id + " already exists");
                return;
            }
        }

        // Add new car to ArrayList
        cars.add(new Car(id, make, model, year));
        System.out.println("Car added successfully");
        popup.setVisible(false);
        popup.dispose();
        displayPanel.refresh();
    });

    cancelBtn.addActionListener(e -> {
        System.out.println("cancelBtn");
        popup.setVisible(false);
        popup.dispose();
    });
}
    private void showAddCarSlotPopup() {
        popup = new JFrame("Add Car Slot");
        JPanel contentPane = new JPanel(new FlowLayout());
        contentPane.setBackground(Constants.primaryColor);
        popup.add(contentPane);

        JTextField textField = new JTextField();
        JButton addBtn = new JButton("Add");
        JButton cancelBtn = new JButton("Cancel");
        textField.setPreferredSize(new Dimension(200, 24));
        textField.setText("A001");
        contentPane.add(new JLabel("Car Slot ID ([A-Z]{1}[\\d]{3}):"));
        contentPane.add(textField);
        contentPane.add(addBtn);
        contentPane.add(cancelBtn);
        popup.pack();
        popup.setVisible(true);

        addBtn.addActionListener(e -> {
            System.out.println("addBtn");
            String carSlotId = textField.getText();
            if (carPark.addParkingSlot(new ParkingSlot(carSlotId))) {
                System.out.println("Parking slot added successfully");
                popup.setVisible(false);
                popup.dispose();
                displayPanel.refresh();
            } else {
                System.out.println("Failed to add parking slot");
            }
        });

        cancelBtn.addActionListener(e -> {
            System.out.println("cancelBtn");
            popup.setVisible(false);
            popup.dispose();
        });
    }
}