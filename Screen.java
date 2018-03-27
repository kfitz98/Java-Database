package assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener{
	
	JTextArea area;
	
	Screen(String title){
		area = new JTextArea("NCT Statistics 2016");
		
		area.setBounds(20,75,250,200);
		
		add(area);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
