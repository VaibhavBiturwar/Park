import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.border.BevelBorder;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class EntryGate extends JFrame{

	private JTable numTable;
	private JLabel vacant;
	private final Action action = new SwingAction();
	DBSend db = new DBSend();
	int count= db.instance(),vacantSpace =db.total - count;
	

//	public static void main(String[] args) {
//		
//				try {
//				EntryGate eg=new EntryGate();
//				eg.setVisible(true);
//				eg.setSize(800,500);
//				eg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
	
	public EntryGate() {
		super("Vacant");
		setType(Type.POPUP);
		setResizable(false);
		getContentPane().setLayout(null);
		

   
		 String[][] data = db.garage();
		  
		 // Column Names 
		 String[] columnNames = { "SerialNo.", "LicencePlate", "InTime"}; 
		 numTable=new JTable(data,columnNames);
		 numTable.setBounds(10,100, 448,140);
		// numTable.getPreferredSize();
////		 adding it to JScrollPane 
	   // JScrollPane sp = new JScrollPane(numTable); 
	     //add(sp); 
        vacant=new JLabel();
	     vacant.setText("Car Entry Check");
	     vacant.setFont(new Font("Serif", Font.PLAIN, 28));
	     vacant.setBounds(200, 20,  263, 40);
	     getContentPane().add(vacant);
		
		getContentPane().add(numTable);
		
		JPanel internal_panel = new JPanel();
		internal_panel.setBorder(new BevelBorder(BevelBorder.RAISED));
		internal_panel.setBounds(541, 95, 179, 127);
		getContentPane().add(internal_panel);
		internal_panel.setLayout(null);
		
		JLabel lblVacant = new JLabel("Vacant\n" + vacantSpace);
		lblVacant.setBounds(12, 2, 49, 98);
		lblVacant.setFont(new Font("Stencil", Font.PLAIN, 13));
		internal_panel.add(lblVacant);
		
		JLabel lblCount = new JLabel("Count\n" + count);
		lblCount.setBounds(125, 2, 42, 98);
		lblCount.setFont(new Font("Stencil", Font.PLAIN, 13));
		internal_panel.add(lblCount);
		
		JButton checkB = new JButton("Check");
		checkB.setBounds(2, 100, 175, 25);
		checkB.setBackground(Color.CYAN);
		internal_panel.add(checkB);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(189, 253, 97, 25);
		getContentPane().add(btnExit);
		
		
	
		
		
	    } 
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

	
	
	
	
