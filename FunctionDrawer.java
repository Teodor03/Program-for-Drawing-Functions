package readyclass;

import java.awt.Color;
import java.awt.Graphics;

public class FunctionDrawer {
	Graphics Graphics_Platform;
	Float [] koef;
	Float [] degree;
	public FunctionDrawer(Float [] koef,Float [] degree,Graphics graphics_Platform){
		Graphics_Platform = graphics_Platform;
		this.koef = koef;
		this.degree = degree;		
	}
	public Graphics getGraphics_Platform() {
		return Graphics_Platform;
	}
	public void setGraphics_Platform(Graphics graphics_Platform) {
		Graphics_Platform = graphics_Platform;
	}
	public Float[] getKoef() {
		return koef;
	}
	public void setKoef(Float[] koef) {
		this.koef = koef;
	}
	public Float[] getdegree() {
		return degree;
	}
	public void setdegree(Float[] degree) {
		this.degree = degree;
	}
	
	public void Draw_Function(){
		Graphics_Platform.clearRect(0, 0, 601, 601);
		Graphics_Platform.setColor(Color.BLUE);
        double equation=0;
        for(float y_trier = 300; y_trier >= -300; y_trier--) {
        for(float x_trier = -300; x_trier <= 300; x_trier++) {
			for (int x=0; x < koef.length; x++) {
				equation += Math.pow(x_trier,degree [x])*koef [x];
			}
			if(Math.round(equation)==y_trier) {	
			Graphics_Platform.drawLine(Math.round(x_trier+300),Math.round(300-y_trier),Math.round(x_trier+300)+5,Math.round(300-y_trier));
			}
			equation=0;
        }	
        }
	}
	
	
	
	
	
	
	
}
