
/**
 * Write a description of class Application here.
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
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
// import borderfactory
import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import java.util.ArrayList;

public class Application
{   
    static final int PADDING = 10; // padding in px
    private ArrayList<Car> cars = new ArrayList<Car>();
    private CarFilter carFilterStruct = new CarFilter(); // to pass to input panel
    private ParkingSlotFilter parkingSlotFilterStruct = new ParkingSlotFilter(); // to pass to input panel
    private CarPark carPark = new CarPark();
    private Display displayPanel = new Display(carPark,cars,carFilterStruct,parkingSlotFilterStruct);
    private Menu menuPanel = new Menu(carPark,displayPanel,cars);
    private Input inputPanel = new Input(displayPanel,cars,carFilterStruct,parkingSlotFilterStruct);

    public Application()
    {
        carFilterStruct.clear();
        parkingSlotFilterStruct.clear();
        JFrame frame = new JFrame("Red Alert!");
        JPanel contentPane = new JPanel(new GridBagLayout());
        GridBagConstraints cRight = new GridBagConstraints();
        cRight.fill = GridBagConstraints.BOTH;
        cRight.gridx = 1;
        cRight.gridy = 0;
        cRight.weightx = 2;
        cRight.weighty = 10;
        cRight.ipadx = PADDING;
        cRight.ipady = PADDING;
        GridBagConstraints cLeft = new GridBagConstraints();
        cLeft.fill = GridBagConstraints.BOTH;
        cLeft.gridx = 0;
        cLeft.gridy = 0;
        cLeft.weightx = 10;
        cLeft.weighty = 10;
        cLeft.ipadx = PADDING;
        cLeft.ipady = PADDING;

        GridBagConstraints cLower = new GridBagConstraints();
        cLower.fill = GridBagConstraints.BOTH;
        cLower.gridx = 0;
        cLower.gridy = 1;
        cLower.gridwidth = 2;
        cLower.weightx = 1;
        cLower.weighty = 2;
        cLower.ipadx = PADDING;
        cLower.ipady = PADDING;


        frame.add(contentPane);
        

        contentPane.add(displayPanel.getPanel(),cLeft);
        contentPane.add(menuPanel.getPanel(),cRight);
        contentPane.add(inputPanel.getPanel(),cLower);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);

        
    }

    public static void main(String[] args)
    {
        Application app = new Application();
    }
    
}
