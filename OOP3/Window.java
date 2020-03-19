package OOP3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;

import javax.swing.*;

public class Window extends JFrame implements WindowListener, ActionListener {

    private JLabel m_Image;
    private JButton m_Button_Bird, m_Button_Plane, m_Button_Man;

    public static void main(String[] args) {
        Window screen = new Window("Screen");
        screen.pack();
        screen.setVisible(true);
    }

    public Window(String title){
        super(title);
        this.setLayout(new GridBagLayout());
        this.addWindowListener(this);
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        m_Button_Bird = new JButton("It's a Bird!");
        buttonPanel.add(m_Button_Bird);

        m_Button_Plane = new JButton("No a plane!");
        buttonPanel.add(m_Button_Plane);

        m_Button_Man = new JButton("It's a man...");
        buttonPanel.add(m_Button_Man);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = .2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(buttonPanel, gbc);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("Images/Bird.png"));
        m_Image = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = .8;
        
        this.add(m_Image, gbc);

        //Tilføjer click listener på knapperne
        m_Button_Bird.addActionListener(this);
        m_Button_Plane.addActionListener(this);
        m_Button_Man.addActionListener(this);
    }

    private ImageIcon displayIcon(String imagePath){
        // Finder billedet i resourcer
        ImageIcon image = new ImageIcon(this.getClass().getResource(imagePath));
        // Resizer billedet
        ImageIcon resizedImage = new ImageIcon(image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        return resizedImage;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // Henter objectet
        Object actioObject = e.getSource();
        // Returnere sandt hvis "bird" knappen trykkes
        if(actioObject.equals(m_Button_Bird)){
            m_Image.setIcon(displayIcon("Images/Bird.png"));
        }
        // Returnere sandt hvis "plane" knappen trykkes
        else if(actioObject.equals(m_Button_Plane)){
            m_Image.setIcon(displayIcon("Images/Plane.png"));
        }
        // Returnere sandt hvis "man" knappen trykkes
        else if(actioObject.equals(m_Button_Man)){
            m_Image.setIcon(displayIcon("Images/Man.png"));
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }


}