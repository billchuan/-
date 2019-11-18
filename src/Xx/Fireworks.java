package Xx;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

public class Fireworks extends Applet implements MouseListener,Runnable
{
  int x,y;
  int top,point;


 public void init()
 {
    x = 0;
    y = 0;
    setBackground(Color.black);
    addMouseListener(this);
 }

 public void paint(Graphics g)
 { 
  
 }
 
 
 public static void main(String args[])

  {
    Fireworks applet = new Fireworks();
    JFrame frame = new JFrame("³ÌÐò²âÊÔ");
    frame.addWindowListener(new WindowAdapter() { 

        public void windowClosing(WindowEvent e)

      {
        System.exit(0);
      }
    });
    frame.getContentPane().add(
      applet, BorderLayout.CENTER);
    frame.setSize(800,400);
    applet.init();
    applet.start();
    frame.setVisible(true);
  }
  

 public void run()
 {
  
  Graphics g1;
  g1 = getGraphics();
  int y_move,y_click,x_click;
  int v;
  x_click = x;
  y_click = y;
  y_move = 400;
  v = 3;
  int r,g,b;

  while(y_move > y_click)
  {
    g1.setColor(Color.black);
    g1.fillOval(x_click,y_move,5,5);
    y_move -= 5;
    r = (((int)Math.round(Math.random()*4321))%200)+55;
    g = (((int)Math.round(Math.random()*4321))%200)+55;
    b = (((int)Math.round(Math.random()*4321))%200)+55;
    g1.setColor(new Color(r,g,b));
    g1.fillOval(x_click,y_move,5,5);
    for(int j = 0 ;j<=10;j++)
    {
      if(r>55) r -= 20;
      if(g>55) g -= 20;
      if(b>55) b -=20;
      g1.setColor(new Color(r,g,b));
      g1.fillOval(x_click,y_move+j*5,5,5);
    }
    g1.setColor(Color.black);
    g1.fillOval(x_click,y_move+5*10,5,5);

    try
     {
        Thread.currentThread().sleep(v++);
     }catch (InterruptedException e) {}
    }
    
    for(int j=12;j>=0;j--)
    {
     g1.setColor(Color.black);
     g1.fillOval(x_click,y_move+(j*5),5,5);
    try
      {
        Thread.currentThread().sleep((v++)/3);
      } catch (InterruptedException e) {}
     }
  
  y_move = 400;
  g1.setColor(Color.black);
  while(y_move > y_click)
  {
    g1.fillOval(x_click-2,y_move,9,5);
    y_move -= 5;
  }
  
  v = 15;
  for(int i=0;i<=25;i++)
  {
    r = (((int)Math.round(Math.random()*4321))%200)+55;
    g = (((int)Math.round(Math.random()*4321))%200)+55;
    b = (((int)Math.round(Math.random()*4321))%200)+55;
    g1.setColor(new Color(r,g,b));
    g1.drawOval(x_click-3*i,y_click-3*i,6*i,6*i);
    if(i<23)
   {
    g1.drawOval(x_click-3*(i+1),y_click-3*(i+1),6*(i+1),6*(i+1));
    g1.drawOval(x_click-3*(i+2),y_click-3*(i+2),6*(i+2),6*(i+2));
   }
   try
    {
        Thread.currentThread().sleep(v++);
      } catch (InterruptedException e) {}
      g1.setColor(Color.black);
   g1.drawOval(x_click-3*i,y_click-3*i,6*i,6*i);
     
   }
 }
 

 public void mousePressed(MouseEvent e)
  {
   x = e.getX();
   y = e.getY();
   Thread one;
   one = new Thread(this);
   one.start();
   one = null;
   }
 
  public void mouseReleased(MouseEvent e)
  {  
  }
 
  public void mouseEntered(MouseEvent e)
  {
  }
 
  public void mouseExited(MouseEvent e)
  {
  }
 
  public void mouseClicked(MouseEvent e)
  {
  }
 
}