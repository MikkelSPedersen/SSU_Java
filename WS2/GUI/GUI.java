package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Classes.*;
import Threads.*;

public class GUI extends JFrame implements WindowListener, ActionListener{
    private static final long serialVersionUID = 1L;
    final private JButton startButton = new JButton("Start");
    final private JButton stopButton = new JButton("Stop");
    final private JButton dataButton = new JButton("Gem Data");
    DefaultListModel<String> tempdata = new DefaultListModel<String>();
    DefaultListModel<String> fugtdata = new DefaultListModel<String>();
    DefaultListModel<String> regndata = new DefaultListModel<String>();
    JList<String> templist = new JList<String>(tempdata);
    JList<String> fugtlist = new JList<String>(fugtdata);
    JList<String> regnlist = new JList<String>(regndata);
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    JScrollPane scrollPane3 = new JScrollPane();

    private JTable table;
    private DataGenerator dataGenerator;
    private DataBehandler dataBehandler;

    public GUI(String title, DataGenerator DG, DataBehandler DB){
        super(title);
        dataGenerator = DG;
        dataBehandler = DB;
        this.setLayout(new GridBagLayout());
        this.addWindowListener(this);
        this.setSize(500, 600);
        this.setResizable(false);
        this.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        String[] columnNames = {"Temperatur [°C]",
                                "Luftfugtighed [%]",
                                "Regn [mm/hr]"};
        Object[][] data = {};

        TableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        
        TableColumnModel columnModel = table.getColumnModel();
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < 3; i++){
            TableColumn column = columnModel.getColumn(i); 
            column.setCellRenderer(renderer);
        }
        

        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        c.gridwidth = 3;
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(scrollPane, c);


        c.gridwidth = 1;
        c.weighty = .1;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(20, 5, 5, 5);
        this.add(startButton, c);
        c.gridx = 1;
        this.add(stopButton, c);
        c.gridx = 2;
        this.add(dataButton, c);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        dataButton.addActionListener(this);
    }
    //metode til at få data fra opbevaringen og poste det til vinduet
    //String.valueOf tager en værdi og omskriver det til en string.
    public void AddData(DataSet data) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{String.valueOf(data.Temp.GetValue()),
                                    String.valueOf(data.Hum.GetValue()),
                                    String.valueOf(data.Regn.GetValue())});
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            //start program
            dataGenerator.StartGenerator();
            System.out.println("generator startet");
        }
        else if(e.getSource() == stopButton){
            //stop program
            dataGenerator.StopGenerator();
            System.out.println("generator stoppet");
        }
        else if(e.getSource() == dataButton){
            //gem data
            System.out.println("Dette er unødvendigt da vi er meget smartere");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        dataBehandler.closeFileWriter();
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}