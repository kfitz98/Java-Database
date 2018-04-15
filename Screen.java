package assignment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class Screen extends Database implements ActionListener{
	
	JFrame f;
	JTextArea area;
	JButton searchButton, showHighest,mostFailed,showAll,exitBtn;
	ArrayList<String> array = new ArrayList<String>();
	ArrayList<String> array2 = new ArrayList<String>();
	
	String input;
	private String testc;
	
	private JTable table;
	private String[] columns = {"Test Centre","Passed","%","Failed","%","Failed Dangerous","%","Total"};
	//private String [][] data = {{}};
	
	public Screen(){
		
		gui();
		
	}
	
	public void gui() {
		
		f = new JFrame();
		f.setSize(800,600);
		f.setLayout(null);
		f.setTitle("2016 NCT Pass/Fail Rates by Test Centre");
		DefaultTableModel model = new DefaultTableModel(columns,0);
		
		searchButton = new JButton("Search Test Centres");
		showHighest = new JButton("Highest Pass Rate");
		mostFailed = new JButton("Highest Fail Rate");
		showAll = new JButton("Show All");
		exitBtn = new JButton("Exit");
		JScrollPane sp = new JScrollPane();
        model.setColumnIdentifiers(columns);
        table = new JTable(model);
        sp.setViewportView(table);
		
		searchButton.setBounds(10, 0, 127, 38);
		showHighest.setBounds(147, 0, 127, 38);
		mostFailed.setBounds(510, 0, 127, 38);
		showAll.setBounds(328, 0, 127, 38);
		exitBtn.setBounds(647, 0, 127, 38);
		
		//table.setBounds(10, 49, 764, 502);
		sp.setBounds(10, 49, 764, 502);
		f.add(sp);
		//f.add(table);
		f.add(searchButton);
		f.add(showHighest);
		f.add(mostFailed);
		f.add(showAll);
		f.add(exitBtn);
		f.setVisible(true);
		f.setLayout(null);
		
		searchButton.addActionListener(this);
		showHighest.addActionListener(this);
		mostFailed.addActionListener(this);
		showAll.addActionListener(this);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
		
		//Insert data into JTable
		
		for(int i = 0;i<array.size();i++)
		{
			String centre = array.get(i);
			
			Object[] data = {centre};
			
			model.addRow(data);
		}
		
		
	}
	



	
	public void actionPerformed(ActionEvent e)
	{
		//Display highest pass rate
		
		if(e.getSource() == showHighest)
		{
			try {
				String b = "SELECT MAX(Passed) FROM nct";
				result = st.executeQuery(b);
				if(result.next())
				{
					
					int passed = result.getInt(1);
					JOptionPane.showMessageDialog(null,"NCT centre with highest pass rate:"+ passed);
					
				}
				
			}catch(Exception ex) {}
		}
		
		//Display highest fail rate
		
		if(e.getSource() == mostFailed)
		{
			try {
				//System.out.println(result.getInt(getFailed()));
				String b = "SELECT MAX(Failed) FROM nct";
				result = st.executeQuery(b);
				if(result.next())
				{
					
					int failed = result.getInt(1);
					JOptionPane.showMessageDialog(null, failed);
					
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
		
					String a1 = result.getString("Test_Centre");
					String a2 = result.getString("Passed");
					String a3 = result.getString("Passed_Percent");
					String a4 = result.getString("Failed");
					String a5 = result.getString("Failed_Percent");
					String a6 = result.getString("Failed_Dangerous");
					String a7 = result.getString("Failed_Dangerous_Percent");
					String a8 = result.getString("Total");
					
					JOptionPane.showMessageDialog(null,"Test Centre: "+a1+"\n"+"Passed: "+a2+"\n"+"Passed %: "+a3+"\n"+"Failed: "+a4+"\n"+"Failed %: "+a5+"\n"+"Failed Dangerous: "+a6+"\n"+"Failed Dangerous %: "+a7+"\n"+"Total: "+a8);

				}
			}catch(Exception ex) {}
			
		}
		
	}

}
