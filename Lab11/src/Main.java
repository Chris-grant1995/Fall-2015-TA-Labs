import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
public class Main extends Applet implements ActionListener {
    int i = 20;
    int waitAmount = 300000;
    int speed = 30;
    TextField tf;
    String message;
    Frame f = new Frame("Lab 11");
    boolean movingRight = true;
    public void paint(Graphics g) {
        //
        //g.draw3DRect(0, 0, 200, 200, false);
        Timer t = new Timer(speed,null);
        t.start();

        super.paintComponents(g);
        g.drawRect(0, 0, 200, 200);
        g.setColor(Color.cyan);
        g.fillOval(i, 100, 40, 40);
        Button b = new Button("Test");
        b.addActionListener(this);
        tf = new TextField(Integer.toString(speed));
        message = "Speed: " + tf.getText();
        tf.setBounds(200,0,200,200);
        add(tf);
        b.setBounds(200,200,100,100);
        add(b);
        if( i>=200){
            movingRight = false;
        }
        else if(i <=0){
            movingRight = true;
        }
        if(movingRight){
            i ++;
        }
        else{
            i--;
        }
        /*try{
            Thread.sleep(1000/60);
        }catch (Exception e){

        }*/

        //Thread.sleep(200);
        //g.drawOval();
        repaint();

        g.drawString(message,40,20);


    }
    public void actionPerformed(ActionEvent evt) {
        speed++;

    }
}