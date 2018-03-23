/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrsun;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import NuralPKG.BeanClass;

/**
 *
 * @author Toshiba pc
 */
class retrieval extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l18, nural;
	JPanel p1;
	JButton btn1, btn2, btn3, btn4;
	JButton name_btn, ver_btn, os_btn, lisence_btn, home_btn;
	JTextField t1, t2, t3, t4, t5, t6;
	DefaultTableModel model;
	//model_product
	JTable tabl;//tabl_product;
	firstmain f2;
	public static int xsize, ysize;
	char s;
	// db_conn db;
	JFrame f;
	String n = null;
	String y = null;
	String c = null;
	String t = null;
	String p = null;
	String o = null;
	String src = null;
	ImageIcon ic;

	retrieval() {
		Toolkit tk = Toolkit.getDefaultToolkit();

		xsize = (int) tk.getScreenSize().getWidth();
		ysize = (int) tk.getScreenSize().getHeight();

		setLayout(null);
		setTitle("Neural Network based Search ");

		f = new JFrame("Component Retrieval");

		t1 = new JTextField("");
		t1.setBounds(820, 70, 120, 25);
		add(t1);

		btn1 = new JButton("NEURAL SEARCH");
		btn1.setBounds(770, 105, 150, 25);
		add(btn1);

		btn3 = new JButton("NEW SEARCH");
		btn3.setBounds(950, 105, 160, 25);
		add(btn3);

		l1 = new JLabel("Enter Keyword");
		l1.setBounds(700, 70, 120, 30);
		add(l1);

		p1 = new JPanel();
		p1.setBounds(10, 230, xsize-10, ysize-250);
		add(p1);

		t2 = new JTextField("");
		t2.setBounds(300, 105, 120, 25);
		add(t2);

		name_btn = new JButton("Prog lang");
		name_btn.setBounds(50, 105, 120, 25);
		add(name_btn);

		t4 = new JTextField("");
		t4.setBounds(300, 140, 120, 25);
		add(t4);

		os_btn = new JButton("Operating sys");
		os_btn.setBounds(50, 140, 120, 25);
		add(os_btn);

		home_btn = new JButton("HOME");
		home_btn.setBounds(xsize-200, 0, 150, 25);
		add(home_btn);

		t5 = new JTextField("");
		t5.setBounds(300, 175, 120, 25);
		add(t5);

		lisence_btn = new JButton("License");
		lisence_btn.setBounds(50, 175, 120, 25);
		add(lisence_btn);

		Object colname[] = { "Name", "Total version", "Latest version", "License", "Author", "Operating Sys","Source" };
		model = new DefaultTableModel(colname, 0);
		tabl = new JTable(model);
		JScrollPane sp = new JScrollPane(tabl);
		
		sp.setBounds(0, 0,xsize-10, ysize-250);
		// tabl.setPreferredSize(new Dimension(1000, 500));

		/*tabl.getColumn(colname[0]);
		tabl.getColumn(colname[1]);
		tabl.getColumn(colname[2]);
		tabl.getColumn(colname[3]);
		tabl.getColumn(colname[4]);
		tabl.getColumn(colname[5]);
		tabl.getColumn(colname[6]);
		*/

		p1.add(sp);
		p1.setLayout(null);
		nural = new JLabel("Neural Network search");
		nural.setBounds(50, 40, 200, 25);
		add(nural);

		///////////////////// table to show all products detail
		/*model_product = new DefaultTableModel(colname, 1);

		tabl_product = new JTable(model_product);*/
	//	JScrollPane sp1 = new JScrollPane(tabl_product);

	//	sp1.setBounds(1250, 100, 400, 550);
	//	l3.add(sp1);

		l18 = new JLabel();
		l18.setBounds(810, 50, 600, 140);
		add(l18);

		ic = new ImageIcon("pics/cbd2.jpg");
		l6 = new JLabel(ic);
		l6.setBounds(550, 0, 800, 800);
		add(l6);

		btn1.addActionListener(this);
		// btn2.addActionListener(this);
		btn3.addActionListener(this);
		name_btn.addActionListener(this);
		// ver_btn.addActionListener(this);
		os_btn.addActionListener(this);
		lisence_btn.addActionListener(this);
		home_btn.addActionListener(this);

		setVisible(true);
		setSize(xsize, ysize);
		
		tabl.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = tabl.rowAtPoint(evt.getPoint());
		        int col = tabl.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col == 6) {
		            System.out.println("Get Data @ row "+row);
		            System.out.println("Get Data @ col "+col);
		            String url = tabl.getValueAt(tabl.getSelectedRow(), 6).toString();
		            openWebPage(url);
		        }
		    }
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NuralPKG.FirstClass obj = null;
		try {
			obj = new NuralPKG.FirstClass();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		ArrayList<NuralPKG.BeanClass> list1 = obj.getData();

		if (e.getSource() == btn1) // TODO Auto-generated method stub
		{
			String a = t2.getText();
			String a1 = t4.getText();
			String a2 = t5.getText();
			scrsun.db_conn db = new db_conn();

			Connection c1;
			try {
				c1 = db.db_Connections1();
				java.sql.Statement stmt = c1.createStatement();
				//ResultSet rs = stmt.executeQuery(
				//		"SELECT * FROM components  WHERE Name like '%" + a + "' and 	License like  '%" + a1 + " ' and Operating_system like '%" + a2 + "' ");
				ResultSet rs = stmt.executeQuery(
						"SELECT * FROM components  WHERE Programming_language = '" + a + "' and 	License = '" + a2 + "' and Operating_system = '" + a1 + "' ");

				// System.out.print("o");
				while (rs.next()) {
					n = rs.getString("Name");
					y = rs.getString("Total_Versions");
					c = rs.getString("Latest_version");
					p = rs.getString("License");
					t = rs.getString("Author");
					o = rs.getString("Operating_system");
					src = rs.getString("Source");
					System.out.print(n);
					// stmt.executeUpdate("Insert into secondcomp
					// values('"+n+"','"+y+"','"+c+"','"+p+"','"+o+"')");

					model.addRow(new Object[] { n, y, c, p, t, o, src });
					//t1.setText(a);

					/*
					 * FileReader fr=new FileReader(t); int i;
					 * while((i=fr.read())!=-1) s = (char)i; l18.setText(""+s);
					 * 
					 * fr.close();
					 */

				}

				/*
				 * else { JOptionPane.showMessageDialog(null,
				 * "No related component "); }
				 */

			}

			catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		// String

		/*
		 * int rowCount; rowCount = tabl.getRowCount();
		 * System.err.println(rowCount); if (e.getSource() == btn1 && rowCount
		 * == 1) { JOptionPane.showMessageDialog(null, "No related component ");
		 * t1.setText("");
		 * 
		 * System.err.println("hello");
		 * 
		 * 
		 * }
		 */

		else if (e.getSource() == btn3) {

			new retrieval();
			setVisible(false);
		} else if (e.getSource() == name_btn) {

			String name = t2.getText();
			HashSet<BeanClass> set = obj.showName(list1, name);

			for (BeanClass s : set) {
				model.addRow(new Object[] { s.getName(), s.getTotal_Versions(), s.getLatest_version(), s.getLicense(),
						s.getAuthor(), s.getOperating_system(), s.getSource()});

			}
			t2.setText(" ");
		}

		else if (e.getSource() == lisence_btn) {

			String name = t4.getText();
			HashSet<BeanClass> set = obj.showlisence(list1, name);

			for (BeanClass s : set) {
				model.addRow(new Object[] { s.getName(), s.getTotal_Versions(), s.getLatest_version(), s.getLicense(),
						s.getAuthor(), s.getOperating_system(), s.getSource() });

			}
			t4.setText(" ");
		}

		else if (e.getSource() == os_btn) {

			String name = t5.getText();
			HashSet<BeanClass> set = obj.showOS(list1, name);

			for (BeanClass s : set) {
				model.addRow(new Object[] { s.getName(), s.getTotal_Versions(), s.getLatest_version(), s.getLicense(),
						s.getAuthor(), s.getOperating_system(), s.getSource() });

			}
			t5.setText(" ");
		}

		else {

			firstmain obj1 = new firstmain();
			setVisible(false);

		}

	}
	
	public void openWebPage(String s)
	{
		//String s = "http://stackoverflow.com/questions/10601676/display-a-webpage-inside-a-swing-application";
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(s));
			} catch (Exception e) {
			
					
			}
		} else {
			System.out.println("Launch browser failed, please manually visit: " + s);
		}
	}
	
}
