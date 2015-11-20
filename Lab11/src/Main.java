import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
public class Main extends Applet {
    int i = 0;
    Timer t;
    int speed =30;
    Button b;
    TextField tf;
    boolean movingRight = true;
    public void init(){
        t= new Timer(1000/speed,new TimerListener());
        t.start();
        b = new Button("Update Rate");
        b.addActionListener(new ButtonListener());
        tf = new TextField("30");
        tf.addActionListener(new TFListener());
        tf.setBounds(200,250,200,200);
        tf.setColumns(5);
        add(tf);
        b.setBounds(200,250,100,100);
        add(b);
    }
    public void paint(Graphics g) {
        g.drawRect(0, 225, 450, 450);
        g.setColor(Color.cyan);
        g.fillOval(i, 337, 40, 40);
    }

    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if( i>410){
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

            // Force a call to the paint method.
            repaint();
        }
    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try{
                speed = Integer.parseInt(tf.getText());
                t.stop();
                t= new Timer(1000/speed,new TimerListener());
                t.start();
                //System.out.println("Button Pressed");
            }catch (Exception exc){

            }

        }
    }
    private class TFListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            tf.setText(e.getActionCommand());
        }
    }
}
