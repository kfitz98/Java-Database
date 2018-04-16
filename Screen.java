package assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Screen extends Database implements ActionListener{
	
	JFrame f;
	JTextArea area;
	JButton searchBtn, hBtn,fBtn,showBtn,exitBtn;
	ArrayList<String> array = new ArrayList<String>();
	ArrayList<String> array2 = new ArrayList<String>();
	ArrayList<String> array3 = new ArrayList<String>();
	
	String input;
	private String testc;
	
	private JTable table;
	
	public Screen(){
		
		gui();
		nctList();
		Table();
		
	}
	
	public void gui() {
		
		f = new JFrame();
		f.setSize(800,600);
		f.setLayout(null);
		f.setTitle("2016 NCT Pass/Fail Rates by Test Centre");
		DefaultTableModel model = new DefaultTableModel();
		
		searchBtn = new JButton("Search Test Centres");
		hBtn = new JButton("Highest Pass Rate");
		fBtn = new JButton("Highest Fail Rate");
		showBtn = new JButton("Show All");
		exitBtn = new JButton("Exit");
		JScrollPane sp = new JScrollPane();
        table = new JTable(model);
        sp.setViewportView(table);
		
		searchBtn.setBounds(10, 0, 127, 38);
		hBtn.setBounds(147, 0, 127, 38);
		fBtn.setBounds(510, 0, 127, 38);
		showBtn.setBounds(328, 0, 127, 38);
		exitBtn.setBounds(647, 0, 127, 38);
		
		sp.setBounds(10, 49, 764, 502);
		f.add(sp);
		f.add(searchBtn);
		f.add(hBtn);
		f.add(fBtn);
		f.add(showBtn);
		f.add(exitBtn);
		f.setVisible(true);
		f.setLayout(null);
		table.setAutoCreateRowSorter(true);	
		
		searchBtn.addActionListener(this);
		hBtn.addActionListener(this);
		fBtn.addActionListener(this);
		showBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public  ArrayList<NCT> nctList()
	{
		ArrayList<NCT> nctList = new ArrayList<>();
		
		try {
			NCT nct;
			String SQL = "SELECT * FROM nct";
			
			result = st.executeQuery(SQL);
			
			while(result.next())
			{
				nct = new NCT(result.getString("Test_Centre"),result.getInt("Passed"),result.getDouble("Passed_Percent"),result.getInt("Failed"),result.getDouble("Failed_Percent"),result.getInt("Failed_Dangerous"),result.getDouble("Failed_Dangerous_Percent"),result.getInt("Total"));
				nctList.add(nct);
			}
			
		}catch(Exception e) {}
		return nctList;
		
	}
	
	//Insert data into JTable
	
	public void Table()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] {"Test Centre","Passed","%","Failed","%","Failed Dangerous","%","Total"});
		ArrayList<NCT> nct = nctList();
		Object[] row = new Object[8];
		
		for(int i= 0; i<nct.size();i++)
		{
			row[0] = nct.get(i).getC();
			row[1] = nct.get(i).getP();
			row[2] = nct.get(i).getPp();
			row[3] = nct.get(i).getF();
			row[4] = nct.get(i).getFp();
			row[5] = nct.get(i).getFd();
			row[6] = nct.get(i).getFdp();
			row[7] = nct.get(i).getTotal();
			
			model.addRow(row);
		}
		table.setModel(model);
	}
	



	
	public void actionPerformed(ActionEvent e)
	{
		//Display highest pass rate
		
		if(e.getSource() == hBtn)
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
		
		if(e.getSource() == fBtn)
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
		
		if(e.getSource() == searchBtn)
		{
			testc = JOptionPane.showInputDialog(null,"Search Test Centre");
			
			
			try {
				String SQL = "SELECT * FROM nct WHERE Test_Centre ='"+testc+"'";
				
				result = st.executeQuery(SQL);
				
				while(result.next()) {
		
					String a1 = result.getString("Test_Centre");
					int a2 = result.getInt("Passed");
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
		
		if(e.getSource() == exitBtn)
		{
			
		}
		
	}

}
