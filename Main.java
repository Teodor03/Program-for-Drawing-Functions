package drawing_functions_main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import monomial.Monomial;

public class Main extends JFrame{
	public Main() {
	}

	 public static JFrame Drawing_Function;
	 static int x=200;
	 static JTextField txtkoef;
	 static JTextField textdegree;
	 static JTextField textzoom;
	
	public static void main(String[] args) {
		Drawing_Function = new JFrame();
		Drawing_Function.setTitle("Drawing_Function");
		Drawing_Function.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawing_Function.setBounds(100, 100, 635, 750);
		Drawing_Function.getContentPane().setLayout(null);
		Drawing_Function.setVisible(true);
		
		ArrayList <Monomial> Monomial_Collection = new ArrayList <Monomial>(); 
		
		JPanel pnlfunction = new JPanel();
		pnlfunction.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlfunction.setBackground(Color.WHITE);
		pnlfunction.setBounds(10, 10, 601, 601);
		Drawing_Function.getContentPane().add(pnlfunction);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphics g = (Graphics2D) pnlfunction.getGraphics();
				g.clearRect(0, 0, 601, 601);
				g.setColor(Color.BLACK);
//				g.drawLine(0, 300, 600, 300);
//				g.drawLine(300, 0, 300, 600);			
//				for (int xlines = 0; xlines < 61; xlines++) {
//					g.drawLine(xlines * 10, 0, xlines * 10, 600);
//				}
//				for (int ylines = 0; ylines < 61; ylines++) {
//					g.drawLine(0, ylines * 10, 600, ylines * 10); 
//				}
				g.setColor(Color.BLUE);				
		        Float [] koef = new Float [Monomial_Collection.size()+1];
		        Float [] degree = new Float [Monomial_Collection.size()+1];
		        float zoom=Float.parseFloat(textzoom.getText());
		        koef [0]=Float.parseFloat(txtkoef.getText());
		        degree [0]=Float.parseFloat(textdegree.getText());
                for(int i=1;i<Monomial_Collection.size()+1;i++) {
                	koef [i]=Float.parseFloat(Monomial_Collection.get(i-1).Get_txtkoef());
                	degree [i]=Float.parseFloat(Monomial_Collection.get(i-1).Get_txtdegree());
                }
    	        double equation=0;
    	        for(float y_trier = 300*zoom; y_trier >= -300*zoom; y_trier=y_trier-zoom) {
    	        for(float x_trier = -300*zoom; x_trier <= 300*zoom; x_trier=x_trier+zoom) {
    				for (int x=0; x < koef.length; x++) {
    					equation += Math.pow(x_trier,degree [x])*koef [x];
    				}
    				System.out.println(equation-equation%zoom);
    				if(equation-equation%zoom==y_trier) {	
    				g.drawLine(Math.round(x_trier/zoom+300),Math.round(300-y_trier/zoom),Math.round(x_trier/zoom+300)+5,Math.round(300-y_trier/zoom));
    				System.out.println(x_trier + " " + y_trier + " ");
    				}
    				equation=0;
    	        }	
    	        }
			}
		});
		btnDraw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDraw.setBounds(170, 677, 250, 23);
		Drawing_Function.getContentPane().add(btnDraw);
		
		JLabel lbly = new JLabel("y =");
		lbly.setHorizontalAlignment(SwingConstants.CENTER);
		lbly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbly.setBounds(10, 640, 60, 40);
		Drawing_Function.getContentPane().add(lbly);

        txtkoef = new JTextField();
		txtkoef.setBounds(70, 650, 40, 20);
		Drawing_Function.getContentPane().add(txtkoef);
		txtkoef.setColumns(10);

		JLabel lblx = new JLabel("*x^");
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblx.setBounds(110, 650, 50, 25);
		Drawing_Function.getContentPane().add(lblx);

        textdegree = new JTextField();
		textdegree.setColumns(10);
		textdegree.setBounds(160, 650, 40, 20);
		Drawing_Function.getContentPane().add(textdegree);

		JButton btnAddAnotherMonomial = new JButton("Add another Monomial");
		btnAddAnotherMonomial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Monomial mon = new Monomial(x);
				Monomial_Collection.add(mon);
				x += 170;
				Drawing_Function.revalidate();
				Drawing_Function.repaint();
			}
		});
		btnAddAnotherMonomial.setBounds(10, 677, 150, 23);
		Drawing_Function.getContentPane().add(btnAddAnotherMonomial);
		
		JLabel lblzoom = new JLabel("Zoom:");
		lblzoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblzoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblzoom.setBounds(430, 677, 70, 23);
		Drawing_Function.getContentPane().add(lblzoom);
		
        textzoom = new JTextField();
        textzoom.setColumns(10);
        textzoom.setBounds(510, 677, 100, 23);
		Drawing_Function.add(textzoom);
	}
    
}
