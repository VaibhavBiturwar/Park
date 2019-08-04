
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class ExitGate extends JFrame {

	private JPanel contentPane;
	private JTextField licencetext;
	private JTextField textFieldIn;


	public ExitGate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton showB = new JButton("show");
		showB.setBackground(new Color(204, 255, 255));
		showB.setBounds(376, 87, 97, 25);
		showB.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(showB);
		
		JButton exitB = new JButton("Exit");
		exitB.setBackground(new Color(204, 255, 255));
		exitB.setBounds(289, 388, 97, 25);
		exitB.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		contentPane.add(exitB);
		
		
		
		JLabel LicenceNolb = new JLabel("Licence Number");
		LicenceNolb.setForeground(new Color(255, 255, 255));
		LicenceNolb.setFont(new Font("Stencil", Font.PLAIN, 15));
		LicenceNolb.setBounds(53, 84, 148, 35);
		contentPane.add(LicenceNolb);
		
		licencetext= new JTextField("Enter here");
		licencetext.setBounds(213, 88, 116, 22);
		contentPane.add(licencetext);
		licencetext.setColumns(10);
		
		JLabel LabelIn = new JLabel("In-Time");
		LabelIn.setForeground(new Color(255, 255, 255));
		 LabelIn.setFont(new Font("Stencil", Font.PLAIN, 15));
		 LabelIn.setBounds(53, 226, 85, 16);
		contentPane.add( LabelIn);
		
		textFieldIn = new JTextField();
		textFieldIn.setBounds(186, 221, 116, 22);
		contentPane.add(textFieldIn);
		textFieldIn.setColumns(10);
		
		JLabel outlbl = new JLabel("Out-Time");
		outlbl.setForeground(new Color(255, 255, 255));
		outlbl.setFont(new Font("Stencil", Font.PLAIN, 15));
		outlbl.setBounds(417, 226, 85, 16);
		contentPane.add(outlbl);
		
		JTextField outtime= new JTextField();
		outtime.setBounds(539, 221, 116, 22);
		contentPane.add(outtime);
		outtime.setColumns(10);
		
		JLabel dur= new JLabel("Duration");
		dur.setForeground(new Color(255, 255, 255));
		dur.setFont(new Font("Stencil", Font.PLAIN, 15));
		dur.setBounds(53, 319, 85, 16);
		contentPane.add(dur);
		
		JTextField txtdur= new JTextField();
		txtdur.setBounds(186, 314, 116, 22);
		contentPane.add(txtdur);
		txtdur.setColumns(10);
		
		JLabel feeLb= new JLabel("Fee");
		feeLb.setForeground(new Color(255, 255, 255));
		feeLb.setFont(new Font("Stencil", Font.PLAIN, 15));
		feeLb.setBounds(417, 319, 56, 16);
		contentPane.add(feeLb);
		
		JTextField txtfee= new JTextField();
		txtfee.setBounds(539, 316, 116, 22);
		contentPane.add(txtfee);
		txtfee.setColumns(10);
		
		showB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		        String licence=licencetext.getText();
		        DBSend db=new DBSend();
		        String[] res=db.exit(licence);
		        if(res != null) {
		        	textFieldIn.setText(res[1]);
		        	outtime.setText(res[2]);
		        	txtdur.setText(res[3]);
		        	txtfee.setText(Integer.toString(Integer.parseInt(res[3])*3) + "Rs");
		        } else {
		        	JOptionPane.showMessageDialog(null, "Car Not Found! Please Check the entered number");
	        	}
		        	
            }
            	
        });
		exitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            	dispose();	
            }
            	
        });   
		
	}
}

