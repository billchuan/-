package Xx;

import java.awt.*;

import javax.swing.JFrame;
 
public class Test extends JFrame {
 
	private static final int width = 400;
	private static final int heigth = 400;   
 
	private static int window_width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int window_heigth = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public Test(){
		super("Test");
		this.setBackground(Color.black);
		this.setLocation((window_width-width)/2,(window_heigth-heigth)/2);
		this.setSize(width, heigth);
		this.setLayout(getLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		double x,y,r;
		Image image = this.createImage(width, heigth);
		Graphics p = image.getGraphics();
		for (int i = -2; i < 90; i++) {
			for (int j = -2; j < 90; j++) {
				r=Math.PI/45+Math.PI/45*i*(1-Math.sin(Math.PI/45*j))*18;
				x=r*Math.cos(Math.PI/45*j)*Math.sin(Math.PI/45*i)+width/2;
				y=-r*Math.sin(Math.PI/45*j)+heigth/3;
				p.setColor(Color.magenta);
				p.fillOval((int)x, (int)y, 2, 2);
			}
			g.drawImage(image,0,0,this);
		}
	}
	
	
	public static void main(String[] args) {
		new Test();
	}

}
