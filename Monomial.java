package monomial;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import drawing_functions_main.Main;

public class Monomial {
    
	JLabel labelplus,lblx;
	 private JTextField txtkoef,textdegree;
	
	public Monomial(int x) {

		labelplus = new JLabel("+");
		labelplus.setHorizontalAlignment(SwingConstants.CENTER);
		labelplus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelplus.setBounds(x, 650, 40, 25);
		Main.Drawing_Function.add(labelplus);
		
		txtkoef = new JTextField();
		txtkoef.setBounds(x+40, 650, 40, 20);
		Main.Drawing_Function.add(txtkoef);
		txtkoef.setColumns(10);
		
		lblx = new JLabel("*x^");
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblx.setBounds(x+80, 650, 50, 25);
		Main.Drawing_Function.add(lblx);
		
		textdegree = new JTextField();
		textdegree.setColumns(10);
		textdegree.setBounds(x+130, 650, 40, 20);
		Main.Drawing_Function.add(textdegree);
	}
	
	public String Get_txtkoef() {
	return txtkoef.getText();	
	}
	
	public String Get_txtdegree() {
	return textdegree.getText();	
	}	
	

}
