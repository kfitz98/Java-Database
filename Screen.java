package assignment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

public class Screen extends Database implements ActionListener{
	
	JFrame f;
	JTextArea area;
	JButton searchButton, showHighest,mostFailed,showAll;
	JTable table;
	ArrayList<String> array = new ArrayList<String>();
	
	String input;
	private String testc;
	
	public Screen(){
		
		gui();
		
	}
	
	public void gui() {
		
		f = new JFrame();
		f.setSize(800,600);
		f.setLayout(new FlowLayout());
		f.setTitle("2016 NCT Pass/Fail Rates by Test Centre");
		
		searchButton = new JButton("Search Test Centres");
		showHighest = new JButton("Highest Pass Rate");
		mostFailed = new JButton("Highest Fail Rate");
		showAll = new JButton("Show All");
		//area = new JTextArea("Test centres: \n");
		
		//area.setBounds(20, 75, 250, 200);
		
		f.add(searchButton);
		f.add(showHighest);
		f.add(mostFailed);
		f.add(showAll);
		f.setVisible(true);
		f.setLayout(null);
		
		searchButton.addActionListener(this);
		showHighest.addActionListener(this);
		mostFailed.addActionListener(this);
		showAll.addActionListener(this);
		
		f.
		
		try {
			
			String query = "SELECT * FROM nct";
			result = st.executeQuery(query);
			
			while(result.next()) {
				array.add(result.getString("Test_Centre"));
			}
			
			for(String a: array) {
				area.append(a + "\n");
			}
			System.out.println(array);

			
			
		}catch(Exception e) {}
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == showAll)
		{
			
		}
		
		
		if(e.getSource() == mostFailed)
		{
			try {
				String b = "SELECT MAX(Failed) FROM nct";
				result = st.executeQuery(b);
				if(result.next())
				{
					
					int failed = result.getInt(1);
					JOptionPane.showMessageDialog(null, failed);
					
				}
				
			}catch(Exception ex) {}
		}
		
		
		if(e.getSource() == showHighest)
		{
			try {
				
				String a = "SELECT Test_Centre,MAX(Passed) FROM nct";
				result = st.executeQuery(a);
				
				if(result.next())
				{
					//String testcentre = result.getString("Test_Centre");
					int x = result.getInt(1);
					JOptionPane.showMessageDialog(null,x);
				}
				
			}catch(Exception ex) {}
		}
		
		
		if(e.getSource() == searchButton)
		{
			testc = JOptionPane.showInputDialog(null,"Search Test Centre");
			
			try {
				String SQL = "SELECT * FROM nct WHERE Test_Centre ='"+testc+"'";
				
				result = st.executeQuery(SQL);
				
				while(result.next()) {
					
					JOptionPane.showMessageDialog(null, result.getString("Test_Centre"));
					
				}
			}catch(Exception ex) {}
			
		}
		
	}

}
